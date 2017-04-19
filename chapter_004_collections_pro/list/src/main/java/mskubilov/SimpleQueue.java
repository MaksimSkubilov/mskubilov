package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 19.04.17
 */

/**
 * SimpleQueue realization based on SimpleLinkedArray.
 * @param <E> generic.
 */
public class SimpleQueue<E> extends SimpleLinkedArray<E> {

    /**
     * put element in the end of Queue.
     * @param e element.
     * @return offer's result.
     */
    public boolean offer(E e) {
        add(e);
        return true;
    }

    /**
     * @return first element in Queue.
     */
    public E peek() {
        return get(0);
    }

    /**
     * @return and delete first element in Queue.
     */
    public E poll() {
        E result = peek();
        removeFirst();
        return result;
    }
}
