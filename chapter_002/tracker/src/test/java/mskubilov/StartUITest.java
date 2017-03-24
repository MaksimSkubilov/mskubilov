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
 * @since 24.03.2017
 * @version 2.0
 */

 public class StartUITest {
	/**
	* Test of adding item.
	*/
	@Test
	public void whenAddItemThenThereIsTheItemInTracker() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"0", "task", "name", "desc", "8"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getAll()[0].getName(), is("name"));
		assertThat(tracker.getAll()[0].getDescription(), is("desc"));
	}
	/**
	* Test of editing item.
	*/
	@Test
	public void whenEditItemThenThereIsEditedItemWithOldComments() {
		Tracker tracker = new Tracker();
		Item item = new Item("name1", "desc1");
		item.addComment("comment");
		tracker.add(item);
		String id = tracker.getAll()[0].getId();
		Input input = new StubInput(new String[] {"2", id, "task", "name", "desc", "8"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getAll()[0].getName(), is("name"));
		assertThat(tracker.getAll()[0].getDescription(), is("desc"));
		assertThat(tracker.getAll()[0].getComments().get(0), is("comment"));
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
		Input input = new StubInput(new String[] {"3", id, "8"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getAll(), is(items));
	}
	/**
	* Test of adding comment in item.
	*/
	@Test
	public void whenAddCommentInItemThenThereIsRigthComment() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		tracker.add(item1);
		String id = tracker.getAll()[0].getId();
		Input input = new StubInput(new String[] {"6", id, "comment", "8"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getAll()[0].getComments().get(0), is("comment"));
	}

//Для корректного тестирования работы пунктов меню 1, 4, 5, 7 нужно анализировать информацию, которая выводится на экран.

	/**
	* Test of showing all items.
	*/
	@Test
	public void whenShowAllItemsThenThereAreAllTheItems() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		tracker.add(item1);
		Input input = new StubInput(new String[] {"1", "8"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("name1"));
		assertThat(out.toString(), containsString("true")); //test for empty comments
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
		String id = tracker.getAll()[1].getId();
		Input input = new StubInput(new String[] {"4", id, "8"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("name2"));
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
		Input input = new StubInput(new String[] {"5", "name1", "8"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("name1"));
	}
	/**
	* Test of getting comments of item.
	*/
	@Test
	public void whenGetCommentsOfItemThenThereIsRigthComments() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Tracker tracker = new Tracker();
		Item item1 = new Item("name1", "desc1");
		item1.addComment("comment1");
		item1.addComment("comment2");
		tracker.add(item1);
		String id = tracker.getAll()[0].getId();
		Input input = new StubInput(new String[] {"7", id, "8"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("comment1"));
		assertThat(out.toString(), containsString("comment2"));
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
		tracker.add(item1);
		Input input = new StubInput(new String[] {"4", "625312562312", "5", "fgfhhf", "6", "377467632", "8"});
		new StartUI(input, tracker).init();
		assertThat(out.toString(), containsString("There is no item of this ID in tracker!"));
		assertThat(out.toString(), containsString("There are no items of this name in tracker!"));
		assertThat(out.toString(), containsString("There is no item of ID entered in tracker!"));
	}
 }