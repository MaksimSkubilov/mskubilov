package mskubilov.synch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 29.05.17
 */
public class UserStorageTest {
    /**
     * First user.
     */
    private User user1 = new User(0);
    /**
     * Second user.
     */
    private User user2 = new User(1);
    /**
     * Storage of users.
     */
    private UserStorage storage = new UserStorage();

    /**
     * Before method, adds two users in storage.
     */
    @Before
    public void add() {
        storage.add(user1);
        storage.add(user2);
        user1.setAccount(100.0);
        user2.setAccount(200.0);
    }

    /**
     * test user's account updating.
     */
    @Test
    public void updateAccount() {
        storage.updateAccount(user1, 50.5);
        assertThat(storage.getUserById(0).getAccount(), is(150.5));
    }

    /**
     * test of deleting user.
     */
    @Test
    public void deleteUser() {
        storage.deleteUser(user1);
        assertNull(storage.getUserById(0));
        assertThat(storage.deleteUser(new User(2)), is(false));
    }

    /**
     * test of money transfer between two users.
     */
    @Test
    public void transferMoney() {
        storage.transferMoney(user2, user1, 50.0);
        assertThat(user1.getAccount(), is(150.0));
        assertThat(user2.getAccount(), is(150.0));
        assertThat(storage.transferMoney(new User(2), user1, 50.0), is(false));
        assertThat(storage.transferMoney(user1, new User(2), 50.0), is(false));
    }

    /**
     * test of getting users by them ids.
     */
    @Test
    public void getUserById() {
        assertThat(storage.getUserById(0), is(user1));
        assertNull(storage.getUserById(3));
    }

}