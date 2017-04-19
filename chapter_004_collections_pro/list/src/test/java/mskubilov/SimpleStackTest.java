package mskubilov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 19.04.17
 */
public class SimpleStackTest {
    /**
     * test of push() and peek() methods of SimpleLinkedArray.
     */
    @Test
    public void whenPushElementsAndPeekThenItPeeksLast() {
        SimpleStack<String> ss = new SimpleStack<>();
        ss.push("stringOne");
        ss.push("stringTwo");
        ss.push("stringThree");
        String result = ss.peek();
        assertThat(result, is("stringThree"));
    }
    /**
     * test of push() and pop() methods of SimpleLinkedArray.
     */
    @Test
    public void whenPushElementsAndPopThenItPopsAndDeletesLast() {
        SimpleStack<Integer> ss = new SimpleStack<>();
        ss.push(0);
        ss.push(1);
        ss.push(2);
        ss.pop();
        ss.pop();
        int result = ss.pop();
        assertThat(result, is(0));
    }
}