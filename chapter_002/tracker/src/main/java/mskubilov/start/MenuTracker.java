package mskubilov.start;

import mskubilov.models.*;

import java.util.ArrayList;

/**
 * MenuTracker. Реализация диалога с пользователем.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.04.2017
 * @version 3.0
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
	private ArrayList<UserAction> actions = new ArrayList<UserAction>();;

	/**
	 * Финальное количество действий поьзователя.
	 */
	private int actionsVol;
	/**
	 * Типы заявок.
	 */
	private ArrayList<String> itemType = new ArrayList<String>(2);

// Конструкторы класса
	/**
	 * MenuTracker. Конструктор класса.
	 * @param input - интерфейс ввода данных.
	 * @param tracker - трекер.
	 */
	MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * fillActions. Метод, заполняющий массив возможных действий пользователя.
	 */
	void fillActions() {
	    this.itemType.add("Task");
	    this.itemType.add("Bug");
		this.actions.add(this.new AddItem("Add the new item. "));
		this.actions.add(this.new ShowItems("Show all items. "));
		this.actions.add(this.new EditItem("Edit item. "));
		this.actions.add(this.new DeleteItem("Delete item. "));
		this.actions.add(this.new FindById("Find item by ID. "));
		this.actions.add(this.new FindByName("Find item by name. "));
		this.actions.add(this.new AddComment("Add a comment in item. "));
		this.actions.add(this.new GetComments("Show item's comments. "));
		this.actions.add(this.new ExitTracker("Exit tracker. "));
        this.actionsVol = actions.size();
	}

	/**
	 * select. Метод, реализующий инициацию выбранного действия.
	 * @param key - ключ, указывающий на действие.
	 */
	void select(int key) {
		this.actions.get(key).execute(this.input, this.tracker);
	}
	/**
	 * show. Метод, показывающий все возможные действия пользователю.
	 */
	void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
    /**
     * getActionsVol. Метод, возвращающий количество пунктов меню.
     * @return actionsVol
     */
    public int getActionsVol() {
        return this.actionsVol;
    }

//Внутренные классы.
	/**
	 * AddItem. Внутренний класс, реализуюший добавление заявки по интерфейсу UserAction.
	 */
	private class AddItem extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private AddItem(String name) {
			super(name);
		}
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
			String typeOfItem = input.ask(itemType, "Please, enter the item's type (Task or Bug): ");
			if (!typeOfItem.equals("exit")) {
				String name = input.ask(String.format("Please, enter the %s's name: ", typeOfItem));
				String desc = input.ask(String.format("Please, enter the %s's desc: ", typeOfItem));
				if ("Task".equals(typeOfItem)) {
					tracker.add(new Task(name, desc));
				} else {
					tracker.add(new Bug(name, desc));
				}
			} else {
				System.out.println("");
			}
		}
	}

	/**
	 * ShowItems. Внутренний класс, реализуюший вывод всех заявок трекера по интерфейсу UserAction.
	 */
	private class ShowItems extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private ShowItems(String name) {
			super(name);
		}

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
	}

	/**
	 * EditItem. Класс, реализуюший редактирование заявки трекера по интерфейсу UserAction.
	 */
	private class EditItem extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private EditItem(String name) {
			super(name);
		}

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
			String id = input.ask(tracker.getIdsArray(), "Please, enter the item's id for searching: ");
			if (tracker.findById(id) != null) {
				String typeOfItem = input.ask(itemType, "Please, enter the new item's type (Task or Bug): ");
				if (!typeOfItem.equals("exit")) {
					String name = input.ask(String.format("Please, enter the %s's name: ", typeOfItem));
					String desc = input.ask(String.format("Please, enter the %s's desc: ", typeOfItem));
					if ("Task".equals(typeOfItem)) {
						item = new Task(name, desc);
					} else {
						item = new Bug(name, desc);
					}
					item.setId(id);
					item.setComments(tracker.getComments(tracker.findById(id)));
					tracker.update(item);
				} else {
					System.out.println("");
				}
			}
		}
	}


	/**
	 * DeleteItem. Класс, реализуюший удаление заявки трекера по интерфейсу UserAction.
	 */
	private class DeleteItem extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private DeleteItem(String name) {
			super(name);
		}

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
			String id = input.ask(tracker.getIdsArray(), "Please, enter the item's id: ");
			if (tracker.findById(id) != null) {
				tracker.delete(tracker.findById(id));
			}
		}
	}

	/**
	 * FindById. Класс, реализуюший поиск по ID заявки трекера по интерфейсу UserAction.
	 */
	private class FindById extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private FindById(String name) {
			super(name);
		}

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
			String id = input.ask(tracker.getIdsArray(), "Please, enter the item's id: ");
			Item item = tracker.findById(id);
			if (item != null) {
				System.out.printf(
						"ID: %s NAME: %-15s DESC: %-15s CREATE: %tT %<tD EMPTY_COMMENTS: %b%n",
						item.getId(), item.getName(), item.getDescription(), item.getCreate(), item.getComments().isEmpty()
				);
			}
		}
	}

	/**
	 * FindByName. Класс, реализуюший поиск по имени заявки трекера по интерфейсу UserAction.
	 */
	private class FindByName extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private FindByName(String name) {
			super(name);
		}

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
			String name = input.ask(tracker.getNamesArray(), "Please, enter the item's name: ");
			if (name.equals("8")) {
				System.out.println("");
			}
			if (tracker.findByName(name).size() > 0) {
				for (Item item : tracker.findByName(name)) {
					if (item != null) {
						System.out.printf(
								"ID: %s NAME: %-15s DESC: %-15s CREATE: %tT %<tD EMPTY_COMMENTS: %b%n",
								item.getId(), item.getName(), item.getDescription(), item.getCreate(), item.getComments().isEmpty()
						);
					}
				}
			}
		}
	}

	/**
	 * AddComment. Класс, реализуюший добавление комментария к заявке трекера по интерфейсу UserAction.
	 */
	private class AddComment extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private AddComment(String name) {
			super(name);
		}

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
			String id = input.ask(tracker.getIdsArray(), "Please, enter the item's id for searching: ");
			if (tracker.findById(id) != null) {
				String comment = input.ask("Please, enter your comment: ");
				tracker.addComment(id, comment);
			}
		}
	}

	/**
	 * GetComments. Класс, реализуюший вывод комментариев к заявке трекера по интерфейсу UserAction.
	 */
	private class GetComments extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private GetComments(String name) {
			super(name);
		}

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
			String id = input.ask(tracker.getIdsArray(), "Please, enter the item's id for searching: ");
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
	}

	/**
	 * ExitTracker. Класс, реализуюший вывод комментариев к заявке трекера по интерфейсу UserAction.
	 */
	private class ExitTracker extends BaseAction {
		/**
		 * Конструктор класса.
		 * @param name - описание действия пользователя.
		 */
		private ExitTracker(String name) {
			super(name);
		}

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
	}
}