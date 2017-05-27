package mskubilov.jmm;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.05.17
 */
public class Demo implements Runnable {
    /**
     * Value to increment for demo.
     */
    private int value;

    /**
     * Count of Increments.
     */
    private int count;

    /**
     * @param value value to increment.
     * @param count of increments
     */
    public Demo(int value, int count) {
        this.value = value;
        this.count = count;
    }

    /**
     * @return value.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Increment value.
     */
    @Override
    public void run() {
        int dynamicCount = 0;
        while (dynamicCount < count) {
            value++;
            dynamicCount++;
        }
    }
}
