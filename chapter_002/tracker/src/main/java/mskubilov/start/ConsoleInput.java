package mskubilov.start;

import java.util.*;

/**
 * ConsoleInput. Запрос ввода данных у пользователя, реализует интерфейс Input.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.03.2017
 * @version 2.0
 */

public class ConsoleInput implements Input {
	/**
	 * Scanner. Объект для сканирвоания введенных пользователем данных.
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
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ключ или исключение.
	 */
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range!");
		}
	}

	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ключ.
	 */

	 public String ask(String question, String[] range) {
		String key = this.ask(question);
		boolean exist = false;
		for (String type : range) {
			if (type.equals(key)) {
				exist = true;
				break;
			}
		}
		if (exist | key.equals("exit")) {
			return key;
		} else {
			throw new MenuOutException("Please try again!");
		}
	}
}