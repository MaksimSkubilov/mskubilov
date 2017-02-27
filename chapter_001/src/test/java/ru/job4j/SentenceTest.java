package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SentenceTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 27.02.2017
 * @version 1.0
 */
public class SentenceTest {
	/**
	* Test IsStringContainsSubStringFalse. - проверка вхождения подстроки в строку.
	*/
	@Test
	public void testIsStringContainsSubStringFalse() {
		Sentence sentence = new Sentence();
		assertThat(sentence.contains("abc abd adc acc dcb bbb", "aaa"), is(false));
	}
	/**
	* Test IsStringContainsSubStringTrue. - проверка вхождения подстроки в строку.
	*/
	@Test
	public void testIsStringContainsSubStringTrue() {
		Sentence sentence = new Sentence();
		assertThat(sentence.contains("abc abd adc acc dcb bbb", "bbb"), is(true));
	}
}