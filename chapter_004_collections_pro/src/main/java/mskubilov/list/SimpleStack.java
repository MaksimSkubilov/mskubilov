package mskubilov.list;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 19.04.17
 */

/**
 * SimpleStack realization based on SimpleLinkedArray.
 * @param <E> generic.
 */
public class SimpleStack<E> extends SimpleLinkedArray<E> {

    /**
     * put element on the top.
     * @param e element.
     */
    public void push(E e) {
        add(e);
    }

    /**
     * @return element on the top.
     */
    public E peek() {
        return get(size() - 1);
    }

    /**
     * @return element on the top and erase it from SimpleStack.
     */
    public E pop() {
        E result = peek();
        removeLast();
        return result;
    }
}
