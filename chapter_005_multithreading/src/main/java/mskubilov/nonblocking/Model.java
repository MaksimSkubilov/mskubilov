package mskubilov.nonblocking;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.06.17
 */
public class Model {

    /**
     * Unique index for all Models.
     */
    private static volatile int index = 0;

    /**
     * Model's instance id.
     */
    private int id;

    /**
     * Model's instance name.
     */
    private String name;

    /**
     * Model's instance version.
     */
    private int version;

    /**
     * Model's instance construct.
     * @param name model's name.
     * @throws OptimisticException exception if error occurs while concurrent constructing.
     */
    public Model(String name) throws OptimisticException {
        int temp = index + 1;
        this.id = temp;
        this.name = name;
        this.version = 1;
        if (index >= temp) {
            throw new OptimisticException(String.format(
                    "Model with id %s already constructed by %s!", temp, Thread.currentThread().getName()));
        } else {
            index = temp;
        }
    }

    /**
     * @return model's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name new model's name.
     */
    public void setName(String name) {
        this.name = name;
        this.version++;
    }

    /**
     * @return model's version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * @return model's id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param o model.
     * @return equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Model)) {
            return false;
        }
        Model model = (Model) o;
        if (getId() != model.getId()) {
            return false;
        }
        if (getVersion() != model.getVersion()) {
            return false;
        }
        return getName().equals(model.getName());
    }

    /**
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return getId();
    }
}
