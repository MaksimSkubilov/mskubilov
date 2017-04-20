package mskubilov.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 18.04.17
 */
public class SimpleArrayTest {

    /**
     * test of add() and get() methods of SimpleArray with initial capacity.
     */
    @Test
    public void whenAddElementThenItIncreasesItsInitializedCapacity() {
        SimpleArray<String> sa = new SimpleArray<>(2);
        sa.add("stringOne");
        sa.add("stringTwo");
        sa.add("stringThree");
        assertThat(sa.get(2), is("stringThree"));
    }

    /**
     * test of add() and get() methods of SimpleArray with default capacity value = 10.
     */
    @Test
    public void whenAddElementThenItIncreasesItsDefaultCapacity() {
        SimpleArray<Integer> sa = new SimpleArray<>();
        for (int i = 0; i < 11; i++) {
            sa.add(i);
        }
        assertThat(sa.get(10), is(10));
    }

    /**
     * test of iterator of SimpleArray with default capacity.
     */
    @Test
    public void whenUseIteratorThenItWorks() {
        SimpleArray<Integer> sa = new SimpleArray<>();
        for (int i = 0; i < 10; i++) {
            sa.add(i);
        }
        Iterator<Integer> it = sa.iterator();
        int result = it.next();
        assertThat(result, is(0));
        for (int i = 1; i < 9; i++) {
            it.next();
        }
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }
    /**
     * test of throwing NoSuchElementException.
     */
    @Test
            (expected = NoSuchElementException.class)
    public void whenCallIteratorsNextOutOfSimpleArraySizeThenItTrowsException() {
        SimpleArray<String> sa = new SimpleArray<>(1);
        sa.add("test");
        Iterator<String> it = sa.iterator();
        it.next();
        it.next();
    }
}