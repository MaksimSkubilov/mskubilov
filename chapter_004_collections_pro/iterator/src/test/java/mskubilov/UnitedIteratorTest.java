package mskubilov;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 017 17.04.17
 */
public class UnitedIteratorTest {
    /**
     * converted Iterator for tests.
     */
    private Iterator<Integer> testIterator;

    /**
     * set up of iterator before each test.
     */
    @Before
    public void setUp() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 2, 0, 4, 6, 4, 9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 9, 8, 7, 5));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4));
        List<Iterator<Integer>> itList = new ArrayList<>(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()));
        UnitedIterator unitedIterator = new UnitedIterator();
        testIterator = unitedIterator.convert(itList.iterator());
    }

    /**
     * test of method next() in converted testIterator.
     */
    @Test
    public void next() {
        int amount = 21;
        testIterator.next();
        testIterator.next();
        testIterator.next();
        Integer result = testIterator.next();
        assertThat(result, is(4));
        for (int i = 4; i < amount - 1; i++) {
            testIterator.next();
        }
        result = testIterator.next();
        assertThat(result, is(4));
        try {
            testIterator.next();
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("End of Iterator elements"));
        }
    }

    /**
     * test of method hasNext() in converted testIterator.
     */
    @Test
    public void hasNext() {
        int amount = 21;
        for (int i = 0; i < amount - 1; i++) {
            testIterator.next();
        }
        assertThat(testIterator.hasNext(), is(true));
        int result = testIterator.next();
        assertThat(result, is(4));
        assertThat(testIterator.hasNext(), is(false));
    }
}