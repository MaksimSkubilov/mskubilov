package mskubilov;

/**
 * Triangle. Треугольник интерфейса Shape.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 21.03.2017
 * @version 1.0
 */
public class Triangle implements Shape {
	/**
	 * pic. Переопределнный метод формы.
	 * @return строку формы.
	 */
	public String pic() {
		return "  #\n ###\n#####\n";
	}
}