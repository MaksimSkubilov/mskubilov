package mskubilov;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
