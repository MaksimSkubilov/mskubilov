package mskubilov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import mskubilov.models.*;
import mskubilov.start.*;

/**
 * TrackerTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.0
 */
public class TrackerTest {
	/**
	* Test Tracker.
	*/
	@Test
	public void testTrackerTest() {

	//Проверяем корректность работы метода add(Item) и getAll()
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1", 1);
		Item item2 = new Item("name2", "desc2", 2);
		tracker.add(item1);
		tracker.add(item2);
		Item[] items = {item1, item2};
		assertThat(tracker.getAll(), is(items));

	//Проверяем корректность работы метода findById(String id) с помощью созданного
	//в классе Tracker метода findIdByName(String name) для получения сгенерированного уникального
	//id заявки
		String idForTest = tracker.getIdByName("name2");
		assertThat(tracker.findById(idForTest), is(items[1]));

	//Проверяем корректность работы метода update(Item)
		Item item3 = new Item("name3", "desc3", 3);
		Item item4 = new Item("name4", "desc4", 4);
		tracker.add(item3);
		idForTest = tracker.getIdByName("name3");
		item4.setId(idForTest);
		tracker.update(item4);
		assertThat(tracker.findById(idForTest), is(item4));

	//Проверяем корректность работы метода delete(Item)
		tracker.delete(idForTest);
		assertThat(tracker.getAll(), is(items));

	//Проверяем корректность работы метода findByName(String name)
		assertThat(tracker.findByName("name1"), is(items[0]));
	}
}