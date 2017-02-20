package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactorTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.02.2017
 * @version 1.0
 */
public class FactorTest {
	/**
	* Test calc.
	*/
	@Test
	public void testCalc() {
		Factor fact = new Factor();
		assertThat(fact.calc(-1), is(0));
	}
}