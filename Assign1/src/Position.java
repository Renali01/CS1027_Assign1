/**
 * Class Position, where object in class represents position of square of the grid
 * @author Rena Li 
 * @date June 5, 2020 
 *
 */

public class Position {
	
	// instance variables
	private int positionRow;
	private int positionColumn;
	
	/**
	 * Constructor
	 * @param row
	 * @param col
	 */
	Position(int row, int col){
		positionRow = row;
		positionColumn = col;
	}
	
	int getRow() {
		return positionRow;
	}
	
	int getCol() {
		return positionColumn;
	}
	
	void setRow(int newRow) {
		positionRow = newRow;
	}
	
	void setCol(int newCol) {
		positionColumn = newCol;
	}
	
	/*
	 * Method equals returns true if Position object and otherPosition have same values stored in positionRow and positionColumn
	 */
	boolean equals(Position otherPosition) {
		if (positionRow == otherPosition.positionRow && positionColumn == otherPosition.positionColumn) return true;
		else return false;
	}
	
}
