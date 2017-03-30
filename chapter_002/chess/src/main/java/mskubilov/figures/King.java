package mskubilov.figures;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;
import mskubilov.moves.MoveLikeRook;
import mskubilov.moves.MoveLikeBishop;

/**
 * King. Король, наследуется от Figure.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 30.03.2017
 * @version 1.0
 */

public class King extends Figure {
	/**
	 * King. Конструктор класса.
	 * @param position - положение фигуры на доске.
	*/
	public King(Cell position) {
		super(position);
	}
	/**
	 * way. Проверка возможности хода фигуры по доске.
	 * @param source - откуда ходить.
	 * @param dest - куда ходить.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @return массив разрешенных ходов фигуры.
	 */
	@Override
	public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
		Cell[] result = new Cell[0];
		if (dest.isOnBoard()) {
			int tempC = 1 - Character.digit('a', 36);
			int fromC = Character.digit(source.getColumn(), 36) - tempC;
			int fromR = source.getRow();
			int toC = Character.digit(dest.getColumn(), 36) - tempC;
			int toR = dest.getRow();
			int distanceToNewC = Math.abs(fromC - toC);
			int distanceToNewR = Math.abs(fromR - toR);
			if (distanceToNewC == 1 && distanceToNewR == 1) {
				result = new MoveLikeBishop().way(source, dest);
			} else if (distanceToNewC == 0 && distanceToNewR == 1 || distanceToNewR == 0 && distanceToNewC == 1) {
				result = new MoveLikeRook().way(source, dest);
			} else {
				throw new ImpossibleMoveException("Король не умеет так ходить!");
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
		return new Queen(dest);
	}
}