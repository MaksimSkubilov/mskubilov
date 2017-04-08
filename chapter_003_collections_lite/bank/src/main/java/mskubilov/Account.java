package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 08.04.17
 */
public class Account implements Comparable {
    /**
     * value. Money amount.
     */
    private double value;
    /**
     * requisites.
     */
    private long requisites;

    /**
     * Constructor of Account.
     * @param requisites - requisites.
     */
    public Account(long requisites) {
        this.requisites = requisites;
    }
    /**
     * Constructor of Account.
     * @param requisites - requisites.
     * @param value - value.
     */
    public Account(long requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    /**
     * @return this.value.
     */
    public double getValue() {
        return value;
    }
    /**
     * @param value - money amount on account.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return requisites.
     */
    public long getRequisites() {
        return requisites;
    }

    /**
     * @param obj - Account.
     * @return equals or not.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        Account other = (Account) obj;
        if (this.requisites == other.getRequisites()) {
            result = true;
        }
        return result;
    }

    /**
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return (int) (getRequisites() - getRequisites() / 2);
    }
    /**
     * @param o - Account.
     * @return -1, 0, 1.
     */
    @Override
    public int compareTo(Object o) {
        Account account = (Account) o;
        return Long.compare(this.getRequisites(), account.getRequisites());
    }

}
