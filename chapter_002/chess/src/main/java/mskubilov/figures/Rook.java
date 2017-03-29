package mskubilov.figures;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;

/**
 * Rook. Ладья, наследуется от Figure.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 29.03.2017
 * @version 1.0
 */

public class Rook extends Figure {
	/**
	 * Rook. Конструктор класса.
	 * @param position - положение фигуры на доске.
	*/
	public Rook(Cell position) {
		super(position);
	}
	/**
	 * way. Проверка возможности хода фигуры по доске.
	 * @param dest - ход фигуры.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @return массив разрешенных ходов фигуры.
	 */
	@Override
	public Cell[] way(Cell dest) throws ImpossibleMoveException {
		int tempC = 1 - Character.digit('a', 36);
		int fromC = Character.digit(this.getPosition().getColumn(), 36) - tempC;
		int fromR = this.getPosition().getRow();
		int toC = Character.digit(dest.getColumn(), 36) - tempC;
		int toR = dest.getRow();
		int distanceToNewC = fromC - toC;
		int distanceToNewR = fromR - toR;
		Cell[] result = new Cell[0];
		if (dest.isOnBoard()) {
			if (distanceToNewC == 0) {
				if (distanceToNewR < 0) {
					result = new Cell[Math.abs(distanceToNewR)];
					for (int i = 0; i != Math.abs(distanceToNewR); i++) {
						result[i] = new Cell(dest.getColumn(), fromR + 1 + i);
					}
				}
				if (distanceToNewR > 0) {
					result = new Cell[Math.abs(distanceToNewR)];
					for (int i = 0; i != distanceToNewR; i++) {
						result[i] = new Cell(dest.getColumn(), fromR - 1 - i);
					}
				}
			} else if (distanceToNewR == 0) {
				if (distanceToNewC < 0) {
					result = new Cell[Math.abs(distanceToNewC)];
					for (int i = 0; i != Math.abs(distanceToNewC); i++) {
						char temp = Character.forDigit(fromC + tempC + 1 + i, 36);
						result[i] = new Cell(temp, fromR);
					}
				}
				if (distanceToNewC > 0) {
					result = new Cell[Math.abs(distanceToNewC)];
					for (int i = 0; i != distanceToNewC; i++) {
						char temp = Character.forDigit(fromC + tempC - 1 - i, 36);
						result[i] = new Cell(temp, fromR);
					}
				}
			} else {
				throw new ImpossibleMoveException("Ладья не умеет так ходить!");
			}
		} else {
			throw new ImpossibleMoveException("Ход за пределы доски!");
		}
		return result;
	}
	/**
	 * clone. Метод, реализующий клонирование фигуры с новой позицией.
	 * @param dest - ход фигуры.
	 * @return ладья с новой позицией.
	 */
	public Figure clone(Cell dest) {
		return new Rook(dest);
	}
}