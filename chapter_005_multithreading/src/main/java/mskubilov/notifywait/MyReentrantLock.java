package mskubilov.notifywait;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 05.06.17
 */

public class MyReentrantLock {

    /**
     * Lock's condition.
     */
    private boolean isLocked = false;
    /**
     * Count of locks by same thread.
     */
    private int lockCount = 0;
    /**
     * Thread trying to lock the Lock.
     */
    private Thread lockThread;

    /**
     * Method locks the Lock.
     */
    public synchronized void lock() {
        while (isLocked && Thread.currentThread() != lockThread) {
            try {
                System.out.printf("%s awaits for unlock\n", Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockCount++;
        lockThread = Thread.currentThread();
    }

    /**
     * Method unlocks the Lock.
     */
    public synchronized void unlock() {
        lockCount--;
        if (lockCount == 0) {
            isLocked = false;
            System.out.printf("Lock is unlocked by %s\n", Thread.currentThread().getName());
            notify();
        }
    }
}
