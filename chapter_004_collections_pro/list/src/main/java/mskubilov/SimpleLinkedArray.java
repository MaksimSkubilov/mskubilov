package mskubilov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 3.0
 * @since 19.04.17
 */

/**
 * Primitive collection of linked dynamic array type.
 * @param <E> generic.
 */
public class SimpleLinkedArray<E> implements SimpleContainer<E> {
    /**
     * size of SimpleLinkedArray.
     */
    private int size;
    /**
     * Cell with first element.
     */
    private Cell<E> first;
    /**
     * Cell with last element.
     */
    private Cell<E> last;

    /**
     * add an element in the end of SimpleLinkedArray.
     * @param e element E.
     */
    @Override
    public void add(E e) {
        final Cell<E> l = last;
        final Cell<E> newNode = new Cell<E>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * @param index of element.
     * @return element by index.
     */
    @Override
    public E get(int index) {
        if (!isIndexValid(index)) {
            throw new IndexOutOfBoundsException();
        }
        return cell(index).item;
    }

    /**
     * remove last element.
     */
    void removeLast() {
        if (last.prev != null) {
            last.prev.next = null;
            last = last.prev;
        } else {
            last = null;
        }

    }

    /**
     * remove first element.
     */
    void removeFirst() {
        if (first.next != null) {
            first.next.prev = null;
            first = first.next;
        } else {
            first = null;
        }
    }

        /**
     * @param index of element to get.
     * @return element by index.
     */
    private Cell<E> cell(int index) {
        if (index < size / 2) {
            Cell<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Cell<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * @param index to validate.
     * @return index validation.
     */
    private boolean isIndexValid(int index) {
        return (index >= 0 && index < size);
    }

    /**
     * @return this size.
     */
    public int size() {
        return this.size;
    }

    /**
     * @return new iterator for SimpleLinkedArray.
     */
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * nested class of iterator of SimpleArray.
     */
    private class Itr implements Iterator<E> {
        /**
         * position of iterator.
         */
        private int position = 0;

        /**
         * @return availability of next element.
         */
        @Override
        public boolean hasNext() {
            return position < size;
        }

        /**
         * @return current element and goes to next position.
         */
        @Override
        public E next() {
            int i = position;
            if (i == size) {
                throw new NoSuchElementException();
            }
            position = i + 1;
            return cell(i).item;
        }
    }

    /**
     * Nested class of Cell with element and links on neighbour elements.
     * @param <E> generic.
     */
    private static class Cell<E> {
        /**
         * current element of SimpleLinkedArray.
         */
        private E item;
        /**
         * next element of SimpleLinkedArray.
         */
        private Cell<E> next;
        /**
         * previous element of SimpleLinkedArray.
         */
        private Cell<E> prev;

        /**
         * @param prev element of SimpleLinkedArray.
         * @param element of SimpleLinkedArray.
         * @param next element of SimpleLinkedArray.
         */
        Cell(Cell<E> prev, E element, Cell<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
