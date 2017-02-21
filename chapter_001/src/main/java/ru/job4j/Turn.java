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
}