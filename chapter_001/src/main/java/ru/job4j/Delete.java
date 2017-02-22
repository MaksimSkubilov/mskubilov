package ru.job4j;
import java.util.Arrays;

/**
 * Delete. Удаляет дубликаты из массива.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 22.02.2017
 * @version 1.0
 */

 public class Delete {
	/**
	 * dublicate. Удаляет дубликаты из массива строк.
	 * @param args - массив строк.
	 * @return - возвращает очищенный от дублей массив.
	 */
	public String[] dublicate(String[] args) {
		int lngth = 0;
		for (int i = 0; i < args.length - lngth; i++) {
			for (int j = i + 1; j < args.length - lngth; j++) {
				if (args[i] == args[j]) {
					for (int k = j; k < args.length - 1 - lngth; k++) {
					String tmp = args[k];
					args[k] = args[k + 1];
					args[k + 1] = tmp;
					}
				lngth = lngth + 1;
				j--;
				}
			}
		}
		String[] values = new String[args.length - lngth];
		values = Arrays.copyOf(args, (args.length - lngth));
		return values;
	}
}