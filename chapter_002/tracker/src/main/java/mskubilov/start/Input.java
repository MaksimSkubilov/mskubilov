package mskubilov.start;

import java.util.ArrayList;

/**
 * Input. Интерфейс ввода данных.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.04.2017
 * @version 3.0
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
	int ask(String question, ArrayList<Integer> range);
	/**
	 * ask. Метод для считывания данных.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ввод данных.
	 */
	String ask(ArrayList<String> range, String question);
}