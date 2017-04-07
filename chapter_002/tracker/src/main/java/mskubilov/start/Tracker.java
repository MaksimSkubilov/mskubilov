package mskubilov.start;

import mskubilov.models.*;

import java.util.ArrayList;

/**
 * Tracker. Обертка над массивом заявок.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.04.2017
 * @version 3.0
 */

public class Tracker {
	/**
	 * Массив заявок.
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * Объект класса Random из пакета java.util для генерации ID.
	 */
	private int id = 1;

	/**
	 * generateId. генерирует уникальный ID заявки.
	 * @return уникальный ID.
	 */
	String generateId() {
		return String.valueOf(id++);
	}
	/**
	 * add. Добавление заявки в массив заявок.
	 * @param item - заявка класса Item.
	 * @return заявка с присвоенным ID.
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		items.add(item);
		return item;
	}
	/**
	 * update. Обновление заявки в массиве заявок.
	 * @param item - заявка класса Item.
	 */
	public void update(Item item) {
		String id = item.getId();
		for (int index = 0; index != this.items.size(); index++) {
			if (id.equals(this.items.get(index).getId())) {
				this.items.remove(index);
				this.items.add(item);
				break;
			}
		}
	}
	/**
	 * delete. Удаление заявки из массива заявок.
	 * @param item - заявка.
	 */
	public void delete(Item item) {
		for (int index = 0; index != this.items.size(); index++) {
			if (item.getId().equals(this.items.get(index).getId())) {
				this.items.remove(index);
				break;
			}
		}
	}
	/**
	 * getAll. Возвращает массив заявок.
	 * @return массив всех текущих заявок.
	 */
	public ArrayList<Item> getAll() {
		ArrayList<Item> result = new ArrayList<Item>();
		for (int index = 0; index != this.items.size(); index++) {
			result.add(this.items.get(index));
		}
		return result;
	}
	/**
	 * findByName. Возвращает массив совпавших по имени заявок.
	 * @param name - имя заявки.
	 * @return Item.
	 */
	public ArrayList<Item> findByName(String name) {
		ArrayList<Item> result = new ArrayList<Item>();
		int pos = 0;
		for (int index = 0; index != this.items.size(); index++) {
			if (name.equals(this.items.get(index).getName())) {
				result.add(this.items.get(index));
			}
		}
		return result;
	}
	/**
	 * findById. Поиск заявки в массиве заявок по ID.
	 * @param id - ID заявки.
	 * @return заявка с нужным ID.
	 */
	public Item findById(String id) {
		Item result = null;
		for (Item item: items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	/**
	 * addComment. Поиск заявки в массиве по ID и добавление комментария.
	 * @param comment - комментарий.
	 * @param id - ID заявки.
	 */
	public void addComment(String id, String comment) {
		for (Item item: items) {
			if (item != null && item.getId().equals(id)) {
				item.addComment(comment);
				break;
			}
		}
	}
	/**
	 * getComments. Возвращает комментарии к заявке.
	 * @param itm - заявка.
	 * @return комментарии.
	 */
	public ArrayList<String> getComments(Item itm) {
		ArrayList<String> result = new ArrayList<String>();
		for (Item item: items) {
			if (item != null && item.getId().equals(itm.getId())) {
				result = item.getComments();
				break;
			}
		}
		return result;
	}
	/**
	 * getIdsArray. Возвращает массив йадишников элементов трекера.
	 * @return массив id.
	 */
	public ArrayList<String> getIdsArray() {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i != this.getAll().size(); i++) {
			result.add(this.getAll().get(i).getId());
		}
		return result;
	}
	/**
	 * getNamesArray. Возвращает массив имен элементов трекера.
	 * @return массив id.
	 */
	public ArrayList<String> getNamesArray() {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i != this.getAll().size(); i++) {
			result.add(this.getAll().get(i).getName());
		}
		return result;
	}
}