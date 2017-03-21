package mskubilov.start;

import mskubilov.models.*;
import java.util.Date;

/**
 * StartUI. Класс для запуска трекера.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.1
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
		Menu menu = new Menu();
		boolean isPrintMenu = true;
		System.out.println("Welcome to Item's Tracker!");
		String itemID;
		Item item;
		Item[] allItems;
		boolean isItemExist;
		do {
			menu.printMainMenu();
			switch (input.ask("Please select number from 0 to 6 and press Enter: ")) {
				case "1":
					String name = input.ask("Please enter task's name: ");
					String desc = input.ask("Please enter task's description: ");
					tracker.add(new Item(name, desc));
					break;
				case "2":
					allItems = tracker.getAll();
					System.out.println("Tracker includes total " + allItems.length + " Items:");
					for (Item items : allItems) {
						System.out.println("ID: " + items.getId() + " Name: " + items.getName() + " Description: " + items.getDescription() + " Create time:  " + new Date(items.getCreate()));
					}
					break;
				case "3":
					itemID = input.ask("For editing a field in the Item you must know Item's ID.\nIf you don't know ID, get back to the main menu by entering 0 and select position 2.Show all items\nIf you know Item's ID please type it here: ");
					isItemExist = false;
					do {
						if (tracker.findById(itemID) != null && tracker.findById(itemID).getId().equals(itemID)) {
						isItemExist = true;
						menu.printSubMenu();
						switch (input.ask("Which field do you want to edit?\nYou can edit Name or Description: ")) {
							case "0":
								break;
							case "1":
								name = input.ask("Please enter new task's name: ");
								item = tracker.findById(itemID);
								item.setName(name);
								tracker.update(item);
								break;
							case "2":
								desc = input.ask("Please enter new task's description: ");
								item = tracker.findById(itemID);
								item.setDescription(desc);
								tracker.update(item);
								break;
							default:
								System.out.println("Sorry, but your selection is wrong!\nEnter number from 0 to 3!");
								break;
						}
						} else if (itemID.equals("0")) {
							isItemExist = true;
						} else {
							System.out.print("Please re-enter ID or exit by entering 0: ");
							itemID = input.ask("");
						}
					} while (!isItemExist);
					break;
				case "4":
					itemID = input.ask("For deleting Item from tracker you must know Item's ID.\nIf you don't know ID, get back to the main menu by entering 0 and select position 2.Show all items\nIf you know Item's ID please type it here: ");
					isItemExist = false;
					do {
						if (tracker.findById(itemID) != null && tracker.findById(itemID).getId().equals(itemID)) {
							isItemExist = true;
							item = tracker.findById(itemID);
							tracker.delete(item);
						} else if (itemID.equals("0")) {
							isItemExist = true;
						} else {
							System.out.print("Please re-enter ID or exit by entering 0: ");
							itemID = input.ask("");
						}
					} while (!isItemExist);
					break;
				case "5":
					itemID = input.ask("For searching by ID you must know Item's ID.\nIf you don't know ID, get back to the main menu by entering 0 and select position 2.Show all items\nIf you know Item's ID please type it here: ");
					isItemExist = false;
					do {
						if (tracker.findById(itemID) != null && tracker.findById(itemID).getId().equals(itemID)) {
							isItemExist = true;
							item = tracker.findById(itemID);
							System.out.println("Item was found!\nID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDescription() + " Create time:  " + new Date(item.getCreate()));
						} else if (itemID.equals("0")) {
							isItemExist = true;
						} else {
							System.out.print("Please re-enter ID or exit by entering 0: ");
							itemID = input.ask("");
						}
					} while (!isItemExist);
					break;
				case "6":
					name = input.ask("Please enter task's name for searching: ");
						allItems = tracker.findByName(name);
						if (allItems != null) {
							System.out.println("Your search includes total " + allItems.length + " Items: ");
							for (Item items : allItems) {
							System.out.println("ID: " + items.getId() + " Name: " + items.getName() + " Description: " + items.getDescription() + " Create time:  " + new Date(items.getCreate()));
							}
						} else {
							System.out.println("Your search includes no Items!");
						}
					break;
				case "0":
					System.out.println("Job4j.ru's Tracker work was ended. Thank you for using Tracker!");
					isPrintMenu = false;
					break;
				default:
					System.out.println("Sorry, but your selection is wrong!\nEnter number from 0 to 6 next time!");
					break;
			}
		} while (isPrintMenu);
	}
	/**
	 * main.
	 * @param args - аргументы.
	 */
	public static void main(String[] args) {
		//Input input = new StabInput(new String[] {"create stab task"});
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker).init();
	}
}