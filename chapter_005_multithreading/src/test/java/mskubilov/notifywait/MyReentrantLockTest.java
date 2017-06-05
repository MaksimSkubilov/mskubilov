package mskubilov.notifywait;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 05.06.17
 */
public class MyReentrantLockTest {

    /**
     * My Lock.
     */
    private MyReentrantLock lock = new MyReentrantLock();

    /**
     * Variable for test.
     */
    private int count = 0;

    /**
     * Method calls to lock and another method calls to lock too.
     */
    private void count() {
        System.out.printf("%s trying to lock count()\n", Thread.currentThread().getName());
        lock.lock();
        System.out.printf("%s has locked count()\n", Thread.currentThread().getName());
        increment();
        System.out.printf("%s unlocks count()\n", Thread.currentThread().getName());
        lock.unlock();
    }

    /**
     * Method calls to lock and increments count.
     */
    private void increment() {
        System.out.printf("%s trying to lock increment()\n", Thread.currentThread().getName());
        lock.lock();
        System.out.printf("%s locks increment()\n", Thread.currentThread().getName());
        count++;
        System.out.printf("%s unlocks increment()\n", Thread.currentThread().getName());
        lock.unlock();
    }

    /**
     * @return this.count variable.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * @return runnable that runs count().
     */
    public Runnable getRunnableCount() {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    count();
                }
            }
        };
    }

    /**
     * @return runnable that runs increment()
     */
    public Runnable getRunnableGenerate() {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    increment();
                }
            }
        };
    }

    /**
     * Test of my Lock.
     */
    @Test
    public void testMyReentrantLock() {
        MyReentrantLockTest lockTest = new MyReentrantLockTest();
        Thread t1 = new Thread(lockTest.getRunnableCount());
        Thread t2 = new Thread(lockTest.getRunnableGenerate());
        t2.start();
        t1.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(lockTest.getCount(), is(20));
    }
}