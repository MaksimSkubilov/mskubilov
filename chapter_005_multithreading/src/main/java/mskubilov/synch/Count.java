package mskubilov.synch;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 29.05.17
 */
public class Count {

    /**
     * Value to increment.
     */
    private int value;

    /**
     * @param value to increment.
     */
    public Count(int value) {
        this.value = value;
    }

    /**
     * Example of synchronized method.
     * @return incremented value.
     */
    public synchronized int increment1() {
        for (int i = 0; i < 10_000_000; i++) {
            value++;
        }
        return value;
    }

    /**
     * Example of synchronized block.
     * @return incremented value.
     */
    public int increment2() {
        synchronized (this) {
            for (int i = 0; i < 10_000_000; i++) {
                synchronized (this) {
                    value++;
                }
            }
        }
        return value;
    }

    /**
     * @return value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Make two threads for concurrent incrementing value.
     */
    public void concurrentIncrement() {
        Runnable run;
        run = new Runnable() {
            @Override
            public void run() {
                System.out.println(increment1()); // using sout to show which way works faster.
                System.out.println(increment2());
            }
        };
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
