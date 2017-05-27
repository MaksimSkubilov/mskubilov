package mskubilov.threads;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.05.17
 */
public class CounterOfWords extends Thread {
    /**
     * Text for counting.
     */
    private final String text;

    /**
     * Default char for counting.
     */
    private char sub = ' ';

    /**
     * @param text - text for counting.
     */
    public CounterOfWords(String text) {
        this.text = text;
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
            if (this.text.charAt(i) != sub) {
                count++;
                for (int j = i; j != this.text.length(); j++) {
                    if (this.text.charAt(j) == sub) {
                        i = j;
                        break;
                    }
                    i = this.text.length();
                }
            }
            i++;
        }

        if (!isInterrupted()) {
            System.out.printf("Was counted %s words\n", count);
        } else {
            System.out.printf("%s was interrupted! Was counted %s words before interruption\n", Thread.currentThread().getName(), count);
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
