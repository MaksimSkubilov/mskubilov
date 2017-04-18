package mskubilov.prime;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 2.0
 * @since 15.04.17
 */
public class PrimeIterator implements Iterator {
    /**
     * iterable array.
     */
    private final int[] array;
    /**
     * array index position.
     */
    private int index = 0;
    /**
     * position of next Prime.
     */
    private int nextPrimeIndex;
    /**
     * @param array - iterable array.
     */
    public PrimeIterator(int[] array) {
        this.array = array;
        this.nextPrimeIndex = nextPrimeIndex();
    }

    /**
     * @return return has next prime element or not
     */
    @Override
    public boolean hasNext() {
       return nextPrimeIndex != -1;
    }

    /**
     * @return next prime element.
     */
    @Override
    public Object next()  {
        Object result = null;
        if (hasNext()) {
            result = this.array[nextPrimeIndex];
            this.index = ++this.nextPrimeIndex;
            this.nextPrimeIndex = nextPrimeIndex();
        }
        if (result == null) {
            throw new NoSuchElementException("There is no Prime numbers left in array!");
        }
        return result;
    }

    /**
     * @return next prime element.
     */
    private int nextPrimeIndex() {
        int result = -1;
        BigInteger number = null;
        for (int i = index; i != this.array.length; i++) {
            number = BigInteger.valueOf(this.array[i]);
            if (number.isProbablePrime((int) Math.log(12311))) {
                result = i;
                break;
            }
        }
        return result;
    }
}
