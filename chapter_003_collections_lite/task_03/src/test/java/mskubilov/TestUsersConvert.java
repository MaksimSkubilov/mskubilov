package mskubilov;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.04.17
 */
public class TestUsersConvert {
    /**
     * Test of converting List of Users in HashMap of Users.
     */
    public void testUsersConvert() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1, "John Doe", "Gotham"));
        list.add(new User(2, "Jane Doe", "Bagdad"));
        list.add(new User(3, "Donald Duck", "Ajax"));
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> map = uc.process(list);
        assertThat(map.get(2).getName(), is("Jane Doe"));
        assertThat(map.size(), is(3));
    }
}
