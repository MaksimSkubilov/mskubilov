package mskubilov.map;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 21.04.17
 */
public class UserOverHashcodeEquals extends UserOverEquals {
    /**
     * @param name of User.
     */
    public UserOverHashcodeEquals(String name) {
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
