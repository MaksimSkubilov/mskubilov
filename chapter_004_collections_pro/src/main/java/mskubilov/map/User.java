package mskubilov.map;

import java.util.Calendar;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 20.04.17
 */
public class User {
    /**
     * User's name.
     */
    String name;
    /**
     * Children User has by number.
     */
    int children;

    /**
     * User's birthday.
     */
    Calendar birthday;

    /**
     * @param name of User.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * @param children User has by number.
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * @param birthday of User.
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }
}
