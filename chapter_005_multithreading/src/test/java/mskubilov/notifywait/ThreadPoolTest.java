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
        tp.fillWork(50);
        tp.execute();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}