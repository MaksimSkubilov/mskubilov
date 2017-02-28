package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayAddTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.02.2017
 * @version 1.0
 */
public class ArrayAddTest {
	/**
	* Test IsAdd. - проверка переворачивания массива.
	*/
	@Test
	public void testIsAdd() {
		int[] in1 = new int[]{1, 2, 11};
		int[] in2 = new int[]{3, 6, 9, 10};
		int[] out = new int[]{1, 2, 3, 6, 9, 10, 11};
		ArrayAdd array = new ArrayAdd();
		assertThat(array.add(in1, in2), is(out));
	}
}