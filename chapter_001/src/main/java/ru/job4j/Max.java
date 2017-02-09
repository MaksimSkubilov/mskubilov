package ru.job4j;

/**
 * Max.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 09.02.2017
 * @version 1.0
 */

 public class Max {
	/**
	 * Результат сравнения двух чисел.
	 */
	private int result;
	/**
	 * max. Сравнение.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void max(int first, int second) {
		this.result = first > second ? first : second;
	}
	/**
	 * Получить результат.
	 * @return - результат сравнения, возвращает максимальное из двух чисел.
	 */
	public int getResult() {
		return this.result;
	}
	/**
	 * Очистить результат сравнения.
	 */
	 public void cleanResult() {
		this.result = 0;
	 }
}