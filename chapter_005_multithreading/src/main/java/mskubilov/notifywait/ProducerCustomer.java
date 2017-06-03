package mskubilov.notifywait;

import java.util.LinkedList;
import java.util.Queue;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 03.06.17
 */
public class ProducerCustomer {

    /**
     * Queue of products.
     */
    private final Queue<Integer> productList = new LinkedList<>();

    /**
     * isLocked boolean variable. Locks customer and producer.
     */
    private boolean isLocked = true;

    /**
     * Customer method polls product from queue.
     */
    private void buyProduct() {
        synchronized (this) {
            while (isLocked) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
            System.out.printf("%s Customer gets product number %s\n", Thread.currentThread().getName(), productList.poll());
            notify();
        }
    }

    /**
     * Producer method, puts new product in queue.
     * @param productNumber product number by order.
     */
    private void produceProduct(int productNumber) {
        synchronized (this) {
            while (!isLocked) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            productList.add(productNumber);
            System.out.printf("%s Producer puts product number %s\n", Thread.currentThread().getName(), productNumber);
            isLocked = false;
            notify();
        }
    }

    /**
     * Customer Thread.
     * @return customer thread.
     */
    public Thread getCustomerThread() {
        return new Thread() {
            public void run() {
                for (int i = 1; i < 5; i++) {
                    buyProduct();
                }
            }
        };
    }

    /**
     * Producer Thread.
     * @return producer thread.
     */
    public Thread getProducerThread() {
        return new Thread() {
            public void run() {
                for (int i = 1; i < 5; i++) {
                    produceProduct(i);
                }
            }
        };
    }
}
