package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TurnTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.02.2017
 * @version 1.0
 */
public class TurnTest {
	/**
	* Test IsTurnEven. - проверка переворачивания четного массива.
	*/
	@Test
	public void testIsTurnEven() {
		int[] in = new int[]{1, 2, 3, 4};
		int[] out = new int[]{4, 3, 2, 1};
		Turn turn = new Turn();
		assertThat(turn.back(in), is(out));
	}
	/**
	* Test IsTurnOdd. - проверка переворачивания нечетного массива.
	*/
	@Test
	public void testIsTurnOdd() {
		int[] in = new int[]{1, 2, 3};
		int[] out = new int[]{3, 2, 1};
		Turn turn = new Turn();
		assertThat(turn.back(in), is(out));
	}
}