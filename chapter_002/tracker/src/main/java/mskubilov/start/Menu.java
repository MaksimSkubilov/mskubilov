package mskubilov.start;

/**
 * Menu. Меню программы.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.03.2017
 * @version 1.0
 */

public class Menu {
	/**
	* printMainMenu. Метод для отображения основного меню.
	*/
	public void printMainMenu() {
		System.out.println();
		System.out.println("1. Add new Item");
		System.out.println("2. Show all Items");
		System.out.println("3. Edit Item");
		System.out.println("4. Delete Item");
		System.out.println("5. Find Item by Id");
		System.out.println("6. Find Items by name");
		System.out.println("0. Exit Program");
	}
	/**
	* printSubMenu. Метод для отображения подменю.
	*/
	public void printSubMenu() {
		System.out.println();
		System.out.println("1. Edit Item's Name");
		System.out.println("2. Edit Item's Description");
		System.out.println("0. Exit Program");
	}
}