package mskubilov.iterator;

import java.util.Iterator;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 15.04.17
 */

/**
 * Iterator of double array.
 * @param <Integer>
 */
public class ArrayIterator<Integer> implements Iterator<java.lang.Integer> {
    /**
     * iterable array.
     */
    private int[][] array;
    /**
     * row index.
     */
    private int indexRow = 0;
    /**
     * column index.
     */
    private int indexCol = 0;

    /**
     * class constructor.
     * @param array - iterable array.
     */
    public ArrayIterator(int[][] array) {
        this.array = array;
    }

    /**
     * @return hasNext element or not.
     */
    @Override
    public boolean hasNext() {
        return indexRow < this.array.length;
    }

    /**
     * @return next element.
     */
    @Override
    public java.lang.Integer next() {
        int result = array[indexRow][indexCol++];
        if (indexCol == array[indexRow].length) {
            indexRow++;
            indexCol = 0;
        }
        return result;
    }

    /**
     * removes current element in a row.
     */
    @Override
    public void remove() {
        if (indexCol == this.array[indexRow].length - 1) {
            this.array[indexRow][indexCol] = 0;
        } else {
            for (int i = indexCol; i != this.array[indexRow].length - 1;) {
                this.array[indexRow][i++] = this.array[indexRow][i];
                this.array[indexRow][i] = 0;
            }
        }
    }

}
