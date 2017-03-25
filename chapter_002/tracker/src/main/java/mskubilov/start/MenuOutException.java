package mskubilov.start;

/**
 * MenuOutException. Исключение ввода отсутствующего пункта меню.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 25.03.2017
 * @version 1.0
 */

public class MenuOutException extends RuntimeException {

	/**
	 * MenuOutException. Конструктор класса.
	 * @param msg - ответ пользователю.
	 */

	public MenuOutException(String msg) {
		super(msg);
	}
}