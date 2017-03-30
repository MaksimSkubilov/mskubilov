package mskubilov.moves;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;

/**
 * MoveLikeBishop. Возвращает движения слона до указанной ячейки.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 30.03.2017
 * @version 1.0
 */

public class MoveLikeBishop implements InterfaceOfMoves {
	/**
	 * way. Проверка возможности хода фигуры по доске.
	 * @param source - откуда ходить.
	 * @param dest - куда ходить.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @return массив пройденных фигурой ячеек до места назначения.
	 */
	public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
		int tempC = 1 - Character.digit('a', 36);
		int fromC = Character.digit(source.getColumn(), 36) - tempC;
		int fromR = source.getRow();
		int toC = Character.digit(dest.getColumn(), 36) - tempC;
		int toR = dest.getRow();
		int distanceToNewC = Math.abs(fromC - toC);
		int distanceToNewR = Math.abs(fromR - toR);
		Cell[] result = new Cell[0];
		if (dest.isOnBoard()) {
			if (distanceToNewC == distanceToNewR) {
				result = new Cell[distanceToNewC];
				if (toC > fromC && toR > fromR) {
					for (int i = 0; i != distanceToNewC; i++) {
						char temp = Character.forDigit(fromC + i + tempC + 1, 36);
						result[i] = new Cell(temp, fromR + i + 1);
					}
				}
				if (toC > fromC && toR < fromR) {
					for (int i = 0; i != distanceToNewC; i++) {
						char temp = Character.forDigit(fromC + i + tempC + 1, 36);
						result[i] = new Cell(temp, fromR - i - 1);
					}
				}
				if (toC < fromC && toR < fromR) {
					for (int i = 0; i != distanceToNewC; i++) {
						char temp = Character.forDigit(fromC - i + tempC - 1, 36);
						result[i] = new Cell(temp, fromR - i - 1);
					}
				}
				if (toC < fromC && toR > fromR) {
					for (int i = 0; i != distanceToNewC; i++) {
						char temp = Character.forDigit(fromC - i + tempC - 1, 36);
						result[i] = new Cell(temp, fromR + i + 1);
					}
				}
			} else {
				throw new ImpossibleMoveException("Слон не умеет так ходить!");
			}
		} else {
			throw new ImpossibleMoveException("Ход за пределы доски!");
		}
		return result;
	}
}