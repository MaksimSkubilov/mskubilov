package mskubilov.list;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 18.04.17
 */

/**
 * SimpleContainer. Primitive container.
 * @param <E> generic.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * @param e element E.
     */
    void add(E e);

    /**
     * @param index of element.
     * @return element E.
     */
    E get(int index);
}
