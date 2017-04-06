package mskubilov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TestSnake.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 03.04.2017
 * @version 1.0
 */

public class TestSnake {
	/**
	 * Test of snaking square Array on rows.
	 * @throws ArrayIndexOutOfBoundsException - исключение неквадратного массива.
	 */
	@Test
	public void testSnake() throws ArrayIndexOutOfBoundsException {
		int[][] source = {{1, 2}, {1, 2}};
		int[] out = {1, 2, 2, 1};
		Snake snake = new Snake();
		int[] result = snake.toArray(source);
		assertThat(result, is(out));
	}
	/**
	 * Test of snaking square Array on round.
	 * @throws ArrayIndexOutOfBoundsException - исключение неквадратного массива.
	 */
	@Test
	public void testSnakeOnRound3() throws ArrayIndexOutOfBoundsException {
		int[][] source = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		int[] out = {1, 2, 3, 3, 3, 2, 1, 1, 2};
		SnakeOnRound snakeOnRound = new SnakeOnRound();
		int[] result = snakeOnRound.toArray(source);
		assertThat(result, is(out));
	}
	/**
	 * Test of snaking square Array on round.
	 * @throws ArrayIndexOutOfBoundsException - исключение неквадратного массива.
	 */
	@Test
	public void testSnakeOnRound2() throws ArrayIndexOutOfBoundsException {
		int[][] source = {{1, 2}, {1, 2}};
		int[] out = {1, 2, 2, 1};
		SnakeOnRound snakeOnRound = new SnakeOnRound();
		int[] result = snakeOnRound.toArray(source);
		assertThat(result, is(out));
	}
	/**
	 * Test of snaking square Array on round.
	 * @throws ArrayIndexOutOfBoundsException - исключение неквадратного массива.
	 */
	@Test
	public void testSnakeOnRound4() throws ArrayIndexOutOfBoundsException {
		int[][] source = {
				{1, 2, 3, 4},
				{1, 2, 3, 4},
				{1, 2, 3, 4},
				{1, 2, 3, 4},
		};
		int[] out = {1, 2, 3, 4, 4, 4, 4, 3, 2, 1, 1, 1, 2, 3, 3, 2};
		SnakeOnRound snakeOnRound = new SnakeOnRound();
		int[] result = snakeOnRound.toArray(source);
		assertThat(result, is(out));
	}
}