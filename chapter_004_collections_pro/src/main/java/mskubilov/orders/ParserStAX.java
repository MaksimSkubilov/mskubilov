package mskubilov.orders;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;


/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 27.04.17
 */

/**
 * XML Orders parser by StAX.
 */
public class ParserStAX {

    /**
     * HashMap of Order Books.
     */
    private HashMap<String, Book> books = new HashMap<>();

    /**
     * Parser of file.
     * @param filePath path to file on HDD.
     * @throws FileNotFoundException FileNotFoundException.
     * @throws XMLStreamException XMLStreamException.
     */
    public void parse(String filePath) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInput = XMLInputFactory.newInstance();
        InputStream streamFromFile = new FileInputStream(filePath);
        XMLStreamReader streamReader = xmlInput.createXMLStreamReader(streamFromFile);
        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                if (streamReader.getLocalName().startsWith("A")) {
                    Order order = new Order(Double.valueOf(streamReader.getAttributeValue(2)),
                            Integer.valueOf(streamReader.getAttributeValue(3)),
                            Integer.valueOf(streamReader.getAttributeValue(4)),
                            streamReader.getAttributeValue(1).equals("BUY"));
                    String bookId = streamReader.getAttributeValue(0);
                    Book book = this.books.get(bookId);
                    if (book == null) {
                        book = new Book(bookId);
                        this.books.put(bookId, book);
                        book.addOrder(order);
                    } else {
                        book.addOrder(order);
                    }
                } else if (streamReader.getLocalName().startsWith("D")) {
                    String bookId = streamReader.getAttributeValue(0);
                    Book book = this.books.get(bookId);
                    int orderId = Integer.valueOf(streamReader.getAttributeValue(1));
                    book.removeOrder(orderId);
                }
            }
            streamReader.next();
        }
    }

}
