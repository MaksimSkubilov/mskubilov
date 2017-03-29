package mskubilov.exceptions;

/**
 * OccupiedWayException. Исключение невозможного хода.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.03.2017
 * @version 1.0
 */

public class OccupiedWayException extends Exception {

	/**
	 * OccupiedWayException. Конструктор класса.
	 * @param msg - сообщение в TraceStack.
	 */

	public OccupiedWayException(String msg) {
		super(msg);
	}
}