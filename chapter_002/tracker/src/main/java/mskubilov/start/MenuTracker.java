package mskubilov.start;

import mskubilov.models.*;

/**
 * MenuTracker. Реализация диалога с пользователем.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 23.03.2017
 * @version 1.0
 */

public class MenuTracker {

//Переменные состояния
	/**
	 * Интерфейс ввода данных.
	 */
	private Input input;

	/**
	 * Обертка над массивом заявок.
	 */
	private Tracker tracker;

	/**
	 * Массив возможных действий пользователя.
	 */
	private static UserAction[] actions = new UserAction[9];

	/**
	 * Количество действий.
	 */
	public static final int ACTIONS_VOL = actions.length;

// Конструкторы класса
	/**
	 * MenuTracker. Конструктор класса.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * fillActions. Метод, заполняющий массив возможных действий пользователя.
	 */
	public void fillActions() {
		this.actions[0] = this.new AddItem();
		this.actions[1] = this.new ShowItems();
		this.actions[2] = this.new EditItem();
		this.actions[3] = this.new DeleteItem();
		this.actions[4] = this.new FindById();
		this.actions[5] = this.new FindByName();
		this.actions[6] = this.new AddComment();
		this.actions[7] = this.new GetComments();
		this.actions[8] = this.new ExitTracker();
	}

	/**
	 * select. Метод, реализующий инициацию выбранного действия.
	 * @param key - ключ, указывающий на действие.
	 */
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}

	/**
	 * show. Метод, показывающий все возможные действия пользователю.
	 */
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}

//Внутренные классы.
/**
 * AddItem. Внутренний класс, реализуюший добавление заявки по интерфейсу UserAction.
 */
	private class AddItem implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 0;
		}

	/**
	 * execute. Метод добавляет заявку в трекер.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			String typeOfItem = input.ask("Please, enter the item's type (Task or Bug): ");
			String name = input.ask(String.format("Please, enter the %s's name: ", typeOfItem));
			String desc = input.ask(String.format("Please, enter the %s's desc: ", typeOfItem));
			if ("Task".equals(typeOfItem) || "task".equals(typeOfItem)) {
				tracker.add(new Task(name, desc));
			} else if ("Bug".equals(typeOfItem) || "bug".equals(typeOfItem)) {
				tracker.add(new Bug(name, desc));
			} else {
				tracker.add(new Item(name, desc));
			}
		}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Add the new item. ");
		}
	}

/**
 * ShowItems. Внутренний класс, реализуюший вывод всех заявок трекера по интерфейсу UserAction.
 */
	private class ShowItems implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 1;
		}

	/**
	 * execute. Метод выводит на экран все заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			for (Item item : tracker.getAll()) {
				System.out.printf(
					"ID: %s NAME: %-15s DESC: %-15s CREATE: %tT %<tD EMPTY_COMMENTS: %b%n",
					item.getId(), item.getName(), item.getDescription(), item.getCreate(), item.getComments().isEmpty()
				);
			}
		}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Show all items. ");
		}
	}

/**
 * EditItem. Класс, реализуюший редактирование заявки трекера по интерфейсу UserAction.
 */
	private class EditItem implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 2;
		}

	/**
	 * execute. Метод осуществляет редактирование заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			Item item;
			String id = input.ask("Please, enter the item's id for searching: ");
			if (tracker.findById(id) != null) {
				String typeOfItem = input.ask("Please, enter the new item's type (Task or Bug): ");
				String name = input.ask(String.format("Please, enter the %s's name: ", typeOfItem));
				String desc = input.ask(String.format("Please, enter the %s's desc: ", typeOfItem));
				if ("Task".equals(typeOfItem) || "task".equals(typeOfItem)) {
					item = new Task(name, desc);
				} else if ("Bug".equals(typeOfItem) || "bug".equals(typeOfItem)) {
					item = new Bug(name, desc);
				} else {
					item = new Item(name, desc);
				}
				item.setId(id);
				item.setComments(tracker.getComments(item));
				tracker.update(item);
			} else {
					System.out.println("There is no item of this ID in tracker!");
			}
		}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Edit item. ");
		}
	}


/**
 * DeleteItem. Класс, реализуюший удаление заявки трекера по интерфейсу UserAction.
 */
	private class DeleteItem implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 3;
		}

	/**
	 * execute. Метод осуществляет редактирование заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please, enter the item's id: ");
			if (tracker.findById(id) != null) {
				tracker.delete(tracker.findById(id));
			} else {
					System.out.println("There is no item of this ID in tracker!");
			}
	}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Delete item. ");
		}
	}

/**
 * FindById. Класс, реализуюший поиск по ID заявки трекера по интерфейсу UserAction.
 */
	private class FindById implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 4;
		}

	/**
	 * execute. Метод осуществляет редактирование заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please, enter the item's id: ");
			Item item = tracker.findById(id);
			if (item != null) {
				System.out.printf(
						"ID: %s NAME: %-15s DESC: %-15s CREATE: %tT %<tD EMPTY_COMMENTS: %b%n",
						item.getId(), item.getName(), item.getDescription(), item.getCreate(), item.getComments().isEmpty()
					);
			} else {
					System.out.println("There is no item of this ID in tracker!");
			}
	}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Find item by ID. ");
		}
	}

/**
 * FindByName. Класс, реализуюший поиск по имени заявки трекера по интерфейсу UserAction.
 */
	private class FindByName implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 5;
		}

	/**
	 * execute. Метод осуществляет редактирование заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the item's name: ");
			if (tracker.findByName(name).length > 0) {
				for (Item item : tracker.findByName(name)) {
					if (item != null) {
						System.out.printf(
							"ID: %s NAME: %-15s DESC: %-15s CREATE: %tT %<tD EMPTY_COMMENTS: %b%n",
							item.getId(), item.getName(), item.getDescription(), item.getCreate(), item.getComments().isEmpty()
						);
					}
				}
			} else {
					System.out.println("There are no items of this name in tracker!");
			}
		}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Find item by name. ");
		}
		}

/**
 * AddComment. Класс, реализуюший добавление комментария к заявке трекера по интерфейсу UserAction.
 */
	private class AddComment implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 6;
		}

	/**
	 * execute. Метод осуществляет редактирование заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please, enter the item's id for searching: ");
			if (tracker.findById(id) != null) {
				String comment = input.ask("Please, enter your comment^ ");
				tracker.addComment(id, comment);
			} else {
					System.out.println("There is no item of ID entered in tracker!");
			}
	}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Add a comment in item. ");
		}
	}

/**
 * GetComments. Класс, реализуюший вывод комментариев к заявке трекера по интерфейсу UserAction.
 */
	private class GetComments implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 7;
		}

	/**
	 * execute. Метод осуществляет редактирование заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please, enter the item's id for searching: ");
			Item item = tracker.findById(id);
			if (item != null) {
				for (int i = 0; i < tracker.getComments(item).size(); i++) {
					System.out.printf(
						"%s%n", tracker.getComments(item).get(i));
				}
			} else {
					System.out.println("There is no item of this ID in tracker!");
			}
		}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Show item's comments. ");
		}
	}

/**
 * ExitTracker. Класс, реализуюший вывод комментариев к заявке трекера по интерфейсу UserAction.
 */
	private class ExitTracker implements UserAction {

	/**
	 * key. Метод для установки уникального ключа действия пользователя.
	 * @return значение ключа.
	 */
		public int key() {
			return 8;
		}

	/**
	 * execute. Метод осуществляет редактирование заявки.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
		public void execute(Input input, Tracker tracker) {
			System.out.println("Thank you for using tracker!");
		}

	/**
	 * info. Метод для вывода информации о действии.
	 * @return информацию о действии, пункт меню.
	 */
		public String info() {
			return String.format("%s. %s", this.key(), "Exit tracker. ");
		}
	}
}