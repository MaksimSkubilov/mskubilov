package mskubilov;

/**
 * Snake. Змейка.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 03.04.2017
 * @version 1.0
 */

public class Snake {
	/**
	 * toArray. Возвращает построчной змейкой в одномерный массив значения двумерного массива.
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
		int temp = 0;
		do {
			if ((temp + 1) % 2 != 0) {
				for (int i = 0; i != column; i++) {
					result[index++] = source[temp][i];
				}
				temp++;
			} else {
				for (int i = (column - 1); i != -1; i--) {
					result[index++] = source[temp][i];
				}
				temp++;
			}
		} while (index != column * column);
		return result;
	}
}