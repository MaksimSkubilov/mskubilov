package mskubilov;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 18.04.17
 */
public class StoreTest {
    /**
     * test of Store on User example.
     */
    @Test
    public void testUserStore() {
        UserStore users = new UserStore(4);

        //test of adding and getting Users
        users.add(new User("01"));
        users.add(new User("02"));
        users.add(new User("03"));
        users.add(new User("04"));
        assertThat(users.get("02").getId(), is("02"));

        //test of deleting Users and getting Users with wrong id
        users.delete("03");
        try {
            users.get("03");
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("No element of such id"));
        }

        //test of updating Users
        users.update("02", new User("05"));
        try {
            users.get("02");
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("No element of such id"));
        }
        assertThat(users.get("05").getId(), is("05"));
    }
}