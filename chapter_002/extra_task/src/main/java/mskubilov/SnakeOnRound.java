package mskubilov;

/**
 * SnakeOnRound. Змейка по кругу.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 03.04.2017
 * @version 1.0
 */

public class SnakeOnRound {
	/**
	 * toArray. Возвращает по кругу змейкой в одномерный массив значения двумерного массива.
	 * @param source - квадратный массив.
	 * @throws ArrayIndexOutOfBoundsException - исключение неквадратного массива.
	 * @return массив значений квадратного массива змейкой.
	 */
	public int[] toArray(int[][] source) throws ArrayIndexOutOfBoundsException {
		int column = 0;
		if (source.length != 0) {
			for (int i = 0; i != source.length; i++) {
				column = source[i].length;
			}
			if (source.length != column) {
				throw new ArrayIndexOutOfBoundsException("Входящий массив не квадратный!");
			}
		} else {
			throw new ArrayIndexOutOfBoundsException("Входящий массив не содержит элементов!");
		}
		int[] result = new int[column * column];
		int index = 0;
		int i = 0;
		int j = 0;
		for (int m = 0; m < column; m++) {
			for (; j < column - m; j++) {
				result[index++] = source[i][j];
			}
			--j;
			for (++i; i < column - m; i++) {
				result[index++] = source[i][j];
			}
			--i;
			for (--j; j > m; j--) {
				result[index++] = source[i][j];
			}
			for (; i > m; i--) {
				result[index++] = source[i][j];
			}
			j++;
			i++;
		}
		return result;
	}
}