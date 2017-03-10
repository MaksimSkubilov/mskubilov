package ru.job4j;

/**
 * Sort. Сортировка массива методом пузырька.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.02.2017
 * @version 1.0
 */

 public class Sort {
	/**
	 * back. Переворачивает массив целых чисел.
	 * @param values - массив целых чисел.
	 * @return - возвращает отсортированный массив.
	 */
	public int[] vial(int[] values) {
		for (int i = 0; i < values.length - 2; i++) {
			for (int j = 0; j < values.length - 1 - i; j++) {
				if (values[j + 1] < values[j]) {
					int a = values[j];
					values[j] = values[j + 1];
					values[j + 1] = a;
				}
			}
		}
		return values;
	}
}