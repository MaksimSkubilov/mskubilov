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
 */
public class EvenIterator implements Iterator {
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
     * @return hasNext return has next even element or not
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i != this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return next even element.
     */
    @Override
    public Object next() {
        return hasNext() ? nextEven() : null;
    }

    /**
     * @return next even element.
     */
    private Integer nextEven() {
        Integer result = null;
        for (int i = index; i != this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                result = this.array[i];
                index = ++i;
                break;
            }
        }
        return result;
    }
}
