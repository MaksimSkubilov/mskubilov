package ru.job4j;

/**
 * Calculator.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.02.2017
 * @version 1.0
 */

 public class Calculator {
	/**
	 * Результат вычисления.
	 */
	private double result;
	/**
	 * add. Сложение аргументов.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void add(double first, double second) {
					this.result = first + second;
	}
	/**
	 * sub. Вычитание аргументов.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void sub(double first, double second) {
					this.result = first - second;
	}
	/**
	 * mult. Произведение аргументов.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void mult(double first, double second) {
					this.result = first * second;
	}
	/**
	 * div. Деление аргументов.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void div(double first, double second) {
					this.result = first / second;
	}
	/**
	 * Получить результат.
	 * @return - результат вычисления.
	 */
	public double getResult() {
		return this.result;
	}
	/**
	 * Очистить результат вычисления.
	 */
	 public void cleanResult() {
		this.result = 0d;
	 }
}