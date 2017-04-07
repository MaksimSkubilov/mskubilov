package mskubilov;

import java.util.HashMap;
import java.util.List;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.04.17
 */
public class UserConvert {
    /**
     * process.
     * @param list - список юзеров.
     * @return карту юзеров, связанную по ключу id.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user: list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
