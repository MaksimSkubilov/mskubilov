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
 * @since 19.04.17
 */
public class SimpleLinkedArrayTest {
    /**
     * test of add() and get() methods of SimpleLinkedArray.
     */
    @Test
    public void whenAddElementThenItIncreasesItsInitializedCapacity() {
        SimpleLinkedArray<String> sa = new SimpleLinkedArray<>();
        sa.add("stringOne");
        sa.add("stringTwo");
        sa.add("stringThree");
        assertThat(sa.get(2), is("stringThree"));
    }

    /**
     * test of iterator of SimpleLinkedArray.
     */
    @Test
    public void whenUseIteratorThenItWorks() {
        SimpleLinkedArray<Integer> sa = new SimpleLinkedArray<>();
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
        SimpleLinkedArray<String> sa = new SimpleLinkedArray<>();
        sa.add("test");
        Iterator<String> it = sa.iterator();
        it.next();
        it.next();
    }
    /**
     * test of throwing IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void whenCallGetWithWrongIndexThenItTrowsException() {
        SimpleLinkedArray<String> sa = new SimpleLinkedArray<>();
        sa.get(4);
    }
}