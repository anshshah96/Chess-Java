package chess;
import java.util.Scanner;


/**
 * The Chess Program implements the game of Chess.
 * 
 * 
 * @author Ansh Shah, Kandarp Patel
 *
 */
public class Chess {

	/**
	 * The main method handles the inputs from the player and performs actions accordingly
	 * 
	 * @param args Unused
	 * @return Nothing
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Board b = new Board();
		
		int counter = 0;
		String input = null;
		boolean gameOver = false;
		
		while(gameOver == false) {
			if(counter % 2 == 0) {
				System.out.print("White's move: ");
				input = sc.nextLine();
				if(input.equals("resign")) {
					System.out.println("Black wins");
					gameOver = true;
					break;
				}
				if(input.contains("draw?")) {
					counter++;
					continue;
				}
					
				
				if(input.equals("draw")) {
					gameOver = true;
					break;
				}
					
				
				if(b.validMove('w', input) == false) {
					System.out.println("Illegal move, try again");
					continue;
				}
				
				b.move(input);
				b.draw();
				
			}
			else {
				System.out.print("Black's move: ");
				input = sc.nextLine();
				if(input.equals("resign")) {
					System.out.println("White wins");
					gameOver = true;
					break;
				}
				
				if(input.contains("draw?")) {
					counter++;
					continue;
				}
				
				if(input.equals("draw")) {
					gameOver = true;
					break;
				}
				
				if(b.validMove('b', input) == false) {
					System.out.println("Illegal move, try again");
					continue;
				}
				
				b.move(input);
				b.draw();
					
			}
				
			counter++;
		}
	}
	


}
