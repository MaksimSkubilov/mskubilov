package mskubilov.map;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 20.04.17
 */
public class UserOverEquals extends User {
    /**
     * @param name of User.
     */
    public UserOverEquals(String name) {
        super(name);
    }

    /**
     * @param o Object.
     * @return equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (!name.equals(user.name)) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

}
