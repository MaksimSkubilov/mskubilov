package mskubilov.synch;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 29.05.17
 */
public class User {

    /**
     * User's unique id.
     */
    private int id;

    /**
     * User's money account.
     */
    private double account;

    /**
     * @param id this.id.
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * @return this.id.
     */
    public int getId() {
        return id;
    }

    /**
     * @return this.account.
     */
    public double getAccount() {
        return account;
    }

    /**
     * @param account new amount of money.
     */
    public synchronized void setAccount(double account) {
        this.account = account;
    }

    /**
     * @return this.hashcode().
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * @param obj some User instance.
     * @return true if this equals User.
     */
    @Override
    public boolean equals(Object obj) {
        return id == ((User) obj).id;
    }
}
