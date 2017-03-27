package mskubilov.start;

/**
 * BaseAction. Абстрактный класс действия пользователя.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 27.03.2017
 * @version 1.0
 */

public abstract class BaseAction implements UserAction {
	/**
	 * name. описание действия пользователя.
	*/
	private String name;
	/**
	 * BaseAction. Конструктор класса.
	 * @param name - описание действия пользователя.
	*/
	public BaseAction(String name) {
		this.name = name;
	}
	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	*/
	public abstract int key();

	/**
	 * execute. Метод для реализации действия.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	*/
	public abstract void execute(Input input, Tracker tracker);

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информация о действии.
	*/
	public String info()  {
			return String.format("%s. %s", this.key(), this.name);
		}
}