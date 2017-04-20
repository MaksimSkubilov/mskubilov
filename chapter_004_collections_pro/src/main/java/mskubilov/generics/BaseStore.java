package mskubilov.generics;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 18.04.17
 */

import java.util.NoSuchElementException;

/**
 * Base Store.
 * @param <T> generic of parent Base objects to store.
 */
public class BaseStore<T extends Base> implements Store<T> {
    /**
     * My SimpleArray for Stores.
     */
    private SimpleArray<T> store;

    /**
     * Capacity of store.
     */
    private int capacity;

    /**
     * @param capacity of Store (and my SimpleArray).
     */
    public BaseStore(int capacity) {
        this.capacity = capacity;
        this.store = new SimpleArray<T>(capacity);
    }

    /**
     * @param value of element to add in Store.
     */
    public void add(T value) {
        this.store.add(value);
    }

    /**
     * @param id of element to get from Store.
     * @return element by id.
     */
    public T get(String id) {
        return this.store.get(findById(id));
    }

    /**
     * @param id of element to delete from Store.
     */
    public void delete(String id) {
        this.store.delete(findById(id));
    }

    /**
     * @param id of element to update in Store.
     * @param value of element to update in Store by id.
     */
    public void update(String id, T value) {
        this.store.update(findById(id), value);
    }

    /**
     * @param id of element to find in my SimpleArray.
     * @return position of element.
     */
    private int findById(String id) {
        int result = this.capacity;
        for (int i = 0; i < this.capacity; i++) {
            if (id.equals(this.store.get(i).getId())) {
                result = i;
                break;
            }
        }
        if (result == this.capacity) {
            throw new NoSuchElementException("No element of such id");
        }
        return result;
    }
}
