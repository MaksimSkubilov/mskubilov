package mskubilov.set;

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
 * @since 20.04.17
 */
public class SimpleSetTest {

    /**
     * whenAddElementThenItAdds.
     */
    @Test
    public void whenAddElementThenItAdds() {
        SimpleSet<Integer> ss = new SimpleSet<>(2);
        ss.add(0);
        assertThat(ss.size(), is(1));
    }

    /**
     * whenAddElementsThenItIncreasesCapacity.
     */
    @Test
    public void whenAddElementsThenItIncreasesCapacity() {
        SimpleSet<Integer> ss = new SimpleSet<>(2);
        ss.add(0);
        ss.add(1);
        ss.add(2);
        assertThat(ss.size(), is(3));
    }

    /**
     * whenAddSameElementsThenItDoesNotAddThem.
     */
    @Test
    public void whenAddSameElementsThenItDoesNotAddThem() {
        SimpleSet<Integer> ss = new SimpleSet<>(2);
        ss.add(0);
        ss.add(1);
        ss.add(2);
        ss.add(1);
        ss.add(2);
        assertThat(ss.size(), is(3));
    }

    /**
     * whenUseIteratorThenItWorks.
     */
    @Test
    public void whenUseIteratorThenItWorks() {
        SimpleSet<Integer> ss = new SimpleSet<>(2);
        ss.add(0);
        ss.add(1);
        ss.add(2);
        Iterator<Integer> it = ss;
        it.next();
        assertThat(it.hasNext(), is(true));
        int result = it.next();
        assertThat(result, is(1));
        it.next();
        assertThat(it.hasNext(), is(false));
        it.hasNext();
        assertThat(it.hasNext(), is(false));
    }

    /**
     * whenTryToGetElementOutOfBoundsThenItTrowsException.
     */
    @Test
            (expected = NoSuchElementException.class)
    public void whenTryToGetElementOutOfBoundsThenItTrowsException() {
        SimpleSet<Integer> ss = new SimpleSet<>(2);
        ss.add(0);
        Iterator<Integer> it = ss;
        it.next();
        it.next();
    }
}