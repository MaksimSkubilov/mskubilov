package mskubilov;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 19.04.17
 */

/**
 * Node with element.
 * @param <T> generic.
 */
public class Node<T> {
    /**
     * element.
     */
    private T value;
    /**
     * link of next Node.
     */
    private Node<T> next;

    /**
     * @param value value of element.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * @return next element.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * @param next element to set next.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * @param first element of cycled linked elements.
     * @return check of cycling.
     */
    public boolean hasCycle(Node<T> first) {
        boolean result = true;
        Node<T> current = first;
        Node<T> next = first.getNext();
        do {
            current = current.getNext();
            next = next.getNext();
            if (next.getNext() == null) {
                result = false;
                break;
            }
            if (next.getNext().getNext() == current) {
                break;
            }
        } while (true);
        return result;
    }
}
