package chess;


/**
 * Interface class that includes the common method between all the pieces
 * 
 * @author Ansh Shah, Kandarp Patel
 *
 */
public interface Piece {

	/**
	 * This method will return the row of that piece
	 * @return int Current row of the piece
	 */
	int getRow();
	
	/**
	 * This method will return the column of that piece
	 * @return int Current column of the piece
	 */
	int getCol();
	
	/**
	 * This method will return true if that piece has not yet been captured
	 * @return boolean Returns true if piece is still alive
	 */
	boolean isAlive();
	
	/**
	 * This method checks if the proposed move is valid for that piece based off of the path it can take
	 * @param currCol Index of the current column
	 * @param currRow Index of the current row
	 * @param tarCol Index of the target column
	 * @param tarRow Index of the target row
	 * @param color Color of the piece
	 * @return boolean Returns true if the proposed move is valid for that piece
	 */
	boolean moveValid(int currCol, int currRow, int tarCol, int tarRow, char color);
	
	/**
	 * This method changes the row and column fields of that piece when moved
	 * @param toRow Index of the target row
	 * @param toCol Index of the target column
	 */
	void move(int toRow, int toCol);
	
	
	
}
