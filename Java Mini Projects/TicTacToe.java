import java.util.*;

public class TicTacToe{

	private char[][] board;
	private char currentPlayerMark;

	// Constructor Call
	public TicTacToe(){
		board = new char[3][3];
		currentPlayerMark = 'x';
		initializeBoard();
	}

	// Initialize the board
	public void initializeBoard(){

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				board[i][j] = '-';
			}
		}
	}

	public void printBoard(){
		System.out.println("######################");

		for(int i=0; i<3;i++){
			System.out.print("| ");
		}
		System.out.println();
		System.out.println("######################");
	}
}