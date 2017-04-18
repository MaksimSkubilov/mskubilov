package mskubilov;

import java.util.Iterator;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.04.17
 */

/**
 * convert of inner iterators.
 */
public interface IteratorConversion {
    /**
     * @param it Iterator of Integer Iterators to convert.
     * @return Iterator of Integer elements.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
