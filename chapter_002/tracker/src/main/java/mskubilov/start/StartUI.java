package mskubilov.start;

import mskubilov.models.*;

/**
 * StartUI. Класс для запуска трекера.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 23.03.2017
 * @version 1.0
 */

public class StartUI {
	/**
	 * интерфейс ввода данных.
	 */
	private Input input;
	/**
	 * трекер.
	 */
	private Tracker tracker;

// Конструкторы класса
	/**
	 * StartUI. Конструктор класса.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * init. Метод, реализующий взаимодействие пользователя с трекером.
	 */
	public void init() {
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		menu.fillActions();
		String menuPos = "";
		do {
			menu.show();
			do {
				if (!"0".equals(menuPos) && tracker.getAll().length == 0) {
					do {
						menuPos = input.ask("The tracker is empty now. Please, select 0 to add item or 8 to exit: ");
					} while (!"0".equals(menuPos) && !"8".equals(menuPos));
				} else {
				menuPos = input.ask("Please, select menu position: ");
				}
			} while (Integer.valueOf(menuPos) >= menu.ACTIONS_VOL);
			menu.select(Integer.valueOf(menuPos));
		} while (!menuPos.equals("8"));
	}
	/**
	 * main.
	 * @param args - аргументы.
	 */
	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker).init();
	}
}