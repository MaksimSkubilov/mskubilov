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
		values.max(1, 2);
		assertThat(values.getResult(), is(2));
	}
	/**
	* Test cleanResult.
	*/
	@Test
	public void testCleanResult() {
		Max values = new Max();
		values.max(2, 2);
		values.cleanResult();
		assertThat(values.getResult(), is(0));
	}
}