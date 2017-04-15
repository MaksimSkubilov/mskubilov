package mskubilov.prime;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
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
     * @param array - iterable array.
     */
    public PrimeIterator(int[] array) {
        this.array = array;
    }

    /**
     * @return return has next prime element or not
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        BigInteger number = null;
        for (int i = index; i != this.array.length; i++) {
            number = BigInteger.valueOf(this.array[i]);
            if (number.isProbablePrime((int) Math.log(12311))) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return next prime element.
     */
    @Override
    public Object next()  {
        return hasNext() ? nextPrime() : null;
    }

    /**
     * @return next prime element.
     */
    private Integer nextPrime() {
        BigInteger result = null;
        for (int i = index; i != this.array.length; i++) {
            result = BigInteger.valueOf(this.array[i]);
            if (result.isProbablePrime((int) Math.log(12311))) {
                result = BigInteger.valueOf(this.array[i]);
                index = ++i;
                break;
            }
        }
        return result.intValue();
    }
}
