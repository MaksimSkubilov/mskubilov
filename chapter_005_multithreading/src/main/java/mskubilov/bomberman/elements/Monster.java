package mskubilov.bomberman.elements;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 10.06.17
 */
public class Monster extends Element implements Runnable {

    /**
     * Construct new Monster.
     * @param cell where place Monster.
     * @param board of game.
     */
    public Monster(Cell cell, Cell[][] board) {
        super(cell, board);
    }

    /**
     * Run Monster on board. If Cell is busy by another Element then wait 5 seconds and try to step there again.
     * If it stands busy then try another Cell.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Cell cell = nextCell();
            if (cell != null) {
                if (!move(cell) && !cell.getElement().getClass().getSimpleName().equals("Block")) {
                    System.out.printf("%s way x:%s, y%s is blocked by %s, thread awaits 5 seconds\n",
                            Thread.currentThread().getName(), cell.getX(), cell.getY(), cell.getElement().getClass().getSimpleName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!move(cell)) {
                        System.out.printf("%s way still blocked by %s monster changes direction\n",
                                Thread.currentThread().getName(), cell.getElement().getClass().getSimpleName());
                    } else {
                        System.out.printf("%s moved monster to x:%s y:%s\n",
                                Thread.currentThread().getName(), cell.getX(), cell.getY());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.printf("%s moved monster to x:%s y:%s\n",
                            Thread.currentThread().getName(), cell.getX(), cell.getY());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
