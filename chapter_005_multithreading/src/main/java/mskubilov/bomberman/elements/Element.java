package mskubilov.bomberman.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 10.06.17
 */
public abstract class Element {
    /**
     * Cell element placed at the moment.
     */
    private Cell cell;
    /**
     * Game's array of cells.
     */
    private final Cell[][] board;
    /**
     * List of 4 moves, horizontal and vertical.
     */
    private List<Cell> moves;

    /**
     * Construct new Element.
     * @param cell which Element places.
     * @param board of game.
     */
    public Element(Cell cell, Cell[][] board) {
        this.board = board;
        leashACellWithElement(cell);
    }

    /**
     * Move element. Base method move would be used in extended classes as supportive.
     * @param cell to move Element.
     * @return true if move successful, false otherwise.
     */
    public boolean move(Cell cell) {
        boolean result = false;
        if (cell != null) {
            synchronized (cell) {
                if (cell.getElement() == null) {
                    this.cell.setElement(null);
                    leashACellWithElement(cell);
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * @return random next Cell from this.moves.
     */
    public Cell nextCell() {
        int i = (int) (Math.random() * moves.size() - 0.00000000001);
        Cell cell = moves.get(i);
        return cell;
    }

    /**
     * @return Cell if move up on board, null if move outside.
     */
    private Cell up() {
        Cell cell;
        try {
            cell = board[this.cell.getX() - 1][this.cell.getY()];
        } catch (ArrayIndexOutOfBoundsException e) {
            cell = null;
        }
        return cell;
    }
    /**
     * @return Cell if move down on board, null if move outside.
     */
    private Cell down() {
        Cell cell;
        try {
            cell = board[this.cell.getX() + 1][this.cell.getY()];
        } catch (ArrayIndexOutOfBoundsException e) {
            cell = null;
        }
        return cell;
    }
    /**
     * @return Cell if move right on board, null if move outside.
     */
    private Cell right() {
        Cell cell;
        try {
            cell = board[this.cell.getX()][this.cell.getY() + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            cell = null;
        }
        return cell;
    }
    /**
     * @return Cell if move left on board, null if move outside.
     */
    private Cell left() {
        Cell cell;
        try {
            cell = board[this.cell.getX()][this.cell.getY() - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            cell = null;
        }
        return cell;
    }

    /**
     * Fill this.moves.
     * @return List of moves.
     */
    private List<Cell> possibleMoves() {
        ArrayList<Cell> cells = new ArrayList<>(4);
        cells.add(up());
        cells.add(down());
        cells.add(right());
        cells.add(left());
        return cells;
    }

    /**
     * Leash Cell and Element.
     * @param cell to leash.
     */
    private void leashACellWithElement(Cell cell) {
        this.cell = cell;
        cell.setElement(this);
        moves = possibleMoves();
    }

}
