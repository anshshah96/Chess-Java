package chess;
/**
 * Rook class that portray a rook's behavior
 * 
 * @author Ansh Shah, Kandarp Patel
 *
 */
public class Rook implements Piece{

	/** Row index of the Rook's location */
	int row;
	
	/** Column index of the Rook's location */
	int col;
	
	/** If Rook is still alive */
	boolean isAlive = true;
	
	/**
	 * Constructor - initializes the fields
	 * 
	 * @param col Column index of the Rook
	 * @param row Row index of the Rook
	 */
	public Rook(int col, int row) {
		this.row = row;
		this.col = col;
	}

	/**
	 * This method will return the row of that piece
	 * @return int Current row of the piece
	 */
	@Override
	public int getRow() {
		return row;
	}
	/**
	 * This method will return the column of that piece
	 * @return int Current column of the piece
	 */
	@Override
	public int getCol() {
		return col;
	}
	/**
	 * This method will return true if that piece has not yet been captured
	 * @return boolean Returns true if piece is still alive
	 */
	@Override
	public boolean isAlive() {
		return isAlive;
	}
	/**
	 * This method checks if the proposed move is valid for that piece based off of the path it can take
	 * @param currCol Index of the current column
	 * @param currRow Index of the current row
	 * @param tarCol Index of the target column
	 * @param tarRow Index of the target row
	 * @param color Color of the piece
	 * @return boolean Returns true if the proposed move is valid for that piece
	 */
	@Override
	public boolean moveValid(int currCol, int currRow, int tarCol, int tarRow, char color) {
		
		if(currCol == tarCol || currRow == tarRow)
			return true;
		
		return false;
	}
	
	/**
	 * This method changes the row and column fields of that piece when moved
	 * @param toRow Index of the target row
	 * @param toCol Index of the target column
	 */

	@Override
	public void move(int toRow, int toCol) {
		row = toRow;
		col = toCol;
	}

}
