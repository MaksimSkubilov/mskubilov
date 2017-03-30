package mskubilov.figures;

import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;
import mskubilov.moves.MoveLikeRook;
import mskubilov.moves.MoveLikeBishop;

/**
 * Queen. Ферзь, наследуется от Figure.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 30.03.2017
 * @version 1.0
 */

public class Queen extends Figure {
	/**
	 * Queen. Конструктор класса.
	 * @param position - положение фигуры на доске.
	*/
	public Queen(Cell position) {
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
		try {
			return new MoveLikeRook().way(source, dest);
		} catch (ImpossibleMoveException ime) {
			return new MoveLikeBishop().way(source, dest);
		}
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