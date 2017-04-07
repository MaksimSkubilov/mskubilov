package mskubilov;

/**
 * Paint. Класс для отображения формы.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.03.2017
 * @version 1.0
 */
public class Paint {
	/**
	 * draw. отображает форму.
	 * @param shape - передаваемая в объект форма.
	 */
	public void draw(Shape shape) {
		System.out.println(shape.pic());
	}
}