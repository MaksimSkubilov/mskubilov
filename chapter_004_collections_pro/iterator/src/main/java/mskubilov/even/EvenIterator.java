package mskubilov.even;

import java.util.Iterator;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 15.04.17
 */

/**
 * Iterator of even numbers only.
 * @param <Integer> - int.
 */
public class EvenIterator<Integer> implements Iterator<java.lang.Integer> {
    /**
     * iterable array.
     */
    private final int[] array;
    /**
     * array index position.
     */
    private int index = 0;

    /**
     * @param array - iterable array.
     */
    public EvenIterator(int[] array) {
        this.array = array;
    }

    /**
     * @return hasNext try to return element or not
     */
    @Override
    public boolean hasNext() {
        return index < this.array.length;
    }

    /**
     * @return next even element.
     */
    @Override
    public java.lang.Integer next() {
        int result = 0;
        boolean isEven = false;
        while (!isEven) {
            if (this.array[index] % 2 == 0) {
                isEven = true;
                result = this.array[index++];
            } else {
                index++;
            }
        }
        return result;
    }
}
