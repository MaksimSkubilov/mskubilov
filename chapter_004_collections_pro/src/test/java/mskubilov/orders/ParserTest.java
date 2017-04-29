package mskubilov.orders;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.04.17
 */
public class ParserTest {
    /**
     * test of parsing Orders file by StAx solution. Result > 6 seconds. FAILED.
     * @throws Exception FileNotFoundException, XMLStreamException.
     */
    @Test
    public void parseStAX() throws Exception {
        long time = System.currentTimeMillis();
        ParserStAX parser = new ParserStAX();
        parser.parse("d:/java/orders.xml");
        time = System.currentTimeMillis() - time;
        boolean result = time < 6000;
        assertThat(result, is(false));
    }

    /**
     * test of parsing Orders file by parsing String lines ONLINE MODE.
     * @throws Exception FileNotFoundException.
     */
    @Test
    public void parseAndFillOnline() throws Exception {
        long time = System.currentTimeMillis();
        Parser parser = new Parser();
        parser.parse("d:/java/orders.xml");
        parser.print();
        time = System.currentTimeMillis() - time;
        boolean result = time < 6000;
        assertThat(result, is(true));
    }

    /**
     * test of parsing Orders file by parsing String lines. First parsing ONLINE like previous test (because of my lazy ass),
     after fill ask & bid trees with ALL ORDERS parsed from file and check them next.
     * @throws Exception FileNotFoundException.
     */
    @Test
    public void parseAndFill() throws Exception {
        long time = System.currentTimeMillis();
        Parser parser = new Parser();
        parser.parse("d:/java/orders.xml");
        parser.fillBooksTrees();
        parser.print();
        time = System.currentTimeMillis() - time;
        boolean result = time < 6000;
        assertThat(result, is(true));
    }


}