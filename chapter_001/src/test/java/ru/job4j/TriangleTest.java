package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * TriangleTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.02.2017
 * @version 1.0
 */
public class TriangleTest {
	/**
	* Test area.
	*/
	@Test
	public void testArea() {
		Triangle abc = new Triangle(new Point(0, 1), new Point(1, 1), new Point(1, 0));
		assertThat(abc.area(), is(closeTo(0.5, 0.01)));
	}
	/**
	* Test nullArea.
	*/
	@Test
	public void testNullArea() {
		Triangle abc = new Triangle(new Point(2, 1), new Point(0, 1), new Point(2, 1));
		assertThat(abc.area(), is(0d));
	}
}