package mskubilov;

/**
 * Main. Класс для запуска приложения.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.03.2017
 * @version 1.0
 */
public class Main {
	/**
	 * main.
	 * @param args - аргументы.
	 */
	public static void main(String[] args) {
		new Paint().draw(new Triangle());
		new Paint().draw(new Quadrate());
	}
}