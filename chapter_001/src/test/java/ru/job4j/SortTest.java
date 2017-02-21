package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SortTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.02.2017
 * @version 1.0
 */
public class SortTest {
	/**
	* Test IsSort. - проверка переворачивания массива.
	*/
	@Test
	public void testIsSort() {
		int[] in = new int[]{5, 1, 4, 8, 2};
		int[] out = new int[]{1, 2, 4, 5, 8};
		Sort sort = new Sort();
		assertThat(sort.vial(in), is(out));
	}
}