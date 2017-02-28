package ru.job4j;

/**
 * ArrayAdd. Сложение двух отсортированных массивов в один отсортированный массив.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.02.2017
 * @version 1.0
 */

 public class ArrayAdd {
	/**
	 * add. Выполняет сложение двух массивов целых чисел в один.
	 * @param values1 - первый отсортированный по возрастанию массив целых чисел.
	 * @param values2 - второй отсортированный по возрастанию массив целых чисел.
	 * @return - возвращает отсортированный массив, образованный сложением массивов values1 и values2.
	 */
	public int[] add(int[] values1, int[] values2) {
		int length1 = values1.length;
		int length2 = values2.length;
		int length = length1 + length2;
		int[] add = new int[length];
			int k = 0;
			int i = 0;
			int j = 0;
				while (j < length) {
					if (i < length1 && k < length2 && values1[i] > values2[k]) {
						add[j] = values2[k];
						k++;
						j++;
					} else if (i < length1) {
						add[j] = values1[i];
						i++;
						j++;
					} else {
						add[j] = values2[k];
						k++;
						j++;
					}
				}
		return add;
	}
}