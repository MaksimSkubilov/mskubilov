package mskubilov.threads;

import org.junit.Test;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 25.05.17
 */
public class CounterTest {
    /**
     * Pseudo test to show correct counting.
     */
    @Test
    public void whenStartCountingThenShowFinishAfterAllCounting() {
        System.out.println("Start");
        Thread t1 = new CounterOfWords("посчитай    количество   слов в  этой строке");
        Thread t2 = new CounterOfChars(' ', " посчитай количество пробелов ");
        Thread t3 = new CounterOfChars('с', "посчитай количество букв 'с'");
        t2.start();
        t1.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }

    /**
     * Pseudo test to show how interruption works. Need to run several times to see different results in console.
     * Maybe you could need to change sleeping time in Counter class method count() to see difference on your machine.
     */
    @Test
    public void whenCountingMoreThanOneSecondThenInterruptThreadShowingSemiResults() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            sb.append('a').append(' ');
        }

        String text = sb.toString();
        System.out.println("Start");
        Thread t1 = new CounterOfWords(text);
        Thread t2 = new CounterOfChars(' ', text);
        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
            if (t1.isAlive()) {
                t1.interrupt();
                t1.join();
            } else {
                t1.join();
            }
            if (t2.isAlive()) {
                t2.interrupt();
                t2.join();
            } else {
                t2.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }
}