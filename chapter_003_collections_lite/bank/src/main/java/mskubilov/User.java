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
    private int passport;
    /**
     * User. Конструктор класса.
     * @param name  - name.
     * @param passport - passport.
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * getPassport.
     * @return passport.
     */
    public int getPassport() {
        return this.passport;
    }
    /**
     * getName.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param obj - User.
     * @return equals or not.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        User other = (User) obj;
        if (this.name.equals(other.getName()) && this.passport == other.getPassport()) {
            result = true;
        }
        return result;
    }

    /**
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = 1;
        result = result + getName().hashCode();
        result = result + getPassport();
        return result;
    }

    /**
     * @param o - User.
     * @return -1, 0, 1.
     */
    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        int result = this.getName().compareTo(user.getName());
        if (result == 0 && this.getPassport() == user.getPassport()) {
            return 0;
        } else if (result == 0) {
            return 1;
        } else {
            return result;
        }
    }
}