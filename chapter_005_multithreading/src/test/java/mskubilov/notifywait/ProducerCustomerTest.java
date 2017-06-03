package mskubilov.notifywait;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 03.06.17
 */
public class ProducerCustomerTest {

    /**
     * Pseudo test showing blocking queue from producer thread to customer thread with wait/notify synchronization.
     * @throws InterruptedException exception.
     */
    @Test
    public void testProducerCustomer() throws InterruptedException {
        ProducerCustomer pc = new ProducerCustomer();
        Thread customer = pc.getCustomerThread();
        Thread producer = pc.getProducerThread();
        customer.start();
        producer.start();
        customer.join();
        producer.join();

    }
}