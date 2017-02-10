package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.02.2017
 * @version 1.0
 */
public class MaxTest {
	/**
	* Test max.
	*/
	@Test
	public void testMax() {
		Max values = new Max();
		assertThat(values.max(1, 2), is(2));
	}
}