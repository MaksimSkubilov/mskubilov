package mskubilov.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 20.04.17
 */

/**
 *
 * @param <E> generic.
 */
public class SimpleSet<E extends Number> implements Iterator<E> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Container of elements.
     */
    private Object[] values;

    /**
     * size of SimpleSet.
     */
    private int size;

    /**
     * position of Iterator.
     */
    private int position;

    /**
     * @param capacity initial capacity of SimpleSet.
     */
    public SimpleSet(int capacity) {
        this.values = new Object[capacity];
    }

    /**
     * Default constructor.
     */
    public SimpleSet() {
        this.values = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Ensure capacity of SimpleSet before adding an element.
     */
    private void ensureCapacity() {
        if (size + 1 > this.values.length) {
            this.values = Arrays.copyOf(this.values, size + DEFAULT_CAPACITY);
        }
    }

    /**
     * @param e element E.
     */
    public void add(E e) {
        for (int i = 0; i != this.size; i++) {
            if (this.values[i] != null && this.values[i] == e) {
                return;
            }
        }
        ensureCapacity();
        this.values[size++] = e;
    }

    /**
     * @return size of SimpleSet;
     */
    public int size() {
        return this.size;
    }
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
        if (i >= size) {
            throw new NoSuchElementException();
        }
        position = i + 1;
        return (E) values[i];
    }
}
