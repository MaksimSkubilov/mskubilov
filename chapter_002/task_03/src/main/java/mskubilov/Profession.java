package mskubilov;

/**
 * Profession. Дочерний абстрактный класс от Human с общими для всех профессий параметрами и методами.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 15.03.2017
 * @version 1.0
 */

public abstract class Profession extends Human {
	/**
	 * Стаж, полных лет.
	 */
	private int exp;
	/**
	 * Оклад, долл.
	 */
	private double salary;
	/**
	 * Наличие диплома.
	 */
	private boolean isDiploma;

// Конструкторы класса

	/**
	* Profession. Дефолтный конструктор класса Profession.
	*/
	public Profession() {
	}
	/**
	* Profession. Конструктор класса Profession.
	* @param sex - пол.
	* @param name - имя.
	* @param surname - фамилия.
	* @param age - возраст.
	*/
	public Profession(char sex, String name, String surname, int age) {
		super(sex, name, surname, age);
	}
	/**
	* Profession. Конструктор класса Profession.
	* @param exp - стаж.
	* @param salary - оклад.
	* @param isDiploma - наличие диплома об образовании.
	*/
	public Profession(int exp, double salary, boolean isDiploma) {
		this.exp = exp;
		this.salary = salary;
		this.isDiploma = isDiploma;
	}


// Методы класса

	/**
	 * goToWork. Пойти на работу.
	 */
	public void goToWork() {
	}


// Геттеры и сеттеры для полей состояния

	/**
	 * setExp. Метод для установки стажа.
	 * @param exp - стаж.
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}
	/**
	 * setSalary. Метод для установки оклада.
	 * @param salary - оклад.
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * setIsDiploma. Метод для установки наличия диплома об образовании.
	 * @param isDiploma - наличие диплома об образовании.
	 */
	public void setIsDiploma(boolean isDiploma) {
		this.isDiploma = isDiploma;
	}
	/**
	 * getExp. Возвращает стаж.
	 * @return стаж.
	 */
	public int getExp() {
		return this.exp;
	}
	/**
	 * getSalary. Возвращает размер оклада.
	 * @return оклад.
	 */
	public double getSalary() {
		return this.salary;
	}
	/**
	 * getIsDiploma. Возвращает информацию о наличии диплома.
	 * @return диплом.
	 */
	public boolean getIsDiploma() {
		return this.isDiploma;
	}
}
