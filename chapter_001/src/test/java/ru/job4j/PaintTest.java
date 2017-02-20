package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.02.2017
 * @version 1.0
 */
public class PaintTest {
	/**
	* Test IsPiramid.
	*/
	@Test
	public void testIsPiramid() {
		Paint mountain = new Paint();
		assertThat(mountain.piramid(2), is(" ^\n^ ^\n"));
	}
}