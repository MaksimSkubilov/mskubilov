package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.02.2017
 * @version 1.0
 */
public class CounterTest {
	/**
	* Test addFor.
	*/
	@Test
	public void testAddFor() {
		Counter summ = new Counter();
		assertThat(summ.addFor(-2, 2), is(0));
	}
	/**
	* Test addWhile.
	*/
	@Test
	public void testAddWhile() {
		Counter summ = new Counter();
		assertThat(summ.addWhile(-2, 2), is(0));
	}
	/**
	* Test addDoWhile.
	*/
	@Test
	public void testAddDoWhile() {
		Counter summ = new Counter();
		assertThat(summ.addDoWhile(-2, 2), is(0));
	}
}