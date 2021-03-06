package mskubilov.models;

import java.util.ArrayList;

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
	/**
	 * Массив комментариев.
	 */
	private ArrayList<String> comments;

// Конструкторы класса
	/**
	 * Item. Дефолтный конструктор класса.
	 */
	public Item() {
		this.create = System.currentTimeMillis();
		this.comments = new ArrayList<String>();
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
		this.comments = new ArrayList<String>();
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
	/**
	 * addComment. Метод для добавления комментария.
	 * @param comment - дата создания заявки.
	 */
	public void addComment(String comment) {
		this.comments.add(comment);
	}
	/**
	 * getComment. Возвращает комментарии.
	 * @return комментарий
	 */
	public ArrayList<String> getComments() {
		return this.comments;
	}
	/**
	 * setComment. Записывает комментарии.
	 * @param comments - комментариии.
	 */
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
}