package mskubilov.exceptions;

/**
 * ImpossibleMoveException. Исключение невозможного хода.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.03.2017
 * @version 1.0
 */

public class ImpossibleMoveException extends Exception {

	/**
	 * ImpossibleMoveException. Конструктор класса.
	 * @param msg - сообщение в TraceStack.
	 */

	public ImpossibleMoveException(String msg) {
		super(msg);
	}
}