package mskubilov.notifywait;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 03.06.17
 */
public class ThreadPoolTest {
    /**
     * Pseudo test to show how ThreadPool is working.
     */
    @Test
    public void testThreadPool() {
        ThreadPool tp = new ThreadPool();
        tp.execute();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 50;) {
            for (int j = 0; j < 5; j++) {
                tp.add(tp.new Work(i + j));
            }
            i = i + 4;
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}