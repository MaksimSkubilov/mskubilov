package ru.job4j;

/**
 * Factor.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.02.2017
 * @version 1.0
 */

 public class Factor {
	/**
	 * calc. Вычисление факториала числа.
	 * @param n - число, факториал которого необходимо вычислить.
	 * @mult - произведение чисел.
	 * @index - индекс для цикла.
	 * @return - возвращает вычисленное значение факториала.
	 */
	public int calc(int n) {
		int mult = 1;
		if (n < 0) {
			mult = 0;
		}
		for (int index = 1; index <= n; index++) {
			mult = mult * index;
			}
		return mult;
		}
}