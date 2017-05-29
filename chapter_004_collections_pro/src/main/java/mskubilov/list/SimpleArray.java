package mskubilov.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 18.04.17
 */

/**
 * SimpleArray. Primitive collection of dynamic array type.
 * @param <E> generic.
 */
public class SimpleArray<E> implements SimpleContainer<E> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Container of elements.
     */
    private Object[] values;

    /**
     * size of SimpleArray.
     */
    private int size;

    /**
     * @param capacity initial capacity of SimpleArray.
     */
    public SimpleArray(int capacity) {
        this.values = new Object[capacity];
    }

    /**
     * Default constructor.
     */
    public SimpleArray() {
        this.values = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Ensure capacity of SimpleArray before adding an element.
     */
    private void ensureCapacity() {
        if (size + 1 > this.values.length) {
            this.values = Arrays.copyOf(this.values, size + this.values.length);
        }
    }
    /**
     * @param e element E.
     */
    @Override
    public synchronized void add(E e) {
        ensureCapacity();
        this.values[size++] = e;
    }

    /**
     * @param index of element.
     * @return element by index.
     */
    @Override
    public synchronized E get(int index) {
        return (E) this.values[index];
    }

    /**
     * @return new iterator Itr.
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
        public synchronized boolean hasNext() {
            return position < size;
        }

        /**
         * @return current element and goes to next position.
         */
        @Override
        public synchronized E next() {
            int i = position;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            position = i + 1;
            return (E) values[i];
        }
    }
}
