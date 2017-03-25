package mskubilov.start;

import mskubilov.models.*;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Tracker. Обертка над массивом заявок.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.1
 */

public class Tracker {
	/**
	 * Массив заявок.
	 */
	private Item[] items = new Item[0];
	/**
	 * Индекс в массиве заявок, по которому добавляется текущая заявка.
	 */
	private int position = 0;
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
		Item[] buffer = Arrays.copyOf(this.items, this.items.length + 1);
		buffer[this.position++] = item;
		this.items = buffer;
		return item;
	}
	/**
	 * update. Обновление заявки в массиве заявок.
	 * @param item - заявка класса Item.
	 */
	public void update(Item item) {
		String id = item.getId();
		for (int index = 0; index != this.items.length; index++) {
			if (id.equals(this.items[index].getId())) {
				this.items[index] = item;
				break;
			}
		}
	}
	/**
	 * delete. Удаление заявки из массива заявок.
	 * @param item - заявка.
	 */
	public void delete(Item item) {
		for (int index = 0; index != this.position; index++) {
			if (item.getId().equals(this.items[index].getId())) {
				this.position--;
				Item[] buffer = new Item[this.items.length - 1];
				System.arraycopy(this.items, 0, buffer, 0, index);
				System.arraycopy(this.items, index + 1, buffer, index, this.items.length - index - 1);
				this.items = buffer;
				break;
			}
		}
	}
	/**
	 * getAll. Возвращает массив заявок.
	 * @return массив всех текущих заявок.
	 */
	public Item[] getAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}
	/**
	 * findByName. Возвращает первую совпавшую по имени заявку.
	 * @param name - имя заявки.
	 * @return Item.
	 */
	public Item[] findByName(String name) {
		Item[] result = new Item[0];
		int pos = 0;
		for (int index = 0; index != this.position; index++) {
			if (name.equals(this.items[index].getName())) {
				Item[] buffer = Arrays.copyOf(result, result.length + 1);
				buffer[pos++] = items[index];
				result = buffer;
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
	public String[] getIdsArray() {
		String[] result = new String[this.getAll().length];
		for (int i = 0; i != this.getAll().length; i++) {
			result[i] = this.getAll()[i].getId();
		}
		return result;
	}
	/**
	 * getNamesArray. Возвращает массив йадишников элементов трекера.
	 * @return массив id.
	 */
	public String[] getNamesArray() {
		String[] result = new String[this.getAll().length];
		for (int i = 0; i != this.getAll().length; i++) {
			result[i] = this.getAll()[i].getName();
		}
		return result;
	}
}