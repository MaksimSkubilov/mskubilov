package mskubilov.notifywait;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 03.06.17
 */
public class ThreadPool {
    /**
     * Threads's list by processors count.
     */
    private final ArrayList<Thread> threadList;
    /**
     * Queue filled by Work to do.
     */
    private final BlockingQueue<Work> workQueue;

    public ThreadPool() {
        this.threadList = new ArrayList<>();
        this.workQueue = new LinkedBlockingQueue<>();
        fillThreadList();
    }

    /**
     * Fill this.threadList with Threads doing some useful Work.
     */
    private void fillThreadList() {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            this.threadList.add(new Thread() {

                @Override
                public void run() {
                    while (isAlive()) {
                        synchronized (workQueue) {
                            while (workQueue.isEmpty()) {
                                try {
                                    System.out.printf("%s is waiting for work\n", Thread.currentThread().getName());
                                    workQueue.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        try {
                            workQueue.take().doWork();
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /**
     * Start all Threads in ThreadPool.
     */
    public void execute() {
        for (Thread thread : this.threadList) {
            thread.start();
        }
    }

    /**
     * Fill Queue with Work Pool to do.
     * @param work Work.
     */
    public void add(Work work) {
        synchronized (this.workQueue) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.workQueue.add(work);
            workQueue.notify();
        }
    }

    /**
     * Work.
     * Some class with useful work.
     */
    public class Work {

        private int workNumber;

        public Work(int number) {
            this.workNumber = number;
        }
        /**
         * do some useful work.
         */
        public void doWork() {
            System.out.printf("%s finished useful work %s\n", Thread.currentThread().getName(), workNumber);
        }
    }
}
