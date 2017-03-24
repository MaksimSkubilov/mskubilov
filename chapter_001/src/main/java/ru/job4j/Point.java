package ru.job4j;

/**
 * Point.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 09.02.2017
 * @version 1.0
 */

 public class Point {
	/**
	 * x - координата по оси абсцисс.
	 */
	private double x;
	/**
	 * y - координата по оси ординат.
	 */
	private double y;
	/**
	 * Point. Передача координат точки.
	 * @param x - координата по оси абсцисс.
	 * @param y - координата по оси ординат.
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * distanceTo. Вычисление расстояния между двумя точками.
	 * @param point - новая точка точка.
	 * @return - возвращаем расстояние между точками.
	 */
	public double distanceTo(Point point) {
		return Math.sqrt(Math.pow((point.x - x), 2) + Math.pow((point.y - y), 2));
	}
}