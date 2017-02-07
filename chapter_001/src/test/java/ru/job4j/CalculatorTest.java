package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CalculatorTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.02.2017
 * @version 1.0
 */
public class CalculatorTest {
	/**
	* Test add.
	*/
	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		calc.add(1, 1);
		assertThat(calc.getResult(), is(2d));
	}
	/**
	* Test sub.
	*/
	@Test
	public void testSub() {
		Calculator calc = new Calculator();
		calc.sub(2, 1);
		assertThat(calc.getResult(), is(1d));
	}
	/**
	* Test mult.
	*/
	@Test
	public void testMult() {
		Calculator calc = new Calculator();
		calc.mult(2, 2);
		assertThat(calc.getResult(), is(4d));
	}
	/**
	* Test div.
	*/
	@Test
	public void testDiv() {
		Calculator calc = new Calculator();
		calc.div(2, 2);
		assertThat(calc.getResult(), is(1d));
	}
}