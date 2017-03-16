package mskubilov;

/**
 * Human. Родительский класс для всех людей.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 15.03.2017
 * @version 1.0
 */

public class Human {
	/**
	 * Пол. (M or F)
	 */
	private char sex;
	/**
	 * Имя.
	 */
	private String name;
	/**
	 * Фамилия.
	 */
	private String surname;
	/**
	 * Возраст.
	 */
	private int age;
	/**
	 * Чувство голода.
	 */
	private boolean isHungry;
	/**
	 * Болеет или нет.
	 */
	private boolean isSick;

// Конструкторы класса

	/**
	 * Human. Дефолтный конструктор класса Human.
	 */
	public Human() {
	}
	/**
	* Human. Конструктор класса Human.
	* @param sex - пол.
	* @param name - имя.
	* @param surname - фамилия.
	* @param age - возраст.
	*/
	public Human(char sex, String name, String surname, int age) {
		this.sex = sex;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

// Методы класса

	/**
	 * eat. Метод для приема пищи.
	 * @param food - еда.
	 */
	public void eat(Food food) {
		this.isHungry = false;
	}
	/**
	 * sleep. Метод для сна.
	 */
	public void sleep() {
	}

// Геттеры и сеттеры для полей состояния

	/**
	 * setSex. Метод для установки пола.
	 * @param sex - пол.
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	/**
	 * setName. Метод для установки имени.
	 * @param name - имя.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * setSurname. Метод для установки фамилии.
	 * @param surname - фамилия.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * setAge. Метод для установки возраста.
	 * @param age - возраст.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * setHungry. Метод для установки чувства голода.
	 * @param isHungry - чувство голода.
	 */
	public void setHungry(boolean isHungry) {
		this.isHungry = true;
	}
	/**
	 * setSick. Метод для установки самочувствия.
	 * @param isSick - самочувствие.
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	/**
	 * getName. Возвращает имя.
	 * @return имя
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * getSurname. Возвращает фамилию.
	 * @return фамилия
	 */
	public String getSurname() {
		return this.surname;
	}
	/**
	 * getSex. Возвращает пол.
	 * @return пол
	 */
	public char getSex() {
		return this.sex;
	}
	/**
	 * getAge. Возвращает возраст.
	 * @return возраст
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * getIsHungry. Возвращает чувство голода.
	 * @return чувство голода
	 */
	public boolean getIsHungry() {
		return this.isHungry;
	}
	/**
	 * getIsSick. Возвращает самочувствие.
	 * @return самочувствие.
	 */
	public boolean getIsSick() {
		return this.isSick;
	}
}
