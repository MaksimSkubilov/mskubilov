package mskubilov.board;

import mskubilov.figures.*;
import mskubilov.exceptions.*;

/**
 * Board. Класс реализует шахматную доску.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.03.2017
 * @version 1.0
 */

public class Board {
	/**
	 * Массив шахматных фигур.
	 */
	private Figure[] figures = new Figure[5];
	/**
	 * fillBoard. Метод, заполняющий доску фигурами.
	 */
	public void fillBoard() {
		figures[0] = new Bishop(new Cell('d', 4));
		figures[1] = new Bishop(new Cell('g', 7));
		figures[2] = new Bishop(new Cell('a', 7));
		figures[3] = new Bishop(new Cell('a', 1));
		figures[4] = new Bishop(new Cell('g', 1));

	}
	/**
	 * move. Передвижение фигуры.
	 * @param source - откуда двигать.
	 * @param dest - куда двигать.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @throws OccupiedWayException - исключение хода, путь к которому закрыт другой фигурой.
	 * @throws FigureNotFoundException - исключение хода, когда нет фигуры на source.
	 * @return массив пройденных фигурой ячеек до места назначения.
	 */
	public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		boolean result = false;
		Cell[] way = new Cell[0];
		int i = 0;
		if (source.isOnBoard()) {
			for (i = 0; i != this.figures.length; i++) {
				if (source.equals(this.figures[i].getPosition())) {
					way = this.figures[i].way(source, dest);
					result = true;
					break;
				}
			}
			if (!result) {
				throw new FigureNotFoundException("На этом месте нет фигуры!");
			}
		} else {
			throw new FigureNotFoundException("Этого места нет на доске!");
		}
		if (result) {
			for (int k = 0; k != this.figures.length; k++) {
				for (int j = 0; j != way.length; j++) {
					if (this.figures[k].getPosition().equals(way[j])) {
						throw new OccupiedWayException("Фигура не может перепрыгнуть через другую фигуру!");
					}
				}
			}
		}
		if (result) {
			Figure temp = this.figures[i].clone(dest);
			this.figures[i] = temp;
		}
		return result;
	}
//вспомогательные методы для тестирования
	/**
	 * getFigures. Метод, возвращающий фигуры.
	 * @param i - индекс в массиве.
	 * @return фигура по индексу.
	 */
	public Figure getFigure(int i) {
		return this.figures[i];
	}
	/**
	 * setFigureOnD4ForTest. Метод, йстанавливающий тестируемую фигуру.
	 * @param figure - устанавалвиаемая фигура.
	 */
	public void setFigure(Figure figure) {
		this.figures[0] = figure;
	}
}