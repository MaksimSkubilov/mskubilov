package mskubilov.start;

import mskubilov.models.*;

/**
 * StartUI. Класс для запуска трекера.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.0
 */

public class StartUI {
	/**
	 * main.
	 * @param args - аргументы.
	 */
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		tracker.add(new Task("first task", "first desk", 0));
		for (Item item : tracker.getAll()) {
			System.out.println(item.getName());
		}
	}
}