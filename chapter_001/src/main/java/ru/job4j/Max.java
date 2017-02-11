package ru.job4j;

/**
 * Max.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 09.02.2017
 * @version 1.0
 */

 public class Max {
	/**
	 * max. Сравнение.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 * @return - returns max of two numbers.
	 */
	public int max(int first, int second) {
		return first > second ? first : second;
	}
	/**
	 * maxOfThree. Сравнение трех чисел.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 * @param third - третий аргумент.
	 * @return - returns max of three numbers.
	 */
	public int maxOfThree(int first, int second, int third) {
		int maxOfFirstAndSecond = this.max(first, second);
		int maxOfSecondAndThird = this.max(second, third);
		return this.max(maxOfFirstAndSecond, maxOfSecondAndThird);
	}
}