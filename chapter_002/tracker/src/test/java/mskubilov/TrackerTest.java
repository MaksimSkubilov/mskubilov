package mskubilov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import mskubilov.models.*;
import mskubilov.start.*;

import java.util.ArrayList;

/**
 * TrackerTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 07.04.2017
 * @version 2.0
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
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		assertThat(tracker.getAll(), is(items));

	//Проверяем корректность работы метода findById(String id)
		assertThat(tracker.findById(tracker.getAll().get(1).getId()), is(items.get(1)));

	//Проверяем корректность работы метода addComment(String comment, String id)
	//и метода getComments(Item itm)
		tracker.addComment("comment", tracker.getAll().get(0).getId());
		assertThat(tracker.getComments(item1), is(item1.getComments()));

	//Проверяем корректность работы метода update(Item)
		Item item3 = new Item("name3", "desc3");
		Item item4 = new Item("name4", "desc4");
		tracker.add(item3);
		item4.setId(tracker.getAll().get(2).getId());
		tracker.update(item4);
		assertThat(tracker.getAll().get(2), is(item4));

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