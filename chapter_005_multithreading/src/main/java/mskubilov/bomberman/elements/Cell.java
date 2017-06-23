package mskubilov.bomberman.elements;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 10.06.17
 */
public class Cell {
    /**
     * Element instance linked with this Cell instance at a time.
     */
    private Element e = null;
    /**
     * X coordinate.
     */
    private final int x;
    /**
     * Y coordinate.
     */
    private final int y;

    /**
     * Cell's lock.
     */
    private final Lock lock = new ReentrantLock();

    /**
     * Construct new Cell.
     * @param x coordinate.
     * @param y coordinate.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Link Element with this Cell instance.
     * @param e new element.
     */
    public void setElement(Element e) {
        this.e = e;
    }

    /**
     * Get linked Element.
     * @return this.e.
     */
    public Element getElement() {
        return this.e;
    }

    /**
     * @return this.x.
     */
    public int getX() {
        return x;
    }

    /**
     * @return this.y.
     */
    public int getY() {
        return y;
    }

    /**
     * @return this cell's lock.
     */
    public Lock getLock() {
        return lock;
    }
}
