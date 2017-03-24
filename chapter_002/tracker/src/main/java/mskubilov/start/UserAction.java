package mskubilov.start;

/**
 * UserAction. Интерфейс действия пользователя.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 23.03.2017
 * @version 1.0
 */

public interface UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	*/
	int key();

	/**
	 * execute. Метод для реализации действия.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	*/
	void execute(Input input, Tracker tracker);

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информация о действии.
	*/
	String info();
}