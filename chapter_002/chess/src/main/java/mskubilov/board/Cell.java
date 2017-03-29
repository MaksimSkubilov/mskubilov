package mskubilov.board;

/**
 * Figure. Абстрактный класс шахматной фигуры.
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @since 28.03.2017
 * @version 1.0
 */

public class Cell {
	/**
	 * Номер строки.
	 */
	private int row;
	/**
	 * Символ столбца.
	 */
	private char column;
	/**
	 * Cell. Конструктор класса.
	 * @param column - вертикаль.
	 * @param row - горизонталь.
	*/
	public Cell(char column, int row) {
		this.column = column;
		this.row = row;
	}
	/**
	 * getColumn. Возвращает this.column.
	 * @return символ столбца.
	 */
	public char getColumn() {
		return this.column;
	}
	/**
	 * getRow. Возвращает this.row.
	 * @return номер строки.
	 */
	public int getRow() {
		return this.row;
	}
	/**
	 * isOnBoard. Состояние ячейки.
	 * @return на доске или вне ее.
	 */
	public boolean isOnBoard() {
		boolean result = true;
		if (this.getColumn() < 'a' || this.getColumn() > 'h') {
			result = false;
		}
		if (this.getRow() < 1 || this.getRow() > 8) {
			result = false;
		}
		return result;
	}
	/**
	 * equals. Переопределение equals для Cell.
	 * @return равны или не равны.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (this == obj) {
			result = true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			result = false;
		}
		Cell other = (Cell) obj;
		if (this.row == other.getRow() && this.column == other.getColumn()) {
			result = true;
		}
		return result;
	}
	/**
	 * hashCode. Переопределение hashCode для Cell.
	 * @return равны или не равны.
	 */
	@Override
        public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getRow();
			result = prime * result + getColumn();
			return result;
        }
}