package mskubilov.bomberman.elements;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 12.06.17
 */
public class Player extends Element {
    /**
     * Construct new Player.
     * @param cell where place Player.
     * @param board of game.
     */
    public Player(Cell cell, Cell[][] board) {
        super(cell, board);
    }
}
