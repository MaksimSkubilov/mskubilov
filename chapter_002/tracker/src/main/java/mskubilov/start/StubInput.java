package mskubilov.start;

/**
 * StubInput. Имитация ввода данных пользователем, реализует интерфейс Input.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.03.2017
 * @version 2.0
 */

public class StubInput implements Input {
	/**
	 * Массив ответов пользователя.
	 */
	private String[] answers;
	/**
	 * Позиция в массиве.
	 */
	private int position = 0;

// Конструкторы класса
	/**
	 * StubInput. Конструктор класса.
	 * @param answers - массив ответов пользователя.
	 */

	public StubInput(String[] answers) {
		this.answers = answers;
	}

// Методы
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @return ответ из массива ответов.
	 */
	public String ask(String question) {
		return answers[position++];
	}
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ответ из массива ответов.
	 */
	public int ask(String question, int[] range) {
		return Integer.valueOf(answers[position++]);
	}
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ответ из массива ответов.
	 */
	public String ask(String question, String[] range) {
		return answers[position++];
	}
}