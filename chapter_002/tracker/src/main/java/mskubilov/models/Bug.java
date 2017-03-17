package mskubilov.models;

/**
 * Bug. Баг. Подкласс суперкласса Item.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.0
 */

public class Bug extends Item {
	/**
	* Bug. Конструктор класса.
	* @param name - имя заявки.
	* @param description - описание заявки.
	* @param create - дата создания заявки.
	*/
	public Bug(String name, String description, long create) {
		super(name, description, create);
	}
}