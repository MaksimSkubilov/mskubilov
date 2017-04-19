package mskubilov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 19.04.17
 */
public class SimpleQueueTest {
    /**
     * test of offer() and peek() methods of SimpleQueue.
     */
    @Test
    public void whenOfferElementsAndPeekThenItPeeksFirst() {
        SimpleQueue<String> ss = new SimpleQueue<>();
        ss.offer("stringOne");
        ss.offer("stringTwo");
        boolean result1 = ss.offer("stringThree");
        ss.peek();
        String result2 = ss.peek();
        assertThat(result1, is(true));
        assertThat(result2, is("stringOne"));
    }
    /**
     * test of offer() and poll() methods of SimpleQueue.
     */
    @Test
    public void whenOfferElementsAndPollThenItPollsAndDeletesFirst() {
        SimpleQueue<Integer> ss = new SimpleQueue<>();
        ss.offer(0);
        ss.offer(2);
        ss.offer(3);
        ss.poll();
        ss.poll();
        int result = ss.poll();
        assertThat(result, is(3));
    }
}