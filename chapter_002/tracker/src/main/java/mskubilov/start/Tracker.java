package mskubilov.start;

import mskubilov.models.*;

import java.util.Random;
import java.util.Arrays;

/**
 * Tracker. Обертка над массивом заявок.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.0
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
	private static final Random RN = new Random();

	/**
	 * generateId. генерирует уникальный ID заявки.
	 * @return уникальный ID.
	 */
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
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
	public Item findByName(String name) {
		Item result = null;
		for (int index = 0; index != this.position; index++) {
			if (name.equals(this.items[index].getName())) {
				result = this.items[index];
				break;
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
}