package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 08.04.17
 */
public class User implements Comparable {
    /**
     * name.
     */
    private String name;
    /**
     * age.
     */
    private int age;
    /**
     * User. Конструктор класса.
     * @param name  - name.
     * @param age - age.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * getAge.
     * @return age.
     */
    public int getAge() {
        return age;
    }
    /**
     * getName.
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * compareTo. Override.
     * @param o - User.
     */
    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        int result = age - user.getAge();
        if (result == 0) {
            return 1;
        } else {
            return result;
        }
    }
}
