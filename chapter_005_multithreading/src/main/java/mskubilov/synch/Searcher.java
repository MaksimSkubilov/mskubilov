package mskubilov.synch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 30.05.17
 */

/**
 * Concurrent Searcher. Searches for some text in all .txt files of file system.
 * First starts 3 Threads for scanning root of users choice for txt.files and directories,
 * and then starts 1 Thread for searching some text in files, concurrently with scanning directories by ThreadPoolExecutor.
 */
public class Searcher {
    /**
     * Some text for searching match. Default false, changes by User's choice .
     */
    private String text = null;
    /**
     * If true then process stops when found first match. Default false, changes by User's choice.
     */
    private AtomicBoolean stopper = new AtomicBoolean(false);
    /**
     * Catalogs for searching text.
     */
    private final File[] roots;
    /**
     * Index of catalog in this.roots for starting threads and using it by them.
     */
    private volatile int rootIndex = 0;
    /**
     * Concurrent Deque of all found .txt files in directory.
     */
    private final BlockingDeque<File> allFiles = new LinkedBlockingDeque<>();
    /**
     * Concurrent Queue of all found directories for executor.
     */
    private final BlockingQueue<File> allDirs = new LinkedBlockingQueue<>();
    /**
     * List of starting Threads outside executor.
     */
    private final List<Thread> startingThreads = new CopyOnWriteArrayList<>();
    /**
     * Thread Pool for searching dir's and files.
     */
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            0, Runtime.getRuntime().availableProcessors(), 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    /**
     * Construct Searcher.
     * @param searchDir directory for searching.
     */
    Searcher(String searchDir) {
        if (searchDir.equals("0")) {
            this.roots = File.listRoots();
        } else {
            this.roots = new File(searchDir).listFiles();
        }
    }

    /**
     * Set stopper by User's entering.
     */
    void setStopperTrue() {
        stopper.set(true);
    }

    /**
     * Set text by User's entering.
     * @param text some text.
     */
    void setText(String text) {
        this.text = text;
    }

    /**
     * Starts to fill this.allFiles with all system .txt files. Using it justified because of User choosing to scan all files
     * on Windows and File.listFiles() returns floppy and system gets shock trying to scan it=).
     * @param i number of catalog in this.Roots.
     */
    private void fillAllFiles(int i) {
        for (; i < roots.length;) {
            if (roots[i] != null) {
                executor.execute(searchDirectory(roots[i]));
            } else {
                searchFile(roots[i]);
            }
            i = rootIndex++;
        }
    }

    /**
     * Matches txt. files with File.
     * @param file some file.
     */
    private void searchFile(File file) {
        Path source = file.toPath();
        try {
            String fileType = Files.probeContentType(source);
            if (fileType != null && fileType.equals("text/plain")) {
                this.allFiles.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches directory (and recursively calls itself when finds directory) and files in directory.
     * @param file some directory.
     * @return new Runnable object.
     */
    private Runnable searchDirectory(File file) {
        return new Runnable() {
            @Override
            public void run() {
                File[] files = file.listFiles();
                if (file.isDirectory() && files != null) {
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].isDirectory()) {
                            allDirs.add(files[i]);
                        } else {
                            searchFile(files[i]);
                        }
                    }
                }
            }
        };
    }

    /**
     * Searches text in some file.
     */
    private void search() {
        int i = 0;
        FileReader streamFromFile;
        String line;
        File file;
        File dir;
        try {
            while (text == null) {
                dir = allDirs.poll(1, TimeUnit.SECONDS);
                if (dir != null) {
                    executor.execute(searchDirectory(dir));
                }
            }
            while (!executor.isShutdown()) {
                dir = allDirs.poll(1, TimeUnit.SECONDS);
                if (dir == null && allFiles.isEmpty() && allDirs.isEmpty() && executor.getActiveCount() == 0) {
                    executor.shutdownNow();
                } else if (dir != null) {
                    executor.execute(searchDirectory(dir));
                }
                if (i == 0) {
                    file = this.allFiles.pollFirst();
                    i++;
                } else {
                    file = this.allFiles.pollLast();
                    i--;
                }
                if (file != null) {
                    streamFromFile = new FileReader(file);
                    BufferedReader streamReader = new BufferedReader(streamFromFile);
                    while ((line = streamReader.readLine()) != null) {
                        if (line.contains(text)) {
                            System.out.printf("%s %s\n", "Found file", file.getAbsolutePath());
                            if (stopper.get()) {
                                System.out.println("Stopping all threads...");
                                executor.shutdownNow();
                                for (Thread thread : this.startingThreads) {
                                    thread.interrupt();
                                }
                                Thread.currentThread().interrupt();
                            }
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            //restart search() if thrown FileNotFoundException
            search();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts threads for filling files and searching text.
     * @return textSearchThread reference.
     */
    Thread startSearching() {
        Thread t;
        while (this.rootIndex < Runtime.getRuntime().availableProcessors() - 1) {
            t = filesSearchThread(rootIndex++);
            this.startingThreads.add(t);
            t.start();
        }
        t = textSearchThread();
        t.start();
        return t;
    }

    /**
     * Method for awaiting searching results.
     * @param t textSearchThread reference.
     */
    void awaitResults(Thread t) {
        System.out.println("Start of searching.");
        try {
            t.join();
            System.out.println("End of searching.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param threadNumber current thread number
     * @return new Thread for filling files.
     */
    private Thread filesSearchThread(int threadNumber) {
        return new Thread() {
            public void run() {
                fillAllFiles(threadNumber);
            }
        };
    }

    /**
     * @return new Thread for searching text.
     */
    private Thread textSearchThread() {
        return new Thread() {
            public void run() {
                search();
            }
        };
    }

}
