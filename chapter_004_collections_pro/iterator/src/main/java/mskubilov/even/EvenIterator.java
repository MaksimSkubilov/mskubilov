package mskubilov.even;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
     * position of next Even.
     */
    private int nextEvenIndex;

    /**
     * @param array - iterable array.
     */
    public EvenIterator(int[] array) {
        this.array = array;
        this.nextEvenIndex = nextEvenIndex();
    }

    /**
     * @return hasNext return has next even element or not
     */
    @Override
    public boolean hasNext() {
        return nextEvenIndex != -1;
    }

    /**
     * @return next even element.
     */
    @Override
    public Object next() {
        Object result = null;
        if (hasNext()) {
            result = this.array[nextEvenIndex];
            this.index = ++this.nextEvenIndex;
            this.nextEvenIndex = nextEvenIndex();
        }
        if (result == null) {
            throw new NoSuchElementException("There is not Even numbers left in array!");
        }
        return result;
    }

    /**
     * @return next even element.
     */
    private int nextEvenIndex() {
        int result = -1;
        for (int i = index; i != this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
