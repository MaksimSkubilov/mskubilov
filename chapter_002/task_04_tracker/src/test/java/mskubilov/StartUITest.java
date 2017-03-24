package mskubilov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import mskubilov.models.*;
import mskubilov.start.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.containsString;

/**
 * StartUITest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.03.2017
 * @version 1.0
 */

 public class StartUITest {
	/**
	* Test of adding item.
	*/
	@Test
	public void whenAddItemThenThereIsTheItemInTracker() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"1", "name", "desc", "0"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getAll()[0].getName(), is("name"));
		assertThat(tracker.getAll()[0].getDescription(), is("desc"));
	}
	/**
	* Test of editing item.
	*/
	@Test
	public void whenEditItemThenThereIsEditedItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("name1", "desc1");
		tracker.add(item);
		String id = tracker.getAll()[0].getId();
		Input input = new StubInput(new String[] {"3", id, "1", "name", "3", id, "2", "desc", "0"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getAll()[0].getName(), is("name"));
		assertThat(tracker.getAll()[0].getDescription(), is("desc"));
	}
	/**
	* Test of deleting item.
	*/
	@Test
	public void whenDeleteItemThenThereIsDeletedItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		Item item2 = new Item("name2", "desc2");
		tracker.add(item1);
		tracker.add(item2);
		Item[] items = {item2};
		String id = tracker.getAll()[0].getId();
		Input input = new StubInput(new String[] {"4", id, "0"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getAll(), is(items));
	}

//Для корректного тестирования работы пунктов меню 2, 5 и 6 нужно анализировать информацию, которая выводится на экран.

	/**
	* Test of showing all items.
	*/
	@Test
	public void whenShowAllItemsThenThereAreAllTheItems() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		Item item2 = new Item("name2", "desc2");
		tracker.add(item1);
		tracker.add(item2);
		Input input = new StubInput(new String[] {"2", "0"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("Tracker includes total "));
	}
	/**
	* Test of searching item by id.
	*/
	@Test
	public void whenSearchingItemByIDThenThereIsRigthItem() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		Item item2 = new Item("name2", "desc2");
		tracker.add(item1);
		tracker.add(item2);
		String id = tracker.getAll()[0].getId();
		Input input = new StubInput(new String[] {"5", id, "0"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("Item was found!"));
	}
	/**
	* Test of searching item by name.
	*/
	@Test
	public void whenSearchingItemByNameThenThereIsRigthItem() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		Item item2 = new Item("name2", "desc2");
		tracker.add(item1);
		tracker.add(item2);
		Input input = new StubInput(new String[] {"6", "name1", "0"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("Your search includes total "));
	}

//Протестируем вывод информационных сообщений пользователю.

	/**
	* Test of notification.
	*/
	@Test
	public void whenUserInputWrongThenThereIsMessage() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		Item item2 = new Item("name2", "desc2");
		tracker.add(item1);
		tracker.add(item2);
		String id = tracker.getAll()[0].getId();
		Input input = new StubInput(new String[] {"3", "625312562312", id, "4", "0", "0"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("Please re-enter ID or exit by entering 0: "));
		assertThat(out.toString(), containsString("Sorry, but your selection is wrong!"));
	}
 }