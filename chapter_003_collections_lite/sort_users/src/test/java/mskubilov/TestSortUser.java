package mskubilov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 08.04.17
 */
public class TestSortUser {
    /**
     * Test of adding Users in TreeSet by age.
     */
    @Test
    public void testSortUser() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("John Doe", 25));
        users.add(new User("Jane Doe", 20));
        users.add(new User("Alan Smith", 25));
        users.add(new User("Vitaly Mutko", 58));
        SortUser su = new SortUser();
        Set<User> tsu = su.sort(users);
        User[] userArray = tsu.toArray(new User[tsu.size()]);
        assertThat(userArray[0].getName(), is("Jane Doe"));
        assertThat(userArray[3].getName(), is("Vitaly Mutko"));
    }
}
