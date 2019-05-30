package chess;
/**
 * Pawn class that portray a pawn's behavior
 * 
 * @author Ansh Shah, Kandarp Patel
 *
 */
public class Pawn implements Piece{
	
	/** Row index of the Pawn's location */
	int row;
	
	/** Column index of the Pawn's location */
	int col;
	
	/** If pawn is still at it's initial position */
	boolean initPos = true;
	
	/** If pawn is still alive */
	boolean isAlive = true;
	
	/**
	 * Constructor - initializes the fields
	 * 
	 * @param col Column index of the pawn
	 * @param row Row index of the pawn
	 */
	public Pawn(int col, int row) {
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
	public boolean moveValid(int currCol, int currRow, int tarCol, int tarRow, char color){
		
		if(color == 'w') {
			
			//Trying to move in the wrong direction
			if(tarRow > currRow)
				return false;
			
			
			//If the pawn is not trying to attack another piece
			if(currCol == tarCol) {

				//Pawn is still in it's initial position
				if(initPos == true) {
					
					if(currRow - tarRow <= 2)
						return true;
					
				//Pawn is not in it's initial position
				}else
					if(currRow - tarRow == 1)
						return true;
			}
			
			//If pawn is trying to attack another piece
			if(Math.abs(tarCol - currCol) == 1) {
				if(currRow - tarRow == 1)
					return true;
			
			}
			
		}
		
		if(color == 'b') {
			
			//Trying to move in the wrong direction
			if(tarRow < currRow)
				return false;
			
			
			//If the pawn is not trying to attack another piece
			if(currCol == tarCol) {

				//Pawn is still in it's initial position
				if(initPos == true) {
					
					if(tarRow - currRow <= 2)
						return true;
					
				//Pawn is not in it's initial position
				}else
					if(tarRow - currRow == 1)
						return true;
			}
			
			//If pawn is trying to attack another piece
			if(Math.abs(tarCol - currCol) == 1) {
				if(tarRow - currRow == 1)
					return true;
			
			}
			
		}
		
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
