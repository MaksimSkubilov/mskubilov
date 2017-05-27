package mskubilov.extra;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.05.17
 */
public class mergeValuesTest{
    /**
     * Test of merge two lists.
     */
    @Test
    public void testMerge() {
        Integer[] arrayA = {1, 3, 5, 8};
        Integer[] arrayB = {6, 7, 5, 7, 2, 666, 0, -22, 4};
        Integer[] array = {-22, 0, 1, 2, 3, 4, 5, 6, 7, 8, 666};
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(listA, arrayA);
        Collections.addAll(listB, arrayB);
        Collections.addAll(list, array);
        new mergeValues().merge(listA, listB);
        assertThat(list, is(listA));
    }
}