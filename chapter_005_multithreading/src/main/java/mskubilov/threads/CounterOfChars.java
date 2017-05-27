package mskubilov.threads;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.05.17
 */
public class CounterOfChars extends Thread {

    /**
     * Text for counting.
     */
    private final String text;

    /**
     * Default char for counting.
     */
    private char sub = ' ';

    /**
     * @param sub - not default char for counting.
     * @param text - text for counting.
     */
    public CounterOfChars(char sub, String text) {
        this.text = text;
        this.sub = sub;
    }

    /**
     * Count text elements.
     */
    public void count() {
        int count = 0;
        int i = 0;
        try {
            Thread.sleep(999, 500000); // need sleeping to show counted elements when interrupted.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        while (!isInterrupted() && i < this.text.length()) {
            if (this.text.charAt(i) == sub) {
                count++;
            }
            i++;
        }
            if (!isInterrupted()) {
                System.out.printf("Was counted %s chars of '%s'\n", count, sub);
            } else {
                System.out.printf("%s was interrupted! Was counted %s chars of '%s' before interruption\n", Thread.currentThread().getName(), count, sub);
            }
    }

    /**
     * run() for Thread.
     */
    @Override
    public void run() {
        count();
    }

}

