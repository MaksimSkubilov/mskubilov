package mskubilov;

/**
 * Engineer. Дочерний класс от Profession.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 15.03.2017
 * @version 1.0
 */

public class Engineer extends Profession {
	/**
	 * Грэйд.
	 */
	private int grade;

// Конструкторы класса

	/**
	 * Engineer. Конструктор с установкой грейда.
	 * @param grade - предмет.
	 */
	public Engineer(int grade) {
		this.grade = grade;
	}
		/**
	 * Engineer. Вызов конструктора из класса Profession.
	 * @param exp - стаж.
	 * @param salary - оклад.
	 * @param isDiploma - наличие диплома об образовании.
	 */
	public Engineer(int exp, int salary, boolean isDiploma) {
		super(exp, salary, isDiploma);
	}
	/**
	 * Engineer. Вызов конструктора из класса Human.
	 * @param sex - пол.
	 * @param name - имя.
	 * @param surname - фамилия.
	 * @param age - возраст.
	 */
	public Engineer(char sex, String name, String surname, int age) {
		super(sex, name, surname, age);
	}

// Методы класса

	/**
	 * calculate. Сложить два числа.
	 * @return  Возвращает результат вычисления.
	 * @param a - первое число.
	 * @param b - второе число.
	 */
	public int calculate(int a, int b) {
		return a + b;
	}
	/**
	 * fix. Проводить ремонт.
	 */
	public void fix() {
	}

// Геттеры и сеттеры для полей состояния

	/**
	 * setGrade. Установка грейда.
	 * @param grade - грейд.
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 * getGrade. Возвращает грейд.
	 * @return grade. Возвращает грейд.
	 */
	public int getGrade() {
		return this.grade;
	}
}
