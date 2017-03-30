package mskubilov.moves;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;

/**
 * InterfaceOfMoves. Интерфейс разрешенных ходов.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.03.2017
 * @version 2.0
 */

public interface InterfaceOfMoves {
	/**
	 * way. Проверка возможности хода фигуры по доске.
	 * @param source - откуда ходить.
	 * @param cell - куда ходить.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @return массив пройденных фигурой ячеек до места назначения.
	 */
	Cell[] way(Cell source, Cell cell) throws ImpossibleMoveException;
}