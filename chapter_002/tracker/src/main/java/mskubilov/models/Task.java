package mskubilov.models;

/**
 * Task. Задание. Подкласс суперкласса Item.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.0
 */

public class Task extends Item {
	/**
	* Task. Конструктор класса.
	* @param name - имя заявки.
	* @param description - описание заявки.
	*/
	public Task(String name, String description) {
		super(name, description);
	}
}