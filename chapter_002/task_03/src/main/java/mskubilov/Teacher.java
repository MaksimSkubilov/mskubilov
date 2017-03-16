package mskubilov;

/**
 * Teacher. Дочерний класс от Profession.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 15.03.2017
 * @version 1.0
 */

public class Teacher extends Profession {
	/**
	 * Предмет.
	 */
	private String discipline;

// Конструкторы класса

	/**
	* Teacher. Конструктор с установкой дисциплины.
	* @param discipline - предмет.
	*/
	public Teacher(String discipline) {
		this.discipline = discipline;
	}
	/**
	* Teacher. Вызов конструктора из класса Profession.
	* @param exp - стаж.
	* @param salary - оклад.
	* @param isDiploma - наличие диплома об образовании.
	*/
	public Teacher(int exp, int salary, boolean isDiploma) {
		super(exp, salary, isDiploma);
	}
	/**
	* Teacher. Вызов конструктора из класса Human.
	* @param sex - пол.
	* @param name - имя.
	* @param surname - фамилия.
	* @param age - возраст.
	*/
	public Teacher(char sex, String name, String surname, int age) {
		super(sex, name, surname, age);
	}

// Методы класса

	/**
	 * teach. Учить учеников.
	 * @param pupils - ученики.
	 */
	public void teach(Pupil[] pupils) {
		for (Pupil pupil : pupils) {
			pupil.setTeached();
		}
	}
	/**
	 * punish. Наказать ученика.
 	 * @param pupil - ученик.
	 */
	public void punish(Pupil pupil) {
		pupil.setPunished();
	}
	/**
	 * chekHmwrk. Проверить домашнее задание.
 	 * @param pupil - ученик.
	 */
	public void chekHmwrk(Pupil pupil) {
	}

// Геттеры и сеттеры для полей состояния

	/**
	 * setDiscipline. Установить предмет.
	 * @param discipline - предмет.
	 */
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	/**
	 * getDiscipline. Возвращает предмет.
	 * @return discipline. Возвращает предмет.
	 */
	public String getDiscipline() {
		return this.discipline;
	}
}
