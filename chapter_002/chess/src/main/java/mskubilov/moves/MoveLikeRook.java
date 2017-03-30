package mskubilov.moves;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;

/**
 * MoveLikeRook. Возвращает движения слона до указанной ячейки.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 30.03.2017
 * @version 1.0
 */

public class MoveLikeRook implements InterfaceOfMoves {
	/**
	 * way. Проверка возможности хода фигуры по доске.
	 * @param source - откуда ходить.
	 * @param dest - куда ходить.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @return массив пройденных фигурой ячеек до места назначения.
	 */
	public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
		Cell[] result = new Cell[0];
		int tempC = 1 - Character.digit('a', 36);
		int fromC = Character.digit(source.getColumn(), 36) - tempC;
		int fromR = source.getRow();
		int toC = Character.digit(dest.getColumn(), 36) - tempC;
		int toR = dest.getRow();
		int distanceToNewC = fromC - toC;
		int distanceToNewR = fromR - toR;
		if (distanceToNewC == 0) {
			result = new Cell[Math.abs(distanceToNewR)];
			if (distanceToNewR < 0) {
				for (int i = 0; i != Math.abs(distanceToNewR); i++) {
					result[i] = new Cell(dest.getColumn(), fromR + 1 + i);
				}
			}
			if (distanceToNewR > 0) {
				for (int i = 0; i != distanceToNewR; i++) {
					result[i] = new Cell(dest.getColumn(), fromR - 1 - i);
				}
			}
		} else if (distanceToNewR == 0) {
			result = new Cell[Math.abs(distanceToNewC)];
			if (distanceToNewC < 0) {
				for (int i = 0; i != Math.abs(distanceToNewC); i++) {
					char temp = Character.forDigit(fromC + tempC + 1 + i, 36);
					result[i] = new Cell(temp, fromR);
				}
			}
				if (distanceToNewC > 0) {
				for (int i = 0; i != distanceToNewC; i++) {
					char temp = Character.forDigit(fromC + tempC - 1 - i, 36);
					result[i] = new Cell(temp, fromR);
				}
			}
		} else {
			throw new ImpossibleMoveException("Недопустимый ход!");
		}
		return result;
	}
}