package mskubilov.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 17.04.17
 */
public class SimpleArrayTest {
    /**
     * test of adding String.
     */
    @Test
    public void whenAddStringThenGetString() {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("test1");
        array.add("test2");
        assertThat(array.get(1), is("test2"));
    }
    /**
     * test of adding Integer.
     */
    @Test
    public void whenAddIntegerThenGetInteger() {
        SimpleArray<Integer> array = new SimpleArray<>(2);
        array.add(1);
        array.add(2);
        assertThat(array.get(1), is(2));
    }
    /**
     * test of updating.
     */
    @Test
    public void whenUpdateArrayThenGetUpdatedObject() {
        SimpleArray<Integer> array = new SimpleArray<>(2);
        array.add(1);
        array.add(2);
        array.update(0, 0);
        assertThat(array.get(0), is(0));
    }
    /**
     * test of deleting.
     */
    @Test
    public void whenDeleteElementThenGetNextElement() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.delete(1);
        array.add(4);
        assertThat(array.get(1), is(3));
        assertThat(array.get(2), is(4));
    }
}