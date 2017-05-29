package mskubilov.synch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 29.05.17
 */
public class UserStorage {

    /**
     * Storage Map instance.
     */
    private final Map<Integer, User> storage = new ConcurrentHashMap<>();

    /**
     * Adds new User to this.
     * @param user new User to add.
     */
    public synchronized void add(User user) {
        this.storage.put(user.getId(), user);
    }

    /**
     * Updates account of some User.
     * @param user to change its account.
     * @param amount of money.
     * @return boolean value.
     */
    public synchronized boolean updateAccount(User user, double amount) {
        boolean result = false;
        if (this.storage.containsKey(user.getId())) {
            user = this.storage.get(user.getId());
            user.setAccount(user.getAccount() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Delete User from UserStorage.
     * @param user to delete.
     * @return boolean value.
     */
    public synchronized boolean deleteUser(User user) {
        boolean result = false;
        if (this.storage.containsKey(user.getId())) {
            this.storage.remove(user.getId());
            result = true;
        }
        return result;
    }

    /**
     * @param userFrom whom transfer money.
     * @param userTo whom transfer money.
     * @param amount of money to transfer.
     * @return boolean value.
     */
    public synchronized boolean transferMoney(User userFrom, User userTo, double amount) {
        boolean result = false;
        if (this.storage.containsKey(userFrom.getId()) && this.storage.containsKey(userTo.getId())) {
            userFrom.setAccount(userFrom.getAccount() - amount); // no check for negative account, lets get User negative account like real life!
            userTo.setAccount(userTo.getAccount() + amount);
            result = true;
        }
        return result;
    }

    /**
     * @param id User's id.
     * @return User instance if found, else null.
     */
    public synchronized User getUserById(int id) {
        User result = null;
        if (storage.containsKey(id)) {
            result = storage.get(id);
        }
        return result;
    }

}
