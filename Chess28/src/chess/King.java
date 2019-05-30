package chess;
/**
 * King class that portray a king's behavior
 * 
 * @author Ansh Shah, Kandarp Patel
 *
 */
public class King implements Piece{
	
	/** Row index of the King's location */
	int row;
	
	/** Column index of the King's location */
	int col;
	
	/** If king is still at it's initial position */
	boolean isAlive = true;
	
	/** If king is still alive */
	boolean initPos = true;
	
	
	/**
	 * Constructor - initializes the fields
	 * 
	 * @param col Column index of the king
	 * @param row Row index of the king
	 */
	public King(int col, int row) {
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
		
		//only move if the maximum difference between columns or rows is 1
		if(Math.abs(currCol - tarCol) <= 1 && Math.abs(currRow - tarRow) <= 1)
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
		initPos = false;
	}

}
