package mskubilov.generics;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.04.17
 */

/**
 * interface of Store.
 * @param <T> generic of parent Base objects to store.
 */
public interface Store<T extends Base> {
    /**
     * @param value of element to add in Store.
     */
    void add(T value);

    /**
     * @param id of element to get from Store.
     * @return element by id.
     */
    T get(String id);

    /**
     * @param id of element to delete from Store.
     */
    void delete(String id);

    /**
     * @param id of element to update in Store.
     * @param value of element to update in Store by id.
     */
    void update(String id, T value);
}
