package mskubilov.set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 20.04.17
 */

/**
 * SimpleLinkedSet based on LinkedList.
 * @param <E>
 */
public class SimpleLinkedSet<E> implements Iterable<E> {
    /**
     * inner container of values based on LinkedList.
     */
    private LinkedList<E> values = new LinkedList<E>();

    /**
     * @param e element to add in SimpleLinkedSet.
     */
    public void add(E e) {
        if (values.contains(e)) {
            return;
        }
        values.add(e);
    }

    /**
     * @return size of SimpleLinkedSet.
     */
    public int size() {
        return this.values.size();
    }

    /**
     * @return iterator of SimpleLinkedSet.
     */
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * iiner class of iterator for SimpleLinkedSet.
     */
    private class Itr implements Iterator<E> {
        /**
         * takes iterator from inner LinkedList.
         */
        private Iterator<E> iterator = values.iterator();
        /**
         * @return availability of next element.
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * @return current element and goes to next position.
         */
        @Override
        public E next() {
            return iterator.next();
        }
    }
}
