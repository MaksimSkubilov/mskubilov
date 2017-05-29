package mskubilov.synch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 29.05.17
 */
public class CountTest {

    /**
     * test of Count class. When run concurrentIncrement() then value result is 40 millions.
     */
    @Test
    public void testSynchCount() {
        Count count = new Count(0);
        count.concurrentIncrement();
        assertThat(count.getValue(), is(40_000_000));
    }

}