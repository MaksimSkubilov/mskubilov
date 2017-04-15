package mskubilov.prime;

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
public class PrimeIteratorTest {
    /**
     * test hasNext.
     * @throws Exception RuntimeException.
     */
    @Test
    public void hasNext() throws Exception {
        int[] array = {0, 1, 2, 4, 5, 6};
        PrimeIterator it = new PrimeIterator(array);
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    /**
     * test next.
     * @throws Exception RuntimeException.
     */
    @Test
    public void next() throws Exception {
        int[] array = {0, 1, 2, 4, 5, 6};
        PrimeIterator it = new PrimeIterator(array);
        int result = (int) it.next();
        assertThat(result, is(2));
        result = (int) it.next();
        assertThat(result, is(5));
    }

}