package mskubilov.start;

/**
 * ValidateInput. Запрос ввода данных у пользователя, реализует интерфейс Input, расширяет ConsileInput.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 25.03.2017
 * @version 1.0
 */

public class ValidateInput extends ConsoleInput {
	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ключ.
	 */

	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe)  {
				System.out.println("Please enter the key from menu!");
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter validate data again!");
			}
		} while (invalid);
		return value;
	}

	/**
	 * ask. Метод, реализующий взаимодействие объекта с трекером.
	 * @param question - вопрос.
	 * @param range - диапазон разрешенных значений.
	 * @return ключ.
	 */

	 public String ask(String question, String[] range) {
		boolean invalid = true;
		String type = "Item";
		do {
			try {
				type = super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe)  {
				System.out.println("Data you entered is not valid or not found! or type 'exit' to exit");
			}
		} while (invalid);
		return type;
	}
}