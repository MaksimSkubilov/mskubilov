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
        list.sort(new Comparator<User>() {
            /**
             * @param o1 - user1.
             * @param o2 - user2.
             * @return -1, 0, 1
             */
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        });
        return list;
    }
    /**
     * sortLength - сортировка списка юзеров по длине имени.
     * @param list - список на сортировку.
     * @return отсортированный список.
     */
    public List<User> sortLength(List<User> list) {
         list.sort(new Comparator<User>() {
             /**
              * @param o1 - user1.
              * @param o2 - user2.
              * @return -1, 0, 1
              */
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
         return list;
    }
}
