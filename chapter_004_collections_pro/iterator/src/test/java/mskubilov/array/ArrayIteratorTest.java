package mskubilov.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 15.04.17
 */
public class ArrayIteratorTest {
    /**
     * hasNext test.
     * @throws Exception RuntimeException.
     */
    @Test
    public void hasNext() throws Exception {
        int[][] array = {{1}, {0, 5}};
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(array);
        it.next();
        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(true));
        it.next();
        result = it.hasNext();
        assertThat(result, is(false));
        result = it.hasNext();
        assertThat(result, is(false));
    }

    /**
     * next test.
     * @throws Exception RuntimeException.
     */
    @Test
    public void next() throws Exception {
        int[][] array = {{1}, {0, 5}, {1, 2, 3}};
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(array);
        int result = 0;
        while (it.hasNext()) {
            result += it.next();
        }
        assertThat(result, is(12));
    }

    /**
     * remove test.
     * @throws Exception RuntimeException.
     */
    @Test
    public void remove() throws Exception {
        int[][] array = {{1}, {1, 5}, {1, 2, 3}};
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(array);
        it.remove();
        it.next();
        it.remove();
        int result = it.next();
        it.next();
        it.remove();
        assertThat(result, is(5));
        while (it.hasNext()) {
            result += it.next();
        }
        assertThat(result, is(10));
    }

}