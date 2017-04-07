package mskubilov.start;

import java.util.ArrayList;

/**
 * StartUI. Класс для запуска трекера.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.04.2017
 * @version 3.0
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
	/**
	 * диапазон меню.
	 */
	private ArrayList<Integer> range;;

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
		range = new ArrayList<Integer>();
		for (int i = 0; i != menu.getActionsVol(); i++) {
			this.range.add(i);
		}
		int menuPos = -1;
		do {
			menuPos = -1;
			menu.show();
			do {
				if (!(menuPos == 0) && tracker.getAll().size() == 0) {
					do {
						menuPos = input.ask("The tracker is empty now. Please, select 0 to add item or 8 to exit: ", range);
					} while (!(menuPos == 0) && !(menuPos == 8));
				} else {
				menuPos = input.ask("Please, select menu position: ", range);
				}
			} while (menuPos >= menu.getActionsVol());
			menu.select(menuPos);
		} while (!(menuPos == 8));
	}
	/**
	 * main.
	 * @param args - аргументы.
	 */
	public static void main(String[] args) {
		Input input = new ValidateInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker).init();
	}
}