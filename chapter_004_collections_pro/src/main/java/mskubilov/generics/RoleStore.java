package mskubilov.generics;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 18.04.17
 */
public class RoleStore extends BaseStore<Role> {
    /**
     * @param capacity of Store.
     */
    public RoleStore(int capacity) {
        super(capacity);
    }
}
