package mskubilov.figures;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;
import mskubilov.moves.MoveLikeRook;

/**
 * Rook. Ладья, наследуется от Figure.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 29.03.2017
 * @version 2.0
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
	 * @param source - откуда ходить.
	 * @param dest - куда ходить.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @return массив разрешенных ходов фигуры.
	 */
	@Override
	public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
		if (dest.isOnBoard()) {
			return new MoveLikeRook().way(source, dest);
		} else {
			throw new ImpossibleMoveException("Ход за пределы доски!");
		}
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