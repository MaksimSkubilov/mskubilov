package ru.job4j;

/**
 * Turn.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.02.2017
 * @version 1.0
 */

 public class Turn {
	/**
	 * back. Переворачивает массив целых чисел.
	 * @param args - массив целых чисел.
	 * @return - возвращает перевернутый массив.
	 */
	public int[] back(int[] args) {
		for (int i = 0; i < args.length / 2; i++) {
			int a = args[i];
			args[i] = args[args.length - 1 - i];
			args[args.length - 1 - i] = a;
		}
		return args;
	}
	/**
	 * backSquare. Поворачивает на 90 градусов квадратный массив целых чисел.
	 * @param args - двумерный массив целых чисел.
	 * @return - возвращает перевернутый массив.
	 */
	public int[][] backSquare(int[][] args) {
		int k = args.length;
		int n = args[0].length;
		for (int i = 0; i < k - i; i++) {
			for (int j = 0; j < n / 2; j++) {
				int a = args[i][j];
				args[i][j] = args[j][n - 1 - i];
				args[j][n - 1 - i] = args[k - 1 - i][n - 1 - j];
				args[k - 1 - i][n - 1 - j] = args[k - 1 - j][i];
				args[k - 1 - j][i] = a;
			}
		}
		return args;
	}
}