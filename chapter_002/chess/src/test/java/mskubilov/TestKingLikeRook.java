package mskubilov;

import mskubilov.board.*;
import mskubilov.exceptions.*;
import mskubilov.moves.*;
import mskubilov.figures.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TestKingLikeRook.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 30.03.2017
 * @version 1.0
 */

public class TestKingLikeRook {
	/**
	 * Test of moving King like Rook.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @throws OccupiedWayException - исключение хода, путь к которому закрыт другой фигурой.
	 * @throws FigureNotFoundException - исключение хода, когда нет фигуры на source.
	 */
	@Test
	public void testKing() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		Board board = new Board();
		board.fillBoard();
		board.setFigure(new King(new Cell('d', 4)));
		boolean move = false;
		Cell source = new Cell('d', 4);
		Cell dest = new Cell('e', 4);
		move = board.move(source, dest);
		assertThat(move, is(true));
		assertThat(board.getFigure(0).getPosition(), is(dest));
	}
	/**
	 * Test of FigureNotFoundException.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @throws OccupiedWayException - исключение хода, путь к которому закрыт другой фигурой.
	 * @throws FigureNotFoundException - исключение хода, когда нет фигуры на source.
	 */
	@Test (expected = FigureNotFoundException.class)
	public void whenWrongSourceCellThenThereIsFigureNotFoundException()
				throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		Board board = new Board();
		board.fillBoard();
		board.setFigure(new King(new Cell('d', 4)));
		boolean move = false;
		move = board.move(new Cell('d', 1), new Cell('d', 2));
	}
	/**
	 * Test of ImpossibleMoveException.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @throws OccupiedWayException - исключение хода, путь к которому закрыт другой фигурой.
	 * @throws FigureNotFoundException - исключение хода, когда нет фигуры на source.
	 */
	@Test (expected = ImpossibleMoveException.class)
	public void whenWrongDestCellThenThereIsImpossibleMoveException()
				throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		Board board = new Board();
		board.fillBoard();
		board.setFigure(new King(new Cell('d', 4)));
		boolean move = false;
		move = board.move(new Cell('d', 4), new Cell('b', 4));
	}
	/**
	 * Test of OccupiedWayException.
	 * @throws ImpossibleMoveException - исключение невозможного хода.
	 * @throws OccupiedWayException - исключение хода, путь к которому закрыт другой фигурой.
	 * @throws FigureNotFoundException - исключение хода, когда нет фигуры на source.
	 */
	@Test (expected = OccupiedWayException.class)
	public void whenThereIsAFigureOnTheWayThenThereIsOccupiedWayException()
				throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		Board board = new Board();
		board.fillBoard();
		board.setFigure(new King(new Cell('f', 7)));
		boolean move = false;
		move = board.move(new Cell('f', 7), new Cell('g', 7));
	}
}