package ru.job4j;

/**
 * Paint.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 20.02.2017
 * @version 1.0
 */

 public class Paint {
	/**
	 * piramid. Сравнение.
	 * @param h - высота пирамиды, строк.
	 * @return - возвращает пирамиду в виде строки.
	 */
	public String piramid(int h) {
		StringBuilder pmd = new StringBuilder();
			for (int i = 0; i < h; i++) {
				for (int j = 1; j < h - i; j++) {
					pmd.append(" ");
				}
				pmd.append("^");
				for (int k = 0; k < i; k++) {
					pmd.append(" ^");
				}
				pmd.append("\n");
			}
		return pmd.toString();
		}
}