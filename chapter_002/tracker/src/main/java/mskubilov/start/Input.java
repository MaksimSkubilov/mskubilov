package mskubilov.start;

/**
 * Input. Интерфейс ввода данных.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.03.2017
 * @version 2.0
 */

public interface Input {
	/**
	 * ask. Метод для считывания данных.
	 * @param question - вопрос.
	 * @return ввод данных.
	 */
	String ask(String question);
	/**
	 * ask. Метод для считывания данных.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ввод данных.
	 */
	int ask(String question, int[] range);
	/**
	 * ask. Метод для считывания данных.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ввод данных.
	 */
	String ask(String question, String[] range);
}