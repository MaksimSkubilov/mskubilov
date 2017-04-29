package mskubilov.orders;

import java.util.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.04.17
 */

/**
 * Book of Orders.
 */
public class Book {

    /**
     * ID of Order Book.
     */
    private final String bookId;

    /**
     * HashMap of all incoming buy and sell orders. Key - bookId.
     */
    private HashMap<Integer, Order> allOrders;

    /**
     * TreeMap of all current sell orders (asks).
     */
    private TreeMap<Double, Integer> allAsks;

    /**
     * TreeMap of all current buy orders (bids).
     */
    private TreeMap<Double, Integer> allBids;

    /**
     * Make new Book.
     * @param bookId - ID of Order Book.
     */
    public Book(String bookId) {
        this.bookId = bookId;
        this.allOrders = new HashMap<Integer, Order>(1000000);
        this.allBids = new TreeMap<Double, Integer>(Comparator.reverseOrder());
        this.allAsks = new TreeMap<Double, Integer>(Comparator.naturalOrder());
    }

    /** Methods of online solution.
         1. Parse file line by line and buy or sell volumes from incoming orders,
     or remove volumes of prices, making changes when filling ask & bid trees ONLINE.
         2. Print result.
     */

    /**
     * Add new Order.
     * @param order - Order to add.
     */
    public void addOrder(Order order) {
        this.allOrders.put(order.getId(), order);
        if (order.getBuy()) {
            checkVolumeIfBuy(order, this.allBids, this.allAsks);
        } else {
            checkVolumeIfSell(order, this.allBids, this.allAsks);
        }
    }

    /**
     * Remove existing order.
     * @param id - Order's ID.
     */
    public void removeOrder(int id) {
        Order order = this.allOrders.get(id);
        double price = order.getPrice();
        int volume = order.getVolume();
        if (order.getBuy()) {
            if (this.allBids.get(price) != null) {
                volume = this.allBids.get(price) - volume;
                if (volume <= 0) {
                    this.allBids.remove(price);
                } else {
                    this.allBids.put(price, volume);
                }
            } else {
                //System.out.println("bids " + id);
            }
        } else {
            if (this.allAsks.get(price) != null) {
                volume = this.allAsks.get(price) - volume;
                if (volume <= 0) {
                    this.allAsks.remove(price);
                } else {
                    this.allAsks.put(price, volume);
                }
            } else {
                //System.out.println("asks " + id);
            }

        }
        this.allOrders.remove(id);
    }

    /**
     * Check every coming BUY Order for available quantity of SELL volumes by lover or same price.
     * @param order incoming order.
     * @param bids tree of bids.
     * @param asks tree of asks.
     */
    public void checkVolumeIfBuy(Order order, TreeMap<Double, Integer> bids, TreeMap<Double, Integer> asks) {
        Double bidPrice = order.getPrice();
        if (asks.isEmpty() || asks.firstKey() > bidPrice) {
            int volume = 0;
            if (bids.containsKey(bidPrice)) {
                volume = bids.get(bidPrice);
            }
            bids.put(bidPrice, order.getVolume() + volume);
        } else {
            Double topAsk = asks.firstKey();
            if (topAsk <= bidPrice) {
                Iterator<Double> it = asks.keySet().iterator();
                Integer askCount = asks.get(topAsk);
                Integer bidCount = order.getVolume();
                it.next();
                while (it.hasNext() && topAsk <= bidPrice) {
                    if (askCount > bidCount) {
                        asks.put(topAsk, askCount - bidCount);
                        break;
                    } else if (askCount < bidCount) {
                        asks.remove(topAsk);
                        it = asks.keySet().iterator();
                        topAsk = it.next();
                        bidCount = bidCount - askCount;
                        askCount = asks.get(topAsk);
                    } else {
                        asks.remove(topAsk);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Check every coming SELL Order for available quantity of BUY volumes by higher or same price.
     * @param order incoming order.
     * @param bids tree of bids.
     * @param asks tree of asks.
     */
    public void checkVolumeIfSell(Order order, TreeMap<Double, Integer> bids, TreeMap<Double, Integer> asks) {
        Double sellPrice = order.getPrice();
        if (bids.isEmpty() || bids.firstKey() < sellPrice) {
            int volume = 0;
            if (asks.containsKey(sellPrice)) {
                volume = asks.get(sellPrice);
            }
            asks.put(sellPrice, order.getVolume() + volume);
        } else {
            Double topBid = bids.firstKey();
            if (topBid >= sellPrice) {
                Iterator<Double> it = bids.keySet().iterator();
                Integer bidCount = bids.get(topBid);
                Integer askCount = order.getVolume();
                it.next();
                while (it.hasNext() && topBid >= sellPrice) {
                    if (askCount > bidCount) {
                        bids.remove(topBid);
                        it = bids.keySet().iterator();
                        topBid = it.next();
                        askCount = askCount - bidCount;
                        bidCount = bids.get(topBid);
                    } else if (askCount < bidCount) {
                        bids.put(topBid, bidCount - askCount);
                        break;
                    } else {
                        bids.remove(topBid);
                        break;
                    }
                }
            }
        }
    }

    public void print() {
        System.out.printf("%s%n", bookId);
        System.out.printf("%-8s %s %10s%n", "BUY", "PRICE", "SELL");
        for (Map.Entry<Double, Integer> entry : this.allAsks.descendingMap().entrySet()) {
            System.out.printf("%15s   %-9s%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Double, Integer> entry : this.allBids.entrySet()) {
            System.out.printf("%7s   %-10s%n", entry.getValue(), entry.getKey());
        }

    }

    /** Methods of not-online solution.
        1. Parse all file first and fill ask & bid trees from all orders HashMap.
        2. Check aks & bid trees.
        3. Print result.
     */

    /**
     * Fill trees of bids and asks from HashMap of all Orders.
     */
    public void fillBidsAndAsks() {
        for(Order order : this.allOrders.values()) {
            if(order.getBuy()) {
                putVolume(allBids, order);
            } else {
                putVolume(allAsks, order);
            }
        }
    }

    /**
     * Put volume by price in tree.
     * @param orders this tree of bids or asks with aggregated stocks volumes.
     * @param order next order.
     */
    private void putVolume(TreeMap<Double, Integer> orders, Order order) {
        double price = order.getPrice();
        if(orders.containsKey(price)) {
            int volume = orders.get(price) + order.getVolume();
            orders.put(price, volume);
        } else {
            orders.put(price, order.getVolume());
        }
    }

    /**
     * Check filled by fillBidsAndAsks() trees.
     */
    public void concatTrees() {
        double topBid = this.allBids.firstKey();
        double topAsk = this.allAsks.firstKey();
        int bidCount = this.allBids.get(topBid);
        int askCount = this.allAsks.get(topAsk);
        while (topBid >= topAsk) {
            if (askCount > bidCount) {
                this.allBids.remove(topBid);
                topBid = this.allBids.firstKey();
                askCount = askCount - bidCount;
                bidCount = this.allBids.get(topBid);
            } else if (askCount < bidCount) {
                this.allAsks.remove(topAsk);
                topAsk = this.allAsks.firstKey();
                bidCount = bidCount - askCount;
                askCount = this.allAsks.get(topAsk);
            } else {
                this.allBids.remove(topBid);
                this.allAsks.remove(topAsk);
                topAsk = this.allAsks.firstKey();
                topBid = this.allBids.firstKey();
                bidCount = this.allBids.get(topBid);
                askCount = this.allAsks.get(topAsk);
            }
        }
    }

}
