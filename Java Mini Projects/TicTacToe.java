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

	// Loop through all cells of the board and if one is found to be empty then resturn false
	// Otherwise return true i.e board is full
	public boolean isBoardFull(){
		boolean isFUll = true;

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == '-') return false;
			}
		}
		return true;
	}

	// Check for Win
	public boolean checkForWin(){
		return (checkRowsForWin() || checkColsForWin() || checkDiagForWin());
	}

}