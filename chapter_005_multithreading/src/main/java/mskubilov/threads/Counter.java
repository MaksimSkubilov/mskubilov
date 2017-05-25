package mskubilov.threads;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 25.05.17
 */
public class Counter extends Thread {

    /**
     * Flag of counting (chars or words).
     */
    private boolean isChar = true;

    /**
     * Text for counting.
     */
    private final String text;

    /**
     * Default char for counting.
     */
    private char sub = ' ';

    /**
     * @param isSpace - choose of counting words or spaces.
     * @param text - text for counting.
     */
    public Counter(boolean isSpace, String text) {
        this.text = text;
        this.isChar = isSpace;
    }

    /**
     * @param sub - not default char for counting.
     * @param text - text for counting.
     */
    public Counter(char sub, String text) {
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
        while (!isInterrupted() && isChar && i < this.text.length()) {
            if (this.text.charAt(i) == sub) {
                count++;
            }
            i++;
        }
        while (!isInterrupted() && !isChar && i < this.text.length()) {
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
        if (isChar) {
            if (!isInterrupted()) {
                System.out.printf("Was counted %s chars of '%s'\n", count, sub);
            } else {
                System.out.printf("%s was interrupted! Was counted %s chars of '%s' before interruption\n", Thread.currentThread().getName(), count, sub);
            }
        } else if (!isChar) {
            if (!isInterrupted()) {
                System.out.printf("Was counted %s words\n", count);
            } else {
                System.out.printf("%s was interrupted! Was counted %s words before interruption\n", Thread.currentThread().getName(), count);
            }

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
