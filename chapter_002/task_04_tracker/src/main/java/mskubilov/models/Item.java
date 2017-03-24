package mskubilov.models;

/**
 * Item. Заявка. Суперкласс.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.0
 */

public class Item {
	/**
	 * ID заявки.
	 */
	private String id;
	/**
	 * Имя заявки.
	 */
	private String name;
	/**
	 * Описание заявки.
	 */
	private String description;
	/**
	 * Дата создания заявки.
	 */
	private long create;

// Конструкторы класса
	/**
	 * Item. Дефолтный конструктор класса.
	 */
	public Item() {
		this.create = System.currentTimeMillis();
	}
	/**
	* Item. Конструктор класса.
	* @param name - имя заявки.
	* @param description - описание заявки.
	*/
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		this.create = System.currentTimeMillis();
	}

// Геттеры и сеттеры для полей состояния

	/**
	 * setId. Метод для установки id.
	 * @param id - id заявки.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * getID. Возвращает id.
	 * @return id заявки
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * setName. Метод для установки name.
	 * @param name - имя заявки.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getName. Возвращает name.
	 * @return имя заявки
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * setDescription. Метод для установки description.
	 * @param description - описание заявки.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * getDescription. Возвращает description.
	 * @return описание заявки
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * setCreate. Метод для установки create.
	 * @param create - дата создания заявки.
	 */
	public void setCreate(long create) {
		this.create = create;
	}
	/**
	 * getCreate. Возвращает create.
	 * @return дата создания заявки
	 */
	public long getCreate() {
		return this.create;
	}
}