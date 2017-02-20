package ru.job4j;

/**
 * Counter.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.02.2017
 * @version 1.0
 */

 public class Counter {
	/**
	 * addFor. Сложение четных чисел с помощью цикла for.
	 * @param start - начало диапазона.
	 * @param finish - конец диапазона.
	 * @summ - сумма четных чисел.
	 * @index - индекс для цикла.
	 * @return - returns max of two numbers.
	 */
	public int addFor(int start, int finish) {
		int summ = 0;
		for (int index = start; index <= finish; index++) {
			if (index % 2 == 0) {
				summ = summ + index;
			}
		}
		return summ;
	}
	/**
	 * addWhile. Сложение четных чисел с помощью цикла while.
	 * @param start - начало диапазона.
	 * @param finish - конец диапазона.
	 * @summ - сумма четных чисел.
	 * @index - индекс для цикла.
	 * @return - returns max of two numbers.
	 */
	public int addWhile(int start, int finish) {
		int summ = 0;
		int index = start;
		while (index <= finish) {
			if (index % 2 == 0) {
				summ = summ + index;
			}
			index++;
		}
		return summ;
	}
	/**
	 * addDoWhile. Сложение четных чисел с помощью цикла do while.
	 * @param start - начало диапазона.
	 * @param finish - конец диапазона.
	 * @summ - сумма четных чисел.
	 * @index - индекс для цикла.
	 * @return - returns max of two numbers.
	 */
	public int addDoWhile(int start, int finish) {
		int summ = 0;
		int index = start;
		do {
			if (index % 2 == 0) {
				summ = summ + index;
			}
			index++;
		} while (index <= finish);
		return summ;
	}
}