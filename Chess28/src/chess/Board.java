package chess;

/**
 * The Board class is where the logic of the game is handled. It also initiates all the pieces. It checks all the cases in which a proposed move may not be valid
 * 
 * @author Ansh Shah, Kandarp Patel
 */
public class Board {
	
	/** Declaration of the Black King piece */
	King bK;
	/** Declaration of the White King piece */
	King wK;
	
	/** Declaration of Black Queen piece */
	Queen bQ;
	/** Declaration of White Queen piece */
	Queen wQ;
	
	/** Declaration of Black Rook piece 1*/
	Rook bR1; 
	/** Declaration of Black Rook piece 2*/
	Rook bR2;
	/** Declaration of White Rook piece 1*/
	Rook wR1;
	/** Declaration of White Rook piece 2*/
	Rook wR2;
	
	/** Declaration of Black Knight piece 1*/
	Knight bN1;
	/** Declaration of Black Knight piece 2*/
	Knight bN2;
	/** Declaration of White Knight piece 1*/
	Knight wN1;
	/** Declaration of White Knight piece 2*/
	Knight wN2;
	
	/** Declaration of Black Bishop piece 1 */
	Bishop bB1;
	/** Declaration of Black Bishop piece 2 */
	Bishop bB2;
	/** Declaration of White Bishop piece 1 */
	Bishop wB1;
	/** Declaration of White Bishop piece 2 */
	Bishop wB2;
	
	/** Declaration of Black Pawn piece 1 */
	Pawn bp1;
	/** Declaration of Black Pawn piece 2 */
	Pawn bp2;
	/** Declaration of Black Pawn piece 3*/
	Pawn bp3;
	/** Declaration of Black Pawn piece 4*/
	Pawn bp4; 
	/** Declaration of Black Pawn piece 5*/
	Pawn bp5;
	/** Declaration of Black Pawn piece 6*/
	Pawn bp6;
	/** Declaration of Black Pawn piece 7*/
	Pawn bp7;
	/** Declaration of Black Pawn piece 8*/
	Pawn bp8;
	/** Declaration of White Pawn piece 1*/
	Pawn wp1;
	/** Declaration of White Pawn piece 2*/
	Pawn wp2;
	/** Declaration of White Pawn piece 3*/
	Pawn wp3;
	/** Declaration of White Pawn piece 4*/
	Pawn wp4;
	/** Declaration of White Pawn piece 5*/
	Pawn wp5;
	/** Declaration of White Pawn piece 6*/
	Pawn wp6;
	/** Declaration of White Pawn piece 7*/
	Pawn wp7;
	/** Declaration of White Pawn piece 8*/
	Pawn wp8;
	
	/**
	 * 2D boolean array that tracks white pieces on the board
	 */
	boolean[][]whiteLayout = new boolean[8][8];
	
	/**
	 * 2D boolean array that tracks black pieces on the board
	 */
	boolean[][]blackLayout = new boolean[8][8];
	
	/**
	 * 2D String array that tracks all the pieces on the board
	 */
	String[][]pieces = new String[8][8];
	
	/**
	 * Constructor - Initializes all the pieces with their initial positions
	 * 			   - Initializes the whiteLayout and blackLayout arrays
	 * 			   - Calls the drawInitBoard method
	 */
	public Board() {
		
		bK = new King(4, 0);
		wK = new King(4, 7);
		
		bQ = new Queen(3, 0);
		wQ = new Queen(3, 7);
		
		bR1 = new Rook(7, 1);
		bR2 = new Rook(0, 1);
		wR1 = new Rook(7, 7);
		wR2 = new Rook(0, 7);
		
		bN1 = new Knight(1, 0);
		bN2 = new Knight(6, 0);
		wN1 = new Knight(1, 7);
		wN2 = new Knight(6, 7);
		
		bB1 = new Bishop(2, 0);
		bB2 = new Bishop(5, 0);
		wB1 = new Bishop(2, 7);
		wB2 = new Bishop(5, 7);
		
		bp1 = new Pawn(0, 1);
		bp2 = new Pawn(1, 1);
		bp3 = new Pawn(2, 1);
		bp4 = new Pawn(3, 1);
		bp5 = new Pawn(4, 1);
		bp6 = new Pawn(5, 1);
		bp7 = new Pawn(6, 1);
		bp8 = new Pawn(7, 1);

		wp1 = new Pawn(0, 6);
		wp2 = new Pawn(1, 6);
		wp3 = new Pawn(2, 6);
		wp4 = new Pawn(3, 6);
		wp5 = new Pawn(4, 6);
		wp6 = new Pawn(5, 6);
		wp7 = new Pawn(6, 6);
		wp8 = new Pawn(7, 6);
		
		drawInitBoard();
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 8; j++) {
				blackLayout[i][j] = true;
			}
		}
		
		for(int i = 6; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				whiteLayout[i][j] = true;
			}
		}
		
		
		
		
	}
	
	
	/**
	 * Draws the board by getting the locations of the pieces from the pieces array
	 */
	public void draw() {
		char[] cols = "abcdefgh".toCharArray();
	
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(pieces[i][j] != null)
					System.out.print(pieces[i][j] + " ");
				else if(i % 2 == 0){
					if(j % 2 != 0) 
						System.out.print("## ");
					else
						System.out.print("   ");
				}
				else {	
					if(j % 2 != 0)
						System.out.print("   ");
					else
						System.out.print("## ");
				}		
			}
			System.out.println(Math.abs(i - 8));
			
		}
		
		for(int k = 0; k < 8; k++)
			System.out.print(" " + cols[k] + " ");
		
		System.out.println();
		
		System.out.println();
		
		
	}
	
	/**
	 * Draws the board initially when all the pieces are in their initial positions and initializes the pieces array
	 */
	public void drawInitBoard() {
		char[] cols = "abcdefgh".toCharArray();
		
		System.out.println("bR bN bB bQ bK bB bN bR 8");
		System.out.println("bp bp bp bp bp bp bp bp 7");
		
		for(int i = 6; i > 2; i--) {
			for(int j = 0; j < 8; j++) {
				if(i % 2 == 0) {
					if(j % 2 != 0)
						System.out.print("## ");
					else 
						System.out.print("   ");
				}
			
				else {
					if(j % 2 != 0)
						System.out.print("   ");
					else
						System.out.print("## ");
				}
			}
			System.out.println(i);
		}
		
		System.out.println("wp wp wp wp wp wp wp wp 2");
		System.out.println("wR wN wB wQ wK wB wN wR 1");
		
		
		for(int k = 0; k < 8; k++)
			System.out.print(" " + cols[k] + " ");
		
		System.out.println();
		System.out.println();
		
		//initializes pieces board
		String[]blackPieces = {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"};
		String[]whitePieces = {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j< 8; j++) {
				if(i == 0)
					pieces[i][j] = blackPieces[j];
				else
					pieces[i][j] = "bp";
			}
		}
		for(int i = 6; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i == 6)
					pieces[i][j] = "wp";
				else
					pieces[i][j] = whitePieces[j];
			}
		}
	}
	
	/**
	 * This method takes into account all the factors that may make the proposed move by the player invalid. It calls various other helper methods that look at 
	 * different factors.
	 * 
	 * @param player Which player's move it is
	 * @param input What was the player's input
	 * @return boolean This returns true if the player's proposed input is valid
	 */
	public boolean validMove(char player, String input) {
		//Not valid input length
		if(input.length() < 5)
			return false;
		
		//break up the input
		char fromCol = input.charAt(0);
		char toCol = input.charAt(3);
		
		//get the column index
		int fromColInd = colIndex(fromCol);
		int toColInd = colIndex(toCol);
		
		//get the row index
		int fromRowInd = Math.abs((Character.getNumericValue((input.charAt(1)))) - 8);
		int toRowInd = Math.abs((Character.getNumericValue((input.charAt(4)))) - 8);
		
		
		//if proposed move is from and to the same cell
		if(fromRowInd == toRowInd && fromCol == toCol)
			return false;
		
		//Out of bounds
		if(toRowInd > 7 || toColInd > 7)
			return false;
		
		
		
		//Checks if (white's move) there is a white piece from where the player wants to move and that there is no piece in the target location
		if(player == 'w') {
			if(whiteLayout[fromRowInd][fromColInd] == false)
				return false;
			if(whiteLayout[toRowInd][toColInd] == true)
				return false;
		}
		
		//Checks if (black's move) there is a black piece from where the player wants to move and that there is no piece in the target location
		if(player == 'b') {
			if(blackLayout[fromRowInd][fromColInd] == false)
				return false;
			if(blackLayout[toRowInd][toColInd] == true)
				return false;
			
		}
		
		//check if the proposed move is valid for that piece
		boolean pieceMove = pieceMoveValid(fromRowInd, fromColInd, toRowInd, toColInd);
	
		if(pieceMove == false)
			return false;
		
		
		return true;
	}
	
	
	/**
	 * This method finds out which piece the player wants to move and if the proposed move is valid for that piece
	 * 
	 * @param fromRow The index of the current row
	 * @param fromCol The index of the current column
	 * @param toRow The index of the target row 
	 * @param toCol The index of the target column
	 * @return boolean This returns true if the proposed move is valid for the piece the player wants to move
	 */
	public boolean pieceMoveValid(int fromRow, int fromCol, int toRow, int toCol) {

		//figure out which piece the player wants to move and if that move is valid for that piece
		
		if(!isBlocked(fromRow, fromCol, toRow, toCol))
			return true;
		
		
		if(bK.isAlive() && bK.getRow() == fromRow && bK.getCol() == fromCol) {
			if(bK.moveValid(fromCol, fromRow, toCol, toRow, 'b') && !isCheck(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(wK.isAlive() && wK.getRow() == fromRow && wK.getCol() == fromCol) {
			if(wK.moveValid(fromCol, fromRow, toCol, toRow, 'w') && !isCheck(fromRow, fromCol, toRow, toCol, 'w')) 
				return true;
		}
		else if(bQ.isAlive() && bQ.getRow() == fromRow && bQ.getCol() == fromCol) {
			if(bQ.moveValid(fromCol, fromRow, toCol, toRow, 'b'))
				return true;
		}
		else if(wQ.isAlive() && wQ.getRow() == fromRow && wQ.getCol() == fromCol) {
			if(wQ.moveValid(fromCol, fromRow, toCol, toRow, 'w'))
				return true;
		}	
		else if(bR1.isAlive() && bR1.getRow() == fromRow && bR1.getCol() == fromCol) {
			if(bR1.moveValid(fromCol, fromRow, toCol, toRow, 'b'))
				return true;
		}
		else if(bR2.isAlive() && bR2.getRow() == fromRow && bR2.getCol() == fromCol) {
			if(bR2.moveValid(fromCol, fromRow, toCol, toRow, 'b'))
				return true;
		}
		else if(wR1.isAlive() && wR1.getRow() == fromRow && wR1.getCol() == fromCol) {
			if(wR1.moveValid(fromCol, fromRow, toCol, toRow, 'w'))
				return true;
		}
		else if(wR2.isAlive() && wR2.getRow() == fromRow && wR2.getCol() == fromCol) {
			if(wR2.moveValid(fromCol, fromRow, toCol, toRow, 'w'))
				return true;
		}
		else if(bN1.isAlive() && bN1.getRow() == fromRow && bN1.getCol() == fromCol) {
			if(bN1.moveValid(fromCol, fromRow, toCol, toRow, 'b'))
				return true;
		}
		else if(bN2.isAlive() && bN2.getRow() == fromRow && bN2.getCol() == fromCol) {
			if(bN2.moveValid(fromCol, fromRow, toCol, toRow, 'b'))
				return true;
		}
		else if(wN1.isAlive() && wN1.getRow() == fromRow && wN1.getCol() == fromCol) {
			if(wN1.moveValid(fromCol, fromRow, toCol, toRow, 'w'))
				return true;
		}
		else if(wN2.isAlive() && wN2.getRow() == fromRow && wN2.getCol() == fromCol) {
			if(wN2.moveValid(fromCol, fromRow, toCol, toRow, 'w'))
				return true;
		}
		else if(bB1.isAlive() && bB1.getRow() == fromRow && bB1.getCol() == fromCol) {
			if(bB1.moveValid(fromCol, fromRow, toCol, toRow, 'b'))
				return true;
		}
		else if(bB2.isAlive() && bB2.getRow() == fromRow && bB2.getCol() == fromCol) {
			if(bB2.moveValid(fromCol, fromRow, toCol, toRow, 'b'))
				return true;
		}
		else if(wB1.isAlive() && wB1.getRow() == fromRow && wB1.getCol() == fromCol) {
			if(wB1.moveValid(fromCol, fromRow, toCol, toRow, 'w'))
				return true;
		}
		else if(wB2.isAlive() && wB2.getRow() == fromRow && wB2.getCol() == fromCol) {
			if(wB2.moveValid(fromCol, fromRow, toCol, toRow, 'w'))
				return true;
		}
		else if(bp1.isAlive() && bp1.getRow() == fromRow && bp1.getCol() == fromCol) {
			System.out.println("Here");
			if(bp1.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(bp2.isAlive() && bp2.getRow() == fromRow && bp2.getCol() == fromCol) {
			if(bp2.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(bp3.isAlive() && bp3.getRow() == fromRow && bp3.getCol() == fromCol) {
			if(bp3.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(bp4.isAlive() && bp4.getRow() == fromRow && bp4.getCol() == fromCol) {
			if(bp4.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(bp5.isAlive() && bp5.getRow() == fromRow && bp5.getCol() == fromCol) {
			if(bp5.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(bp6.isAlive() && bp6.getRow() == fromRow && bp6.getCol() == fromCol) {
			if(bp6.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(bp7.isAlive() && bp7.getRow() == fromRow && bp7.getCol() == fromCol) {
			if(bp7.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(bp8.isAlive() && bp8.getRow() == fromRow && bp8.getCol() == fromCol) {
			if(bp8.moveValid(fromCol, fromRow, toCol, toRow, 'b') || pawnAttack(fromRow, fromCol, toRow, toCol, 'b'))
				return true;
		}
		else if(wp1.isAlive() && wp1.getRow() == fromRow && wp1.getCol() == fromCol) {
			if(wp1.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w'))
				return true;
		}
		else if(wp2.isAlive() && wp2.getRow() == fromRow && wp2.getCol() == fromCol) {
			if(wp2.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w')) 
				return true;
		}
		else if(wp3.isAlive() && wp3.getRow() == fromRow && wp3.getCol() == fromCol) {
			if(wp3.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w'))
				return true;
		}
		else if(wp4.isAlive() && wp4.getRow() == fromRow && wp4.getCol() == fromCol) {
			if(wp4.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w'))
				return true;
		}
		else if(wp5.isAlive() && wp5.getRow() == fromRow && wp5.getCol() == fromCol) {
			if(bp5.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w'))
				return true;
		}
		else if(wp6.isAlive() && wp6.getRow() == fromRow && wp6.getCol() == fromCol) {
			if(wp6.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w')) 
				return true;
		}
		else if(wp7.isAlive() && wp7.getRow() == fromRow && wp7.getCol() == fromCol) {
			if(wp7.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w')) 
				return true;
				
		}
		else if(wp8.isAlive() && wp8.getRow() == fromRow && wp8.getCol() == fromCol) {
			if(wp8.moveValid(fromCol, fromRow, toCol, toRow, 'w') || pawnAttack(fromRow, fromCol, toRow, toCol, 'w'))
				return true;
		}
		
		return false;
	}
	
	/**
	 * This method checks if moving the king will cause that king to be under check from opposition
	 * 
	 * @param fromRow The index of the current row
	 * @param fromCol The index of the current column
	 * @param toRow The index of the target row
	 * @param toCol The index of the target column
	 * @param player Which player's move it is
	 * @return boolean This returns true if the proposed move on the king will cause that king to be under check
	 */
	public boolean isCheck(int fromRow, int fromCol, int toRow, int toCol, char player) {
		//Checks if the proposed move on the king will cause a check
		
		if(player == 'b') {
			if(canAttack('w', toRow, toCol))
				return true;
		}
		
		if(player == 'w') {
			if(canAttack('b', toRow, toCol))
				return true;
		}
		
		
		return false;
	}
	
	/**
	 * This method checks if any of the opposition's pieces can attack a given position. This method is used to check if moving the king will cause it to be under
	 * check
	 * @param player The opposition of the player who's move it is
	 * @param row  Index of the target row
	 * @param col  Index of the target column
	 * @return boolean This returns true if any of the opposing player's pieces can attack the given location
	 */
	public boolean canAttack(char player, int row, int col) {
		//Checks if any of the player's pieces can attack a specified position
		if(player == 'b') {
			//if(pieceMoveValid(bK.getRow(), bK.getCol(), row, col))
			//	return true;
			if(pieceMoveValid(bQ.getRow(), bQ.getCol(), row, col))
				return true;
			if(pieceMoveValid(bR1.getRow(), bR1.getCol(), row, col))
				return true;
			if(pieceMoveValid(bR2.getRow(), bR2.getCol(), row, col))
				return true;
			if(pieceMoveValid(bN1.getRow(), bN1.getCol(), row, col))
				return true;
			if(pieceMoveValid(bN2.getRow(), bN2.getCol(), row, col))
				return true;
			if(pieceMoveValid(bB1.getRow(), bB1.getCol(), row, col))
				return true;
			if(pieceMoveValid(bB2.getRow(), bB2.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp1.getRow(), bp1.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp2.getRow(), bp2.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp3.getRow(), bp3.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp4.getRow(), bp4.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp5.getRow(), bp5.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp6.getRow(), bp6.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp7.getRow(), bp7.getCol(), row, col))
				return true;
			if(pieceMoveValid(bp8.getRow(), bp8.getCol(), row, col))
				return true;
			
		}
		
		if(player == 'w') {
			//if(pieceMoveValid(wK.getRow(), wK.getCol(), row, col))
			//	return true;
			if(pieceMoveValid(wQ.getRow(), wQ.getCol(), row, col))
				return true;
			if(pieceMoveValid(wR1.getRow(), wR1.getCol(), row, col))
				return true;
			if(pieceMoveValid(wR2.getRow(), wR2.getCol(), row, col))
				return true;
			if(pieceMoveValid(wN1.getRow(), wN1.getCol(), row, col))
				return true;
			if(pieceMoveValid(wN2.getRow(), wN2.getCol(), row, col))
				return true;
			if(pieceMoveValid(wB1.getRow(), wB1.getCol(), row, col))
				return true;
			if(pieceMoveValid(wB2.getRow(), wB2.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp1.getRow(), wp1.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp2.getRow(), wp2.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp3.getRow(), wp3.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp4.getRow(), wp4.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp5.getRow(), wp5.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp6.getRow(), wp6.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp7.getRow(), wp7.getCol(), row, col))
				return true;
			if(pieceMoveValid(wp8.getRow(), wp8.getCol(), row, col))
				return true;
		}
		
		return false;
	}
	
	
	/**
	 * This method checks if a path from a given location to the target location is blocked by a piece
	 * 
	 * @param fromRow Index of current row
	 * @param fromCol Index of current column
	 * @param toRow  Index of target row
	 * @param toCol  Index of target column
	 * @return boolean This returns true if a path from the current location to the target location is blocked
	 */
	public boolean isBlocked(int fromRow, int fromCol, int toRow, int toCol) {
		//Checks if the path on which a piece has to travel to get to target location is blocked by any piece
		
		
		if((bQ.isAlive() && bQ.getRow() == fromRow && bQ.getCol() == fromCol) || (wQ.isAlive() && wQ.getRow() == fromRow && wQ.getCol() == fromCol)) {
			//Checks the directions below the fromRow (if the target is in that direction) if they are blocked
			if(toRow > fromRow) {
				if(toCol > fromCol) {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i++, j++) {
						if(pieces[i][j] != null)
							return true;
					}
				}
				else if(toCol == fromCol) {
					for(int i = fromRow; i != toRow; i++) {
						if(pieces[i][fromCol] != null)
							return true;
					}
				}
				else {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i++, j--) {
						if(pieces[i][j] != null)
							return true;
					}
				}
			}
			//Checks the right and left directions for blockage
			else if(toRow == fromRow) {
				if(toCol > fromCol) {
					for(int j = fromCol; j != toCol; j++) {
						if(pieces[fromRow][j] != null)
							return true;
					}		
				}
				else {
					for(int j = fromCol; j != toCol; j--) {
						if(pieces[fromRow][j] != null)
							return true;
					}
				}
			}
			//Checks the directions above the fromRow if they are blocked
			else {
				if(toCol > fromCol) {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i--, j++) {
						if(pieces[i][j] != null)
							return true;
					}
				}
				else if(toCol == fromCol) {
					for(int i = fromRow; i != toRow; i--) {
						if(pieces[i][fromCol] != null)
							return true;
					}
				}
				else {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i--, j--) {
						if(pieces[i][j] != null)
							return true;
					}
				}
			}
		}
		
		else if((bR1.isAlive() && bR1.getRow() == fromRow && bR1.getCol() == fromCol) || (bR2.isAlive() && bR2.getRow() == fromRow && bR2.getCol() == fromCol) ||
			(wR1.isAlive() && wR1.getRow() == fromRow && wR1.getCol() == fromCol) || (wR2.isAlive() && wR2.getRow() == fromRow && wR2.getCol() == fromCol)) {
			
			if(fromRow != toRow) {
				if(toRow > fromRow) {
					for(int i = fromRow; i != toRow; i++) {
						if(pieces[i][fromRow] != null)
							return true;
					}
				}
				else {
					for(int i = fromRow; i != toRow; i--) {
						if(pieces[i][fromRow] != null)
							return true;
					}
				}
			}
			else{
				if(toCol > fromCol) {
					for(int j = fromCol; j != toCol; j++) {
						if(pieces[fromRow][j] != null)
							return true;
					}
				}
				else {
					for(int j = fromCol; j != toCol; j--) {
						if(pieces[fromRow][j] != null)
							return true;
					}
				}
			}
		}
		
		else if((bB1.isAlive() && bB1.getRow() == fromRow && bB1.getCol() == fromCol) || (bB2.isAlive() && bB2.getRow() == fromRow && bB2.getCol() == fromCol) ||
				(wB1.isAlive() && wB1.getRow() == fromRow && wB1.getCol() == fromCol) || (wB2.isAlive() && wB2.getRow() == fromRow && wB2.getCol() == fromCol)) {
			
			if(toRow > fromRow) {
				if(toCol > fromCol) {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i++, j++) {
						if(pieces[i][j] != null)
							return true;
					}
				}
				else {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i++, j--) {
						if(pieces[i][j] != null)
							return true;
					}
				}
			}
			else {
				if(toCol > fromCol) {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i--, j++) {
						if(pieces[i][j] != null)
							return true;
					}
				}
				else {
					for(int i = fromRow, j = fromCol; i != toRow && j != toCol; i--, j++) {
						if(pieces[i][j] != null)
							return true;
					}
				}
			}
			
		}
		
		else if(bp1.isAlive() && bp1.getRow() == fromRow && bp1.getCol() == fromCol) {
			if(bp1.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		}
		else if(bp2.isAlive() && bp2.getRow() == fromRow && bp2.getCol() == fromCol) {
			if(bp2.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null|| pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		
		}
		else if(bp3.isAlive() && bp3.getRow() == fromRow && bp3.getCol() == fromCol) {
			if(bp3.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null|| pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		}
		else if(bp4.isAlive() && bp4.getRow() == fromRow && bp4.getCol() == fromCol) {
			if(bp4.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null|| pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		}
		else if(bp5.isAlive() && bp5.getRow() == fromRow && bp5.getCol() == fromCol) {
			if(bp5.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null|| pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		}
		else if(bp6.isAlive() && bp6.getRow() == fromRow && bp6.getCol() == fromCol) {
			if(bp6.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null|| pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		}
		else if(bp7.isAlive() && bp7.getRow() == fromRow && bp7.getCol() == fromCol) {
			if(bp7.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null|| pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		}
		else if(bp8.isAlive() && bp8.getRow() == fromRow && bp8.getCol() == fromCol) {
			if(bp8.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow + 1][fromCol] != null|| pieces[toRow][toCol] != null)
					return true;
			}else if(pieces[toRow][toCol] != null) {
					return true;
			}
		}
		else if(wp1.isAlive() && wp1.getRow() == fromRow && wp1.getCol() == fromCol) {
			if(wp1.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		}
		else if(wp2.isAlive() && wp2.getRow() == fromRow && wp2.getCol() == fromCol) {
			if(wp2.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		
		}
		else if(wp3.isAlive() && wp3.getRow() == fromRow && wp3.getCol() == fromCol) {
			if(wp3.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		
		}
		else if(wp4.isAlive() && wp4.getRow() == fromRow && wp4.getCol() == fromCol) {
			if(wp4.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		}
		else if(wp5.isAlive() && wp5.getRow() == fromRow && wp5.getCol() == fromCol) {
			if(wp5.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		}
		else if(wp6.isAlive() && wp6.getRow() == fromRow && wp6.getCol() == fromCol) {
			if(wp6.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		}
		else if(wp7.isAlive() && wp7.getRow() == fromRow && wp7.getCol() == fromCol) {
			if(wp7.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		}
		else if(wp8.isAlive() && wp8.getRow() == fromRow && wp8.getCol() == fromCol) {
			if(wp8.initPos == true && Math.abs(fromRow - toRow) == 2) {
				if(pieces[fromRow - 1][fromCol] != null || pieces[toRow][toCol] != null)
					return true;
				}else if(pieces[toRow][toCol] != null) {
					return true;
				}
		}
		
		
		
		return false;
	}
	
	/**
	 * This method figures out if the pawn is trying to attack and if it is a valid move
	 * 
	 * @param fromRow Index of the current row
	 * @param fromCol Index of the current column
	 * @param toRow Index of the target row
	 * @param toCol Index of the target column
	 * @param player Which player's turn it is
	 * @return This returns true if the pawn is trying to attack a piece and if it is a valid move
	 */
	
	public boolean pawnAttack(int fromRow, int fromCol, int toRow, int toCol, char player) {
		
		if(player == 'b') {
			if(fromCol != toCol) {
				if(pieces[toRow][toCol] == null)
					return false;
			
				if(whiteLayout[toRow][toCol])
					return true;
			
			}
		}
		
		if(player == 'w') {
			if(fromCol != toCol) {
				if(pieces[toRow][toCol] == null)
					return false;
			
				if(blackLayout[toRow][toCol])
					return true;
			
			}
		}
		
		return false;
	}
	
	/**
	 * This method handles the actual moving of the piece. It alters the arrays accordingly. It also checks if moving a piece captures an opposing piece and calls
	 * the captured method. Then it checks if the move causes the opposition to be under check.
	 * @param input The input from the user
	 */
	public void move(String input) {
		//only called if move is valid
		
		//break up the input
		char fromColstr = input.charAt(0);
		char toColstr = input.charAt(3);				
		
		//get the column index
		int fromCol = colIndex(fromColstr);
		int toCol = colIndex(toColstr);
				
		//get the row index
		int fromRow = Math.abs((Character.getNumericValue((input.charAt(1)))) - 8);
		int toRow = Math.abs((Character.getNumericValue((input.charAt(4)))) - 8);
		
		//check which piece we are moving and then call move method and alter the arrays and check if it is causing a check for the opposition
		
		if(bK.isAlive() && bK.getRow() == fromRow && bK.getCol() == fromCol) {
			bK.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bK";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
			
		}
		
		if(wK.isAlive() && wK.getRow() == fromRow && wK.getCol() == fromCol) {
			wK.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wK";
			
			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
		
				
		if(bQ.isAlive() && bQ.getRow() == fromRow && bQ.getCol() == fromCol) {
			bQ.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bQ";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
		}
		
		
		if(wQ.isAlive() && wQ.getRow() == fromRow && wQ.getCol() == fromCol) {
			wQ.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wQ";
			
			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
			
		if(bR1.isAlive() && bR1.getRow() == fromRow && bR1.getCol() == fromCol) {
			bR1.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bR";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
		}
		
		if(bR2.isAlive() && bR2.getRow() == fromRow && bR2.getCol() == fromCol) {
			bR2.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bR";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
		}
		
		if(wR1.isAlive() && wR1.getRow() == fromRow && wR1.getCol() == fromCol) {
			wR1.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wR";

			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
		
		if(wR2.isAlive() && wR2.getRow() == fromRow && wR2.getCol() == fromCol) {
			wR2.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wR";
			
			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
		
		if(bN1.isAlive() && bN1.getRow() == fromRow && bN1.getCol() == fromCol) {
			bN1.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wN";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
		}
		
		if(bN2.isAlive() && bN2.getRow() == fromRow && bN2.getCol() == fromCol) {
			bN2.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wN";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
		}
		
		if(wN1.isAlive() && wN1.getRow() == fromRow && wN1.getCol() == fromCol) {
			wN1.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bN";
			
			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
		
		if(wN2.isAlive() && wN2.getRow() == fromRow && wN2.getCol() == fromCol) {
			wN2.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bN";
			
			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
		
		if(bB1.isAlive() && bB1.getRow() == fromRow && bB1.getCol() == fromCol) {
			bB1.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bB";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
		}
		
		if(bB2.isAlive() && bB2.getRow() == fromRow && bB2.getCol() == fromCol) {
			bB2.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bB";
			
			if(pieceMoveValid(toRow, toCol, wK.getRow(), wK.getCol()))
				System.out.println("Check");
		}
		
		if(wB1.isAlive() && wB1.getRow() == fromRow && wB1.getCol() == fromCol) {
			wB1.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wB";
			
			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
		
		if(wB2.isAlive() && wB2.getRow() == fromRow && wB2.getCol() == fromCol) {
			wB2.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wB";
			
			if(pieceMoveValid(toRow, toCol, bK.getRow(), bK.getCol()))
				System.out.println("Check");
		}
			
		if(bp1.isAlive() && bp1.getRow() == fromRow && bp1.getCol() == fromCol) {
			bp1.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(bp2.isAlive() && bp2.getRow() == fromRow && bp2.getCol() == fromCol) {
			bp2.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(bp3.isAlive() && bp3.getRow() == fromRow && bp3.getCol() == fromCol) {
			bp3.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(bp4.isAlive() && bp4.getRow() == fromRow && bp4.getCol() == fromCol) {
			bp4.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(bp5.isAlive() && bp5.getRow() == fromRow && bp5.getCol() == fromCol) {
			bp5.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(bp6.isAlive() && bp6.getRow() == fromRow && bp6.getCol() == fromCol) {
			bp6.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(bp7.isAlive() && bp7.getRow() == fromRow && bp7.getCol() == fromCol) {
			bp7.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(bp8.isAlive() && bp8.getRow() == fromRow && bp8.getCol() == fromCol) {
			bp8.move(toRow, toCol);
			blackLayout[fromRow][fromCol] = false;
			blackLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "bp";
			
			if(pawnAttack(toRow, toCol, wK.getRow(), wK.getCol(), 'b'))
				System.out.println("Check");
		}
		
		if(wp1.isAlive() && wp1.getRow() == fromRow && wp1.getCol() == fromCol) {
			wp1.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		if(wp2.isAlive() && wp2.getRow() == fromRow && wp2.getCol() == fromCol) {
			wp2.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		if(wp3.isAlive() && wp3.getRow() == fromRow && wp3.getCol() == fromCol) {
			wp3.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		if(wp4.isAlive() && wp4.getRow() == fromRow && wp4.getCol() == fromCol) {
			wp4.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		if(wp5.isAlive() && wp5.getRow() == fromRow && wp5.getCol() == fromCol) {
			wp5.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		if(wp6.isAlive() && wp6.getRow() == fromRow && wp6.getCol() == fromCol) {
			wp6.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		if(wp7.isAlive() && wp7.getRow() == fromRow && wp7.getCol() == fromCol) {
			wp7.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		if(wp8.isAlive() && wp8.getRow() == fromRow && wp8.getCol() == fromCol) {
			wp8.move(toRow, toCol);
			whiteLayout[fromRow][fromCol] = false;
			whiteLayout[toRow][toCol] = true;
			pieces[fromRow][fromCol] = null;
			if(pieces[toRow][toCol] != null)
				captured(pieces[toRow][toCol]);
			pieces[toRow][toCol] = "wp";
			
			if(pawnAttack(toRow, toCol, bK.getRow(), bK.getCol(), 'w'))
				System.out.println("Check");
		}
		
		
		
	}
	
	/**
	 * This method is called when a piece is captured. It changes the isAlive field of the captured piece and changes the blackLayout/whiteLayout array accordingly
	 * @param s The string of the piece that is captured from the pieces array
	 */
	public void captured(String s) {
		//Sets the captured piece as dead and changes necessary arrays
		
		if(s.equals("bK")) {
			bK.isAlive = false;
			blackLayout[bK.getRow()][bK.getCol()] = false;
		}
		else if(s.equals("wK")) {
			wK.isAlive = false;
			whiteLayout[wK.getRow()][wK.getCol()] = false;
		}
		else if(s.equals("bQ")) {
			bQ.isAlive = false;
			blackLayout[bQ.getRow()][bQ.getCol()] = false;
		}
		else if(s.equals("wQ")) {
			wQ.isAlive = false;
			whiteLayout[wQ.getRow()][wQ.getCol()] = false;
		}
		else if(s.equals("bR1")) {
			bR1.isAlive = false;
			blackLayout[bR1.getRow()][bR1.getCol()] = false;
		}
		else if(s.equals("bR2")) {
			bR1.isAlive = false;
			blackLayout[bR2.getRow()][bR2.getCol()] = false;
		}
		else if(s.equals("wR1")) {
			wR1.isAlive = false;
			whiteLayout[wR1.getRow()][wR1.getCol()] = false;
		}
		else if(s.equals("wR2")) {
			wR2.isAlive = false;
			whiteLayout[wR2.getRow()][wR2.getCol()] = false;
		}
		else if(s.equals("bN1")) {
			bN1.isAlive = false;
			blackLayout[bN1.getRow()][bN1.getCol()] = false;
		}
		else if(s.equals("bN2")) {
			bN2.isAlive = false;
			blackLayout[bN2.getRow()][bN2.getCol()] = false;
		}
		else if(s.equals("wN1")) {
			wN1.isAlive = false;
			whiteLayout[wN1.getRow()][wN1.getCol()] = false;
		}
		else if(s.equals("wN2")) {
			wN2.isAlive = false;
			whiteLayout[wN2.getRow()][wN2.getCol()] = false;
		}
		else if(s.equals("bB1")) {
			bB1.isAlive = false;
			blackLayout[bB1.getRow()][bB1.getCol()] = false;
		}
		else if(s.equals("bB2")) {
			bB2.isAlive = false;
			blackLayout[bB2.getRow()][bB2.getCol()] = false;
		}
		else if(s.equals("wB1")) {
			wB1.isAlive = false;
			whiteLayout[wB1.getRow()][wB1.getCol()] = false;
		}
		else if(s.equals("wB2")) {
			wB2.isAlive = false;
			whiteLayout[wB2.getRow()][wB2.getCol()] = false;
		}
		else if(s.equals("bp1")) {
			bp1.isAlive = false;
			blackLayout[bp1.getRow()][bp1.getCol()] = false;
		}
		else if(s.equals("bp2")) {
			bp2.isAlive = false;
			blackLayout[bp2.getRow()][bp2.getCol()] = false;
		}
		else if(s.equals("bp3")) {
			bp3.isAlive = false;
			blackLayout[bp3.getRow()][bp3.getCol()] = false;
		}
		else if(s.equals("bp4")) {
			bp4.isAlive = false;
			blackLayout[bp4.getRow()][bp4.getCol()] = false;
		}
		else if(s.equals("bp5")) {
			bp5.isAlive = false;
			blackLayout[bp5.getRow()][bp5.getCol()] = false;
		}
		else if(s.equals("bp6")) {
			bp6.isAlive = false;
			blackLayout[bp6.getRow()][bp6.getCol()] = false;
		}
		else if(s.equals("bp7")) {
			bp7.isAlive = false;
			blackLayout[bp7.getRow()][bp7.getCol()] = false;
		}
		else if(s.equals("bp8")) {
			bp8.isAlive = false;
			blackLayout[bp8.getRow()][bp8.getCol()] = false;
		}
		else if(s.equals("wp1")) {
			wp1.isAlive = false;
			whiteLayout[wp1.getRow()][wp1.getCol()] = false;
		}
		else if(s.equals("wp2")) {
			wp2.isAlive = false;
			whiteLayout[wp2.getRow()][wp2.getCol()] = false;
		}
		else if(s.equals("wp3")) {
			wp3.isAlive = false;
			whiteLayout[wp3.getRow()][wp3.getCol()] = false;
		}
		else if(s.equals("wp4")) {
			wp4.isAlive = false;
			whiteLayout[wp4.getRow()][wp4.getCol()] = false;
		}
		else if(s.equals("wp5")) {
			wp5.isAlive = false;
			whiteLayout[wp5.getRow()][wp5.getCol()] = false;
		}
		else if(s.equals("wp6")) {
			wp6.isAlive = false;
			whiteLayout[wp6.getRow()][wp6.getCol()] = false;
		}
		else if(s.equals("wp7")) {
			wp7.isAlive = false;
			whiteLayout[wp7.getRow()][wp7.getCol()] = false;
		}
		else if(s.equals("wp8")) {
			wp8.isAlive = false;
			whiteLayout[wp8.getRow()][wp8.getCol()] = false;
		}
		
			
	}
	
	/**
	 * This method is used to calculate the index value from a letter array
	 * @param col Which letter column the player wants to alter
	 * @return int The index equivalent of that letter
	 */
	public int colIndex(char col) {
		char[] cols = "abcdefgh".toCharArray();
		int i = 0;
		
		while(i < 8) { 
			if(col == cols[i])
				return i;
			i++;
		}
		return 8;
	}
	
	
}