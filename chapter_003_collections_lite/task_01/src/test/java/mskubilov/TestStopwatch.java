package mskubilov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 06.04.17
 */
public class TestStopwatch {
    /**
     * Test of adding string objects in collections.
     */
    @Test
    public void testStopwatch() {
        Stopwatch stopwatch = new Stopwatch();
        String line = "test string";
        int amount = 1000000;
        ArrayList<String> arrayListString = new ArrayList<String>();
        long sw1 = stopwatch.add(arrayListString, line, amount);
        LinkedList<String> linkedListString = new LinkedList<String>();
        long sw2 = stopwatch.add(linkedListString, line, amount);
        TreeSet<String> treeSetString = new TreeSet<String>();
        long sw3 = stopwatch.add(treeSetString, line, amount);
        System.out.println(sw1);
        System.out.println(sw2);
        System.out.println(sw3);
        assertThat(arrayListString.size(), is(amount));
        assertThat(linkedListString.size(), is(amount));
        assertThat(treeSetString.size(), is(amount));
        int erase = 1000;
        sw1 = stopwatch.delete(arrayListString, erase);
        sw2 = stopwatch.delete(linkedListString, erase);
        sw3 = stopwatch.delete(treeSetString, erase);
        System.out.println(sw1);
        System.out.println(sw2);
        System.out.println(sw3);
        assertThat(arrayListString.size(), is(amount - erase));
        assertThat(linkedListString.size(), is(amount - erase));
        assertThat(treeSetString.size(), is(amount - erase));

    }
}
