package mskubilov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * task_03Test.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 15.03.2017
 * @version 1.0
 */
public class Task03Test {
	/**
	* Test task_03.
	*/
	@Test
	public void testTask03Test() {
		//Проверка работы конструктора из родительского класса Human
		// для дочернего класса Doctor
		Doctor doc = new Doctor('M', "John", "Snow", 8);
		assertThat(doc.getName(), is("John"));

		//Проверка метода лечения людей treat из класса Doctor
		Teacher teacher = new Teacher(20, 300, true);
		teacher.setSick(true);
		doc.treat(teacher);
		assertThat(teacher.getIsSick(), is(false));
		Engineer engineer = new Engineer(3);
		engineer.setSick(true);
		doc.treat(engineer);
		assertThat(engineer.getIsSick(), is(false));

		//Проверка метода передачи знаний teach из класса teacher
		Pupil[] pupils = new Pupil[3];
		for (int i = 0; i < 3; i++) {
			pupils[i] = new Pupil();
		}
		teacher.teach(pupils);
		assertThat(pupils[0].getTeached(), is(true));

		//Проверка метода наказания ученика учителем
		teacher.punish(pupils[1]);
		assertThat(pupils[1].getIsPunished(), is(true));
	}
}