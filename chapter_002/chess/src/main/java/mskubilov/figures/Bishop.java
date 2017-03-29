package mskubilov.figures;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;

/**
 * Bishop. Слон, наследуется от Figure.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.03.2017
 * @version 1.0
 */

public class Bishop extends Figure {
	/**
	 * Bishop. Конструктор класса.
	 * @param position - положение фигуры на доске.
	*/
	public Bishop(Cell position) {
		super(position);
	}
	/**
	 * isMoveOk. Проверка возможности хода фигуры по доске.
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
		int distanceToNewC = Math.abs(fromC - toC);
		int distanceToNewR = Math.abs(fromR - toR);
		Cell[] result;
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
	/**
	 * clone. Метод, реализующий клонирование фигуры с новой позицией.
	 * @param dest - ход фигуры.
	 * @return слон с новой позицией.
	 */
	public Figure clone(Cell dest) {
		return new Bishop(dest);
	}
}