package mskubilov;

import java.util.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 08.04.17
 */
public class SortUser {
    /**
     * sort - создает дерево юзеров, упорядечнное по возрасту.
     * @param list - список юзеров.
     * @return дерево.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<User>(list);
    }
    /**
     * sortHash - сортировка списка юзеров по хэш-коду.
     * @param list - список на сортировку.
     * @return отсортированный список.
     */
    public List<User> sortHash(List<User> list) {
        ArrayList<User> result = new ArrayList<User>(list);
        HashCompare hc = new HashCompare();
        result.sort(hc);
        return result;
    }
    /**
     * sortLength - сортировка списка юзеров по длине имени.
     * @param list - список на сортировку.
     * @return отсортированный список.
     */
    public List<User> sortLength(List<User> list) {
        ArrayList<User> result = new ArrayList<User>(list);
        NameCompare nc = new NameCompare();
        result.sort(nc);
        return result;
    }
    /**
     * hashCompare. Внутренний класс, реализующий компаратор по хэш-коду.
     */
    private class HashCompare implements Comparator<User> {
        /**
         * compare.
         * @param o1 - первый юзер.
         * @param o2 - второй бзер.
         * @return -1, 0 или +1.
         */
        @Override
        public int compare(User o1, User o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    }
    /**
     * nameCompare. Внутренний класс, реализующий компаратор по длине иммени.
     */
    private class NameCompare implements Comparator<User> {
        /**
         * compare.
         * @param o1 - первый юзер.
         * @param o2 - второй бзер.
         * @return -1, 0 или +1.
         */
        @Override
        public int compare(User o1, User o2) {
            return Integer.compare(o1.getName().length(), o2.getName().length());
        }
    }
}
