package mskubilov.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import mskubilov.map.SimpleMap.Node;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 24.04.17
 */
public class SimpleMapTest {
    private SimpleMap<String, Integer> simpleMap = new SimpleMap<>(2);

    /**
     * fill SimpleMap with Nodes.
     */
    @Before
    public void fillSimpleMap() {
        int i = 0;
        while (i < 150) {
            simpleMap.insert(((Integer) i).toString(), i++);
        }

    }

    /**
     * test Of Getting Values from SimpleMap.
     */
    @Test
    public void testOfGettingValues() {
        simpleMap.insert("0", 123);
        simpleMap.insert("23132", 23132);
        assertThat(simpleMap.get("0"), is(123));
        assertThat(simpleMap.get("23132"), is(23132));

    }

    /**
     * test Of Deleting Values from SimpleMap.
     */
    @Test
    public void testOfDeletingValues() {
        simpleMap.delete("110");
        try {
            simpleMap.get("110");
        } catch (NoSuchElementException nse) {
            assertThat(nse.getMessage(), is("No element for such key!"));
        }
    }

    /**
     * test Of Iterator from SimpleMap.
     */
    @Test
    public void testOfIterator() {
        Iterator<Node<String, Integer>> it = simpleMap.iterator();
        int count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }
        assertThat(count, is(150));
        boolean result = it.hasNext();
        assertThat(result, is(false));
        try {
            it.next();
        } catch (NoSuchElementException nse) {
            assertThat(nse.getMessage(), is("End of Iterator!"));
        }

    }
}