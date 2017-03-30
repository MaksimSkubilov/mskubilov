package mskubilov.figures;

import mskubilov.moves.InterfaceOfMoves;
import mskubilov.board.Cell;
import mskubilov.exceptions.ImpossibleMoveException;

/**
 * Figure. Абстрактный класс шахматной фигуры.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.03.2017
 * @version 2.0
 */

public abstract class Figure implements InterfaceOfMoves {
	/**
	 * Позиция фигуры на доске.
	 */
	private final Cell position;
	/**
	 * Figure. Конструктор класса.
	 * @param position - положение фигуры на доске.
	*/
	public Figure(Cell position) {
		this.position = position;
	}
	/**
	 * way. Проверка возможности хода фигуры по доске.
	 * @param source - откуда ходить.
	 * @param cell - куда ходить.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @return массив пройденных фигурой ячеек до места назначения.
	 */
	public abstract Cell[] way(Cell source, Cell cell) throws ImpossibleMoveException;
	/**
	 * clone. Метод, реализующий перемещение фигуры на новую позицию.
	 * @param dest - ход фигуры.
	 * @return фигура с новой позицией.
	 */
	public abstract Figure clone(Cell dest);
	/**
	 * getPosition. Возвращает this.position.
	 * @return позиция на доске.
	 */
	public Cell getPosition() {
		return this.position;
	}
}