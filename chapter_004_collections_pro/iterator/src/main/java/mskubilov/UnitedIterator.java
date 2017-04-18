package mskubilov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.04.17
 */

/**
 * UnitedIterator.
 */
public class UnitedIterator implements IteratorConversion, Iterator<Integer> {
    /**
     * source Iterator includes several Integer Iterators.
     */
    private Iterator<Iterator<Integer>> sourceIterator;
    /**
     * One of inner Iterators of sourceIterator.
     */
    private Iterator<Integer> innerIterator;

    /**
     * @param it Iterator to convert.
     * @return this Object as an Iterator.
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.sourceIterator = it;
        if (this.sourceIterator.hasNext()) {
            this.innerIterator = this.sourceIterator.next();
        }
        return this;
    }

    /**
     * @return next element existing.
     */
    @Override
    public boolean hasNext() {
        return this.sourceIterator.hasNext() || this.innerIterator.hasNext();
    }

    /**
     * @return current element of Iterator.
     */
    @Override
    public Integer next() {
        Integer result = null;
        if (!this.innerIterator.hasNext() && this.sourceIterator.hasNext()) {
            this.innerIterator = this.sourceIterator.next();
        }
        if (this.innerIterator.hasNext()) {
            result = this.innerIterator.next();
        } else {
            throw new NoSuchElementException("End of Iterator elements");
        }
        return result;
    }
}
