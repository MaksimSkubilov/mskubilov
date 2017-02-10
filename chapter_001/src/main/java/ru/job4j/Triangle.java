package ru.job4j;

/**
 * Triangle.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 09.02.2017
 * @version 1.0
 */

 public class Triangle {
	/**
	 * @Point a - первая точка.
	 */
	private Point a;
	/**
	 * @Point b - вторая точка.
	 */
	private Point b;
	/**
	 * @Point c - третья точка.
	 */
	private Point c;
	/**
	 * Triangle. Формирование треугольника.
	 * @param a - первая точка.
	 * @param b - вторая точка.
	 * @param c - третья точка.
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	 * area. Вычисление площади треугольника.
	 * @return - возвращаем площадь треугольника.
	 */
	public double area() {
		double sideA = a.distanceTo(b);
		double sideB = b.distanceTo(c);
		double sideC = c.distanceTo(a);
		double p = (sideA + sideB + sideC) / 2;
		if (sideA == 0d && sideB == 0d && sideC == 0d) {
			return 0d;
		} 	else {
				return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
			}
	}
}