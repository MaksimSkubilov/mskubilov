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
	/**
	* Test IsTurnSquareEven. - проверка переворачивания квадратного
	*                      массива на 90 против часовой стрелки.
	*/
	@Test
	public void testIsTurnSquareEven() {
		int[][] in = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
		int[][] out = new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		Turn turn = new Turn();
		assertThat(turn.backSquare(in), is(out));
	}
	/**
	* Test IsTurnSquareOdd. - проверка переворачивания квадратного
	*                      массива на 90 против часовой стрелки.
	*/
	@Test
	public void testIsTurnSquareOdd() {
		int[][] in = new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
		int[][] out = new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
		Turn turn = new Turn();
		assertThat(turn.backSquare(in), is(out));
	}
}