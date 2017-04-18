package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.04.17
 */
public abstract class Base {
    /**
     * id.
     */
    private String id;

    /**
     * @param id id.
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * @param id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return get id.
     */
    public String getId() {
        return this.id;
    }
}
