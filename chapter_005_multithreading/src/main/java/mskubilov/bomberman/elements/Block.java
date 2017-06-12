package mskubilov.bomberman.elements;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 12.06.17
 */
public class Block extends Element {
    /**
     * Construct new Block.
     * @param cell where place Block.
     * @param board of game.
     */
    public Block(Cell cell, Cell[][] board) {
        super(cell, board);
    }

    /**
     * Override super.
     * @param cell to move Element.
     * @return false.
     */
    @Override
    public boolean move(Cell cell) {
        return false;
    }
}
