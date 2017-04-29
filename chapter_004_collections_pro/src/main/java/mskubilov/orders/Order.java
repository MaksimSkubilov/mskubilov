package mskubilov.orders;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.04.17
 */

/**
 * Order of buying or selling stocks.
 */
public class Order {

    /**
     * True if Order for buying stocks, false otherwise.
     */
    private boolean buyOrSell;

    /**
     * Price of stock.
     */
    private double price;

    /**
     * Order's ID.
     */
    private int orderId;

    /**
     * Quantity of stocks.
     */
    private int volume;

    /**
     * Make new Order.
     * @param price price of stock.
     * @param volume quantity of stocks.
     * @param orderId Order's ID.
     * @param buy true if Order for buying stocks, false otherwise.
     */
    public Order(double price, int volume, int orderId, boolean buy) {
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
        this.buyOrSell = buy;
    }

    /**
     * @return true if Order for buying stocks, false otherwise.
     */
    public boolean getBuy() {
        return this.buyOrSell;
    }

    /**
     * @return price from Order.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @return Order's ID.
     */
    public int getId() {
        return this.orderId;
    }

    /**
     * @return quantity of stocks from Order.
     */
    public int getVolume() {
        return this.volume;
    }
}
