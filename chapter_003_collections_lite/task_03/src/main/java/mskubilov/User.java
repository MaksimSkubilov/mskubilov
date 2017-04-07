package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.04.17
 */
public class User {
    /**
     * id.
     */
    private int id;
    /**
     * name.
     */
    private String name;
    /**
     * city.
     */
    private String city;
    /**
     * User. Конструктор класса.
     * @param id - id.
     * @param name  - name.
     * @param city - city.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * getId.
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * getName.
     * @return name.
     */
    public String getName() {
        return name;
    }
}
