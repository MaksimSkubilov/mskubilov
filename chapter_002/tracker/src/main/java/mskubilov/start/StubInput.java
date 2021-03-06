package mskubilov.start;

import java.util.ArrayList;

/**
 * StubInput. Имитация ввода данных пользователем, реализует интерфейс Input.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.04.2017
 * @version 3.0
 */

public class StubInput implements Input {
	/**
	 * Массив ответов пользователя.
	 */
	private ArrayList<String> answers;
	/**
	 * Позиция в массиве.
	 */
	private int position = 0;

// Конструкторы класса
	/**
	 * StubInput. Конструктор класса.
	 * @param answers - массив ответов пользователя.
	 */

	public StubInput(ArrayList<String> answers) {
		this.answers = answers;
	}

// Методы
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @return ответ из массива ответов.
	 */
	public String ask(String question) {
		return answers.get(position++);
	}
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ответ из массива ответов.
	 */
	public int ask(String question, ArrayList<Integer> range) {
		return Integer.valueOf(answers.get(position++));
	}
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ответ из массива ответов.
	 */
	public String ask(ArrayList<String> range, String question) {
		return answers.get(position++);
	}
}