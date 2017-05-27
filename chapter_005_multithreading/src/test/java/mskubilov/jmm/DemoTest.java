package mskubilov.jmm;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 027 27.05.17
 */
public class DemoTest {
    /**
     * Test of correct incrementation by one Thread.
     */
    @Test
    public void testDemoWithOneThread() {
        Demo demo = new Demo(0, 10_000_000);
        Thread t1 = new Thread(demo);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(demo.getValue() == 10_000_000, is(true));
    }
    /**
     * Test of wrong time-to-time incrementation by two Threads on big numbers
     * because of how Java Memory Model is connected with PC architecture.
     */
    @Test
    public void testDemoThreadsProblem() {
        Demo demo = new Demo(0, 10_000_000);
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo.getValue());
        assertThat(demo.getValue() != 20_000_000, is(true));
        //sometimes it increments 0 to 10_000_000 when t2 runs after t1 already ended it's work
        //usually it shows value between 10 millions and 20 millions.
        //sometimes shows 20 millions.
    }
}