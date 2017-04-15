package mskubilov.even;

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
public class EvenIteratorTest {
    /**
     * test hasNext.
     * @throws Exception RuntimeException.
     */
    @Test
    public void hasNext() throws Exception {
        int[] array1 = {2, 2};
        EvenIterator it1 = new EvenIterator(array1);
        it1.next();
        boolean result = it1.hasNext();
        assertThat(result, is(true));
        int[] array2 = {1, 2};
        EvenIterator it2 = new EvenIterator(array2);
        it2.next();
        result = it2.hasNext();
        assertThat(result, is(false));
    }

    /**
     * test next.
     * @throws Exception RuntimeException.
     */
    @Test
    public void next() throws Exception {
        int[] array = {0, 1, 2, 3, 5, 6};
        EvenIterator it = new EvenIterator(array);
        int result = it.next();
        assertThat(result, is(0));
        result += it.next();
        assertThat(result, is(2));
        while (it.hasNext()) {
            result += it.next();
        }
        assertThat(result, is(8));
    }

}