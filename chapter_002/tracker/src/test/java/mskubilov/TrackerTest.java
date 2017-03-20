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
		Item item1 = new Item("name1", "desc1");
		Item item2 = new Item("name2", "desc2");
		tracker.add(item1);
		tracker.add(item2);
		Item[] items = {item1, item2};
		assertThat(tracker.getAll(), is(items));

	//Проверяем корректность работы метода findById(String id)
		assertThat(tracker.findById(tracker.getAll()[1].getId()), is(items[1]));

	//Проверяем корректность работы метода update(Item)
		Item item3 = new Item("name3", "desc3");
		Item item4 = new Item("name4", "desc4");
		tracker.add(item3);
		item4.setId(tracker.getAll()[2].getId());
		tracker.update(item4);
		assertThat(tracker.getAll()[2], is(item4));

	//Проверяем корректность работы метода delete(Item)
		tracker.delete(item4);
		assertThat(tracker.getAll(), is(items));

	//Проверяем корректность работы метода findByName(String name)
		tracker.delete(item2);
		item2.setName("name1");
		tracker.add(item2);
		assertThat(tracker.findByName("name1"), is(items));
	}
}