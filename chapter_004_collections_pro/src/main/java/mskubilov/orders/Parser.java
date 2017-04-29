package mskubilov.orders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 28.04.17
 */
/**
 * XML Orders parser by parsing String lines.
 */
public class Parser {

    /**
     * HashMap of Order Books.
     */
    private HashMap<String, Book> books = new HashMap<>();

    /**
     * Parser of file.
     * @param filePath path to file on HDD.
     * @throws java.io.IOException java.io.IOException.
     */
    public void parse(String filePath) throws java.io.IOException {
        FileReader streamFromFile = new FileReader(filePath);
        BufferedReader streamReader = new BufferedReader(streamFromFile);
        String line;
        while((line = streamReader.readLine()) != null) {
            if(line.startsWith("<A")) {
                Order order = makeOrder(line);
                String bookId = line.substring(16, 22);
                Book book = this.books.get(bookId);
                if(book == null) {
                    book = new Book(bookId);
                    this.books.put(bookId, book);
                    book.addOrder(order);
                } else {
                    book.addOrder(order);
                }
            } else if(line.startsWith("<D")) {
                int from = line.indexOf('"', 26) + 1;
                int to = line.indexOf('"', from);
                int orderId = Integer.valueOf(line.substring(from, to));
                String bookId = line.substring(19, 25);
                Book book = this.books.get(bookId);
                book.removeOrder(orderId);
            }
        }
    }

    /**
     * Make new Order.
     * @param line String line.
     * @return new Order from line.
     */
    private Order makeOrder(String line) {
        String[] fields = new String[4];
        int fieldsPos = 0;
        int from = 30;
        while(fieldsPos < 4) {
            from = line.indexOf('"', from) + 1;
            int to = line.indexOf('"', from);
            fields[fieldsPos++] = line.substring(from, to);
            from = to + 1;
        }
        return new Order(Double.valueOf(fields[1]), Integer.valueOf(fields[2]),
                Integer.valueOf(fields[3]), fields[0].equals("BUY"));
    }

    /**
     * Fill book trees of asks and bids.
     */
    public void fillBooksTrees() {
        for (Book book : this.books.values()) {
            book.fillBidsAndAsks();
            book.concatTrees();
        }
    }

    public void print() {
        for (Book book : this.books.values()) {
            book.print();
        }
    }
}
