package mskubilov.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 20.04.17
 */
public class UserTest {

    /**
     * test Map of User without overriding that's hashcode() & equals().
     */
    @Test
    public void testUserMap() {
        Map<User, Object> userMap = new HashMap<>();
        User user1 = new User("John Snow");
        User user2 = new User("John Snow");
        userMap.put(user1, new Object());
        userMap.put(user2, new Object());
        System.out.println(userMap);
    }

    /**
     * test Map of User with overriding that's hashcode() only.
     */
    @Test
    public void testUserHashcodeMap() {
        Map<UserOverHashcode, Object> userMap = new HashMap<>();
        UserOverHashcode user1 = new UserOverHashcode("John Snow");
        UserOverHashcode user2 = new UserOverHashcode("John Snow");
        userMap.put(user1, new Object());
        userMap.put(user2, new Object());
        System.out.println(userMap);
    }

    /**
     * test Map of User with overriding that's equals() only.
     */
    @Test
    public void testUserEqualsMap() {
        Map<UserOverEquals, Object> userMap = new HashMap<>();
        UserOverEquals user1 = new UserOverEquals("John Snow");
        UserOverEquals user2 = new UserOverEquals("John Snow");
        userMap.put(user1, new Object());
        userMap.put(user2, new Object());
        System.out.println(userMap);
    }

}