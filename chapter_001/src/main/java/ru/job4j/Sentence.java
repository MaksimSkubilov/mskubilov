package ru.job4j;

/**
 * Sentence.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 27.02.2017
 * @version 1.0
 */

 public class Sentence {
	/**
	 * contains. Возвращает результат проверки вхождения подстроки в строку.
	 * @param origin - предложение или строка символов.
	 * @param sub - предложение или строка символов, входящее или не входящее в origin.
	 * @return - возвращает результат проверки в булевой форме.
	 */
	public boolean contains(String origin, String sub) {
		char[] origins = origin.toCharArray();
		char[] subs = sub.toCharArray();
		boolean result = false;
		for (int i = 0; i < origin.length() - sub.length() + 1; i++) {
				if (origins[i] == subs[0]) {
					int count = 0;
						for (int j = 1; j < sub.length(); j++) {
							if (origins[i + 1] == subs[j]) {
								i++;
								count = j;
							}
						}
					if (count == sub.length() - 1) {
						result = true;
					}
				}
			}
		return result;
	}
}
