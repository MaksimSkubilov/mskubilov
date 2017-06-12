package mskubilov.bomberman;

import mskubilov.bomberman.elements.Block;
import mskubilov.bomberman.elements.Cell;
import mskubilov.bomberman.elements.Monster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 10.06.17
 */
public class Board {
    /**
     * Board's cells array.
     */
    private Cell[][] board;
    /**
     * Pool to move runnable Elements.
     */
    private final ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * Construct this.board and place not-blown Blocks like in original Bomberman game.
     * @param size 1, 2 or 3 values to increase board's size.
     */
    public Board(int size) {
        switch (size) {
            case 1:
                board = new Cell[11][11];
                break;
            case 2:
                board = new Cell[22][22];
                break;
            case 3:
                board = new Cell[44][44];
                break;
            default:
                board = new Cell[11][11];
                break;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                board[i][j].setElement(new Block(board[i][j++], this.board));
            }
            i++;
        }
    }

    /**
     * Set Monsters count on board and start pool executor.
     * @param count count of monsters.
     */
    public void setMonsters(int count) {
        boolean setMonster;
        Monster monster;
        Cell cell;
        for (int i = 0; i < count; i++) {
            setMonster = false;
            while (!setMonster) {
                int x = (int) (Math.random() * board.length - 0.00000000001);
                int y = (int) (Math.random() * board.length - 0.00000000001);
                cell = board[x][y];
                synchronized (cell) {
                    if (board[x][y].getElement() == null) {
                        monster = new Monster(board[x][y], board);
                        executor.execute(monster);
                        System.out.printf("Monster #%s created on x:%s, y:%s\n", i + 1, board[x][y].getX(), board[x][y].getY());
                        setMonster = true;
                    }
                }
            }
        }
    }

    /**
     * Main method.
     * @param args some arguments.
     */
    public static void main(String[] args) {
        Board board = new Board(1);
        board.setMonsters(8);
    }
}
