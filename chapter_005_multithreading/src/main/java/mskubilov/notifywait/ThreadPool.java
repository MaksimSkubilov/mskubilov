package mskubilov.notifywait;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
    private BlockingQueue<Work> workQueue;

    public ThreadPool() {
        this.threadList = new ArrayList<>();
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
                    try {
                        while (workQueue.size() > 0) {
                            workQueue.take().doWork();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
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
     * @param workCount count of Work.
     */
    public void fillWork(int workCount) {
        this.workQueue = new ArrayBlockingQueue<Work>(workCount);
        for (int i = 1; i <= workCount; i++) {
            this.workQueue.add(new Work(i));
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
