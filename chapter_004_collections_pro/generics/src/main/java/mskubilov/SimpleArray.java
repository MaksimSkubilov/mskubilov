package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.04.17
 */

/**
 *
 * @param <T> generic.
 */
public class SimpleArray<T> {
    /**
     * Inner array of Objects.
     */
    private Object[] array;
    /**
     * current index of inner array.
     */
    private int index = 0;

    /**
     * @param size of inner array.
     */
    public SimpleArray(int size) {
        array = new Object[size];
    }

    /**
     * @param object element to add in inner array.
     */
    public void add(T object) {
        this.array[this.index++] = object;
    }

    /**
     * @param position get element from position.
     * @return an Object on wanted position.
     */
    public T get(int position) {
        return (T) this.array[position];
    }

    /**
     * @param position which position to update.
     * @param object object for update.
     */
    public void update(int position, T object) {
        this.array[position] = object;
    }

    /**
     * @param position position of an Object to delete.
     */
    public void delete(int position) {
        System.arraycopy(array, position + 1, array, position, array.length - position - 1);
        this.index--;
    }
}
