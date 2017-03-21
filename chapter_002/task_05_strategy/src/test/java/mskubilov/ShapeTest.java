package mskubilov;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.containsString;

/**
 * ShapeTest.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 17.03.2017
 * @version 1.0
 */

public class ShapeTest {
	/**
	* Test Triangle.
	*/
	@Test
	public void testTriangle() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Shape triangle = new Triangle();
		String pic = triangle.pic();
		new Paint().draw(triangle);
		assertThat(out.toString(), containsString(pic));
	}
	/**
	* Test Quadrate.
	*/
	@Test
	public void testQuadrate() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Shape quadrate = new Quadrate();
		String pic = quadrate.pic();
		new Paint().draw(quadrate);
		assertThat(out.toString(), containsString(pic));
	}
}