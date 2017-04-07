package mskubilov;

/**
 * Pupil. Дочерний класс от Human.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 15.03.2017
 * @version 1.0
 */

public class Pupil extends Human {
	/**
	 * В каком классе учится ученик (A, B, C, D).
	 */
	private char group;
	/**
	 * Степень знаний.
	 */
	private boolean isTeached;
	/**
	 * Степень наказания.
	 */
	private boolean isPunished;

// Конструкторы класса

	/**
	 * Pupil. Конструктор по умолчанию.
	 */
	public Pupil() {
		this.group = 'A';
	}
	/**
	 * Pupil. Вызов конструктора из класса Human.
	 * @param sex - пол.
	 * @param name - имя.
	 * @param surname - фамилия.
	 * @param age - возраст.
	 */
	public Pupil(char sex, String name, String surname, int age) {
		super(sex, name, surname, age);
	}

// Геттеры и сеттеры для полей состояния

	/**
	 * setTeached. Получить знания.
	 */
	public void setTeached() {
		this.isTeached = true;
	}
	/**
	 * setPunished. Получить наказание.
	 */
	public void setPunished() {
		this.isPunished = true;
	}
	/**
	 * getTeached. Возвращает информацию о знаниях ученика.
	 * @return знает или нет.
	 */
	public boolean getTeached() {
		return this.isTeached;
	}
	/**
	 * getIsPunished. Возвращает информацию о постигшей каре.
	 * @return наказан ли ученик.
	 */
	public boolean getIsPunished() {
		return this.isPunished;
	}
}
