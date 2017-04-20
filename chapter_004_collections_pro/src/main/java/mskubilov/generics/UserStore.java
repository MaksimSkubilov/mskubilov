package mskubilov.generics;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.04.17
 */
public class UserStore extends BaseStore<User> {
    /**
     * @param capacity of Store.
     */
    public UserStore(int capacity) {
        super(capacity);
    }
}
