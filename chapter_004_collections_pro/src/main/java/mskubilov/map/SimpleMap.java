package mskubilov.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 23.04.17
 */
public class SimpleMap<T, V> implements Iterable<SimpleMap.Node<T, V>>{

    /**
     * Array of Nodes, includes all values of SimpleMap.
     */
    private Node<T, V>[] table;

    /**
     * Quantity of this.table values.
     */
    private int size;

    /**
     * How much of this.table's capacity is filled.
     */
    private int tableFill;

    /**
     * Capacity of this.table, default is 16.
     */
    private int capacity = 16;

    /**
     * @param capacity initial capacity of SimpleMap.
     */
    public SimpleMap(int capacity) {
        this.capacity = capacity;
        this.table = new Node[this.capacity];
    }

    /**
     * Constructs new SimpleMap with default capacity.
     */
    public SimpleMap() {
        this.table = new Node[capacity];
    }


    /**
     * Insert new Node.
     * @param key value.
     * @param value by key.
     * @return boolean result.
     */
    public boolean insert(T key, V value) {
        boolean result = false;
        resize(tableFill);
        if (key != null) {
            int index = getIndex(key);
            Node<T, V> node = table[index];
            if (node != null && node.getKey().equals(key)) {
                node.setValue(value);
                result = true;
            } else if (node != null) {
                size++;
                table[index] = new Node<T, V>(key, value, node);
                result = true;
            } else {
                size++;
                tableFill++;
                table[index] = new Node<T, V>(key, value,null);
                result = true;
            }
        }
        return result;
    }

    /**
     * Get value by key.
     * @param key value.
     * @return value by key.
     */
    public V get(T key) {
        V result = null;
        Node<T, V> node = table[getIndex(key)];
        if (node == null) {
            throw new NoSuchElementException("No element on such key!");
        } else {
            do {
                if (node.getKey().equals(key)) {
                    result = node.getValue();
                    break;
                } else {
                    node = node.getNext();
                }
            } while (node != null);
        }
        return result;
    }

    /**
     * Delete Node by key.
     * @param key value.
     * @return boolean result.
     */
    public boolean delete(T key) {
        boolean result = false;
        int count = 0;
        Node<T, V> node = table[getIndex(key)];
        while(node != null) {
            if (node.getKey().equals(key)) {
                node = null;
                size--;
                result = true;
                if (count == 0) {
                    tableFill--;
                }
                break;
            } else if (node.getNext() != null) {
                node = node.getNext();
                count++;
            }
        }
        return result;
    }

    /**
     * Resize this.table when tableFill = capacity.
     * @param tableFill this.tableFill.
     */
    private void resize(int tableFill) {
        if (tableFill == capacity) {
            capacity *= 2;
            Node<T, V>[] newTable = new Node[capacity];
            tableFill = 0;
            for (int i = 0; i < table.length; i++) {
                Node<T, V> node = table[i];
                Node<T, V> temp;
                while (node != null) {
                        int newIndex = getIndex(node.getKey());
                        if (newTable[newIndex] == null) {
                            temp = node.getNext();
                            newTable[newIndex] = node;
                            newTable[newIndex].next = null;
                            node = temp;
                            tableFill++;
                        } else {
                            temp = newTable[newIndex];
                            if (temp != null) {
                                while (temp.getNext() != null) {
                                    temp = temp.getNext();
                                }
                            }
                            temp.next = node;
                            node = node.getNext();
                            temp.getNext().next = null;
                        }
                }
            }
            table = newTable;
        }
    }

    /**
     * @param key value.
     * @return generated index in this.table for Node by key.hashcode() and capacity.
     */
    int getIndex(T key) {
        int h = (h = key.hashCode()) ^ (h >>> 16);
        return (capacity - 1) & h;
    }

    /**
     * @return this.size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Itertor of Nodes.
     * @return new iterator.
     */
    public Iterator<Node<T, V>> iterator() {
        return new Itr();
    }


    /**
     * @param <T> key value.
     * @param <V> value by key.
     */
    static class Node<T, V> {
        /**
         * key.
         */
        private final T key;
        /**
         * value by key.
         */
        private V value;
        /**
         * link on next Node.
         */
        private Node<T, V> next;

        /**
         * @param key value.
         * @param value by key.
         * @param next link on next Node.
         */
        public Node(T key, V value, Node<T, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * @return key.
         */
        T getKey() {
            return key;
        }

        /**
         * @return value.
         */
        V getValue() {
            return value;
        }

        /**
         * @param value by key.
         */
        void setValue(V value) {
            this.value = value;
        }

        /**
         * @return next Node.
         */
        Node<T, V> getNext() {
            return next;
        }
    }

    private class Itr implements Iterator<Node<T, V>> {
        /**
         * amount of calling method next();
         */
        private int amount = 0;
        /**
         * index of SimpleMap.table.
         */
        private int index = 0;
        /**
         * current Node.
         */
        private Node<T, V> current = table[index];

        /**
         * @return has next Node or not.
         */
        @Override
        public boolean hasNext() {
            return amount < getSize();
        }

        /**
         * @return next Node.
         */
        @Override
        public Node<T, V> next() {
            Node<T, V> result;
            if (current == null) {
                while (current == null) {
                    current = table[index++];
                }
            }
            if (current.getNext() == null && amount < getSize()) {
                amount++;
                result = current;
                current = table[index++];
            } else if (amount < getSize()) {
                amount++;
                result = current;
                current = current.getNext();
            } else {
                throw new NoSuchElementException("End of Iterator!");
            }
            return result;
        }
    }
}
