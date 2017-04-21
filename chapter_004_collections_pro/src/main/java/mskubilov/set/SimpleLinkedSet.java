package mskubilov.set;

import mskubilov.list.SimpleLinkedArray;

import java.util.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 2.0
 * @since 20.04.17
 */

/**
 * SimpleLinkedSet based on LinkedList.
 * @param <E> generic.
 */
public class SimpleLinkedSet<E extends Comparable> implements Iterable<E> {
    /**
     * inner container of values based on LinkedList.
     */
    private SimpleLinkedArray<E> values = new SimpleLinkedArray<E>();

    /**
     * @param e element to add in SimpleLinkedSet.
     */
    public void add(E e) {
        if (simpleBinarySearch(e) == 1) {
            return;
        }
        values.add(e);
    }
    /**
     * @param e element to add in SimpleLinkedSet.
     */
    public void addOutOfBinary(E e) {
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            if (it.next().equals(e)) {
                return;
            }
        }
        values.add(e);
    }

    /**
     * @param e element for searching.
     * @return result of searching. -1 if element was not found and 1 otherwise.
     */
    private int simpleBinarySearch(E e) {
        int result = -1;
        List<E> sorted = new ArrayList<E>();
        Iterator<E> it = this.iterator();
        int i = 0;
        while (it.hasNext()) {
            sorted.add(it.next());
        }
        Collections.sort(sorted);
        int low = 0, high = this.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (sorted.get(mid).compareTo(e) == 0) {
                result = 1;
                break;
            } else if (sorted.get(mid).compareTo(e) == -1) {
                low = mid + 1;
            } else if (sorted.get(mid).compareTo(e) == 1) {
                high = mid;
            }
        }
        return result;
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
     * inner class of iterator for SimpleLinkedSet.
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
