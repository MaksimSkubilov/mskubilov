package mskubilov;

/**
 * Doctor. Дочерний класс от Profession.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 15.03.2017
 * @version 1.0
 */

public class Doctor extends Profession {
	/**
	 * Ученая степень.
	 */
	private String degree;
	/**
	 * Сфера деятельности.
	 */
	private String sphere;

// Конструкторы класса

	/**
	* Doctor. Вызов конструктора из класса Human.
	* @param sex - пол.
	* @param name - имя.
	* @param surname - фамилия.
	* @param age - возраст.
	*/
	public Doctor(char sex, String name, String surname, int age) {
		super(sex, name, surname, age);
	}
	/**
	* Doctor. Вызов конструктора из класса Profession.
	* @param exp - стаж.
	* @param salary - оклад.
	* @param isDiploma - наличие диплома об образовании.
	*/
	public Doctor(int exp, int salary, boolean isDiploma) {
		super(exp, salary, isDiploma);
	}
	/**
	* Doctor. Конструктор класса Doctor.
	* @param sphere - направление деятельности.
	*/
	public Doctor(String sphere) {
		this.sphere = sphere;
	}

// Методы класса

	/**
	 * treat. Проводить лечение.
	 * @param human - человек.
	 */
	public void treat(Human human) {
		if (human.getIsSick()) {
			human.setSick(false);
		}
	}
	/**
	 * onWatch. Выходить на смену.
	 */
	public void onWatch() {
	}

// Геттеры и сеттеры для полей состояния

	/**
	 * setDegree. Установить ученую степень.
	 * @param degree - ученая степень.
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * setSphere. Установить ученую степень.
	 * @param sphere - ученая степень.
	 */
	public void setSphere(String sphere) {
		this.sphere = sphere;
	}
	/**
	 * getDegree. Возвращает ученую степень.
	 * @return degree - ученая степень.
	 */
	public String getDegree() {
		return this.degree;
	}
	/**
	 * getSphere. Возвращает направление деятельности.
	 * @return sphere - направление деятельности.
	 */
	public String getSphere() {
		return this.sphere;
	}
}
