package mskubilov.start;

import java.util.*;

/**
 * ConsoleInput. Запрос ввода данных у пользователя, реализует интерфейс Input.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.03.2017
 * @version 1.0
 */

public class ConsoleInput implements Input {
	/**
	 * Scanner. Объект для сканирвоания введенных польхователем данных.
	 */
	private Scanner scanner = new Scanner(System.in);
	/**
	* ask. Метод для считывания введенных данных.
	* @param question - вопрос пользователю.
	* @return пользовательский ввод.
	*/
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
}