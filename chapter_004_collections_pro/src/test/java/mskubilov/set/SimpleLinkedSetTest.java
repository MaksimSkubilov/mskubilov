package mskubilov.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 2.0
 * @since 20.04.17
 */
public class SimpleLinkedSetTest {

    /**
     * whenAddElementThenItAdds.
     */
    @Test
    public void whenAddElementThenItAdds() {
        SimpleLinkedSet<Integer> ss = new SimpleLinkedSet<>();
        ss.add(0);
        ss.addOutOfBinary(1);
        assertThat(ss.size(), is(2));
    }

    /**
     * whenAddSameElementsThenItDoesNotAddThemBinary.
     */
    @Test
    public void whenAddSameElementsThenItDoesNotAddThemBinary() {
        SimpleLinkedSet<Integer> ss = new SimpleLinkedSet<>();
        for (int i = 0; i < 3000; i++) {
            ss.add(i);
        }
        ss.add(200);
        ss.add(150);
        ss.add(134);
        ss.add(222);
        ss.add(25);
        assertThat(ss.size(), is(3000));
    }

    /**
     * whenAddSameElementsThenItDoesNotAddThemOutOfBinary.
     */
    @Test
    public void whenAddSameElementsThenItDoesNotAddThemOutOfBinary() {
        SimpleLinkedSet<Integer> ss = new SimpleLinkedSet<>();
        for (int i = 0; i < 3000; i++) {
            ss.addOutOfBinary(i);
        }
        ss.addOutOfBinary(200);
        ss.addOutOfBinary(150);
        ss.addOutOfBinary(134);
        ss.addOutOfBinary(298);
        ss.addOutOfBinary(25);
        assertThat(ss.size(), is(3000));
    }

    /**
     * whenUseIteratorThenItWorks.
     */
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