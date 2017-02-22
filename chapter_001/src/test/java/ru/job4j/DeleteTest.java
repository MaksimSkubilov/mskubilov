package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DeleteTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.02.2017
 * @version 1.0
 */
public class DeleteTest {
	/**
	* Test IsDelete. - проверка удаления дубликатов.
	*/
	@Test
	public void testIsDelete() {
		String[] in = {"метод", "метод", "тыка", "метод", "тыка", "тыка", "рулит", "метод"};
		String[] out = {"метод", "тыка", "рулит"};
		Delete delete = new Delete();
		assertThat(delete.dublicate(in), is(out));
	}
}