package mskubilov.map;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 20.04.17
 */
public class UserOverHashcode extends User {
    /**
     * @param name of User.
     */
    public UserOverHashcode(String name) {
        super(name);
    }

    /**
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

}
