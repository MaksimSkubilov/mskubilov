package mskubilov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 13.04.17
 */
public class TestBank {
    /**
     * testBank.
     */
    @Test
    public void testBank() {
        Bank bank = new Bank();
        bank.setCalendar();
        Visitor[] visitors = new Visitor[4];
        long time = System.currentTimeMillis();
        long delta = 1000 * 3600;
        visitors[0] = new Visitor(time + delta / 2, time + delta * 2);
        visitors[1] = new Visitor(time + delta, time + delta * 2);
        visitors[2] = new Visitor(time + delta * 2, time + delta * 4);
        visitors[3] = new Visitor(time + delta * 3, time + delta * 5);
        bank.fillVisitors(visitors);
        int amount = bank.maxVisitorsAmount();
        bank.printVisitors(amount);
        bank.printVisitors();
        assertThat(amount, is(2));
        bank.fillVisitors();
        bank.printVisitors(bank.maxVisitorsAmount());
    }


}
