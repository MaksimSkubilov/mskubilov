package mskubilov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 07.04.17
 */
public class TestConvertList {
    /**
     * Test of converting array to ArrayList.
     */
    @Test
    public void testConvertToList() {
        int[][] array = {{1, 0, 4, 7}, {4, 0}, {1, 4, 9}};
        ConvertList cl = new ConvertList();
        List<Integer> arrayList = cl.toList(array);
        assertThat(arrayList.size(), is(9));
        assertThat(arrayList.get(4), is(4));
    }
    /**
     * Test of converting to array[][].
     */
    @Test
    public void testConvertToArray() {
        int[][] array = {{1, 0, 4, 7}, {4, 10}, {1, 4, 9}};
        ConvertList cl = new ConvertList();
        List<Integer> arrayList = cl.toList(array);
        int[][] convArray = cl.toArray(arrayList, 2);
        assertThat(convArray.length, is(2));
        assertThat(convArray[1].length, is(5));
        assertThat(convArray[1][3], is(9));
        assertThat(convArray[1][4], is(0));
    }
    /**
     * Test of converting of List with int[] elements to ArrayList.
     */
    @Test
    public void testConvertListToList() {
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[] {1, 2, 3});
        list.add(new int[] {4, 5});
        list.add(new int[] {6, 7, 8, 9});
        ConvertList cl = new ConvertList();
        List<Integer> arrayList = cl.convert(list);
        assertThat(arrayList.size(), is(9));
        assertThat(arrayList.get(0), is(1));
        assertThat(arrayList.get(8), is(9));
    }
}
