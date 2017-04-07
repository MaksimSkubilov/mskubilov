package mskubilov;

import java.util.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 006 06.04.17
 */

public class Stopwatch {
    /**
     * add. Метод заполняет коллекцю строками.
     * @param collection - коллекция, с которой будет работать метод.
     * @param line - строка, на основе которой заполняется коллекция.
     * @param amount - количество элементов будет добавлено.
     * @return время, за которое коллекци заполнилась.
     */
    public long add(Collection<String> collection, String line, int amount) {
        long currentTime = System.currentTimeMillis();
        while (amount > 0) {
            collection.add(String.format("%s: %s", amount--, line));
        }
        return System.currentTimeMillis() - currentTime;
    }
    /**
     * delete. Метод удаляет заданное количество элементов с начала коллекции.
     * @param collection - коллекция, с которой будет работать метод.
     * @param amount - количество элементов будет удалено.
     * @return время за которое были кдалеины элементы.
     */
    public long delete(Collection<String> collection, int amount) {
        long currentTime = System.currentTimeMillis();
        Iterator it = collection.iterator();
        while (amount > 0) {
            it.next();
            it.remove();
            amount--;
        }
        return System.currentTimeMillis() - currentTime;
    }
}
