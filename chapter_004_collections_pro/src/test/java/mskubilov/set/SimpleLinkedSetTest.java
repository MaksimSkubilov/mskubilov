package mskubilov.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 20.04.17
 */
public class SimpleLinkedSetTest {

    @Test
    public void whenAddElementThenItAdds() {
        SimpleLinkedSet<Integer> ss = new SimpleLinkedSet<>();
        ss.add(0);
        assertThat(ss.size(), is(1));
    }

    @Test
    public void whenAddSameElementsThenItDoesNotAddThem() {
        SimpleLinkedSet<Integer> ss = new SimpleLinkedSet<>();
        ss.add(0);
        ss.add(1);
        ss.add(2);
        ss.add(1);
        ss.add(2);
        assertThat(ss.size(), is(3));
    }

    @Test
    public void whenUseIteratorThenItWorks() {
        SimpleLinkedSet<Integer> ss = new SimpleLinkedSet<>();
        ss.add(0);
        ss.add(1);
        ss.add(2);
        Iterator<Integer> it = ss.iterator();
        it.next();
        assertThat(it.hasNext(), is(true));
        int result = it.next();
        assertThat(result, is(1));
        it.next();
        assertThat(it.hasNext(), is(false));
        it.hasNext();
        assertThat(it.hasNext(), is(false));
    }
}