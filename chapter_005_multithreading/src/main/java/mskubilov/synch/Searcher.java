package mskubilov.synch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 30.05.17
 */

/**
 * Concurrent Searcher. Searches for some text in all .txt files from file system.
 * First starts max to 2 Threads for scanning all system's txt.files, and then 1 Thread for searching some text in them files, concurrently with scanning.
 */
public class Searcher {
    /**
     * Some text for searching match.
     */
    private String text;
    /**
     * If true then process stops when found first match.
     */
    private boolean stopper;
    /**
     * All PC's file system catalogs.
     */
    private static final File[] ROOTS = File.listRoots();
    /**
     * Index of catalog in this.ROOTS for starting threads and using it by them.
     */
    private volatile int rootIndex = 0;
    /**
     * Concurrent Deque of all founded .txt files on board.
     */
    private BlockingDeque<File> allFiles = new LinkedBlockingDeque<>();
    /**
     * List of Threads searching all txt. files
     */
    private List<Thread> allThreads = new CopyOnWriteArrayList<>();
    /**
     * @param text for searching.
     * @param stopper for searching. If true program stops when found first match.
     */
    public Searcher(String text, boolean stopper) {
        this.text = text;
        this.stopper = stopper;
    }

    /**
     * Starts to fill this.allFiles with all system .txt files.
     * @param i number of catalog in this.Roots.
     */
    private void fillAllFiles(int i) {
        for (; i < ROOTS.length;) {
            File[] dir = ROOTS[i].listFiles();
            if (dir != null) {
                searchDirectory(dir);
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
            if(fileType != null && fileType.equals("text/plain")) {
                this.allFiles.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches directory (and recursively calls itself when finds directory) and files in directory.
     * @param dir directory.
     */
    private void searchDirectory(File[] dir) {
        if (dir != null) {
            for (int i = 0; i < dir.length; i++) {
                if (dir[i].isDirectory()) {
                    searchDirectory(dir[i].listFiles());
                } else {
                    searchFile(dir[i]);
                }
            }
        }
    }

    /**
     * Searches text in some file
     */
    private void search() {
        int i = 0;
        FileReader streamFromFile;
        String line;
        File file;
        try {
            while(this.allThreads.size() != 0) {
                if (i == 0) {
                    file = this.allFiles.pollFirst(2, TimeUnit.SECONDS);
                    i++;
                } else {
                    file = this.allFiles.pollLast(2, TimeUnit.SECONDS);
                    i--;
                }
                if (file != null) {
                    streamFromFile = new FileReader(file);
                    BufferedReader streamReader = new BufferedReader(streamFromFile);
                    while ((line = streamReader.readLine()) != null) {
                        if (line.contains(text)) {
                            System.out.printf("%s %s\n", "Found file", file.getAbsolutePath());
                            if (stopper) {
                                System.out.println("Stopping all threads...");
                                for (Thread thread : this.allThreads) {
                                    thread.interrupt();
                                }
                                Thread.currentThread().interrupt();
                            }
                            break;
                        }
                    }
                }
                for (Thread thread : this.allThreads) {
                    if (!thread.isAlive() || thread.isInterrupted()) {
                        this.allThreads.remove(thread);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            //restart search() if thrown FileNotFoundException
            search();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts threads for filling files and searching text.
     */
    public void searchTextInFile() {
        Thread t;
        while (this.rootIndex <= 1) {
            t = filesSearchThread(rootIndex++);
            this.allThreads.add(t);
            t.start();
        }
        t = textSearchThread();
        t.start();
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
                System.out.println("Start of searching.");
                search();
            }
        };
    }

    public static void main(String[] args) {
        Searcher searcher = new Searcher("some text", true);
        searcher.searchTextInFile();
    }
}
