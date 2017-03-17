import java.util.*;

 class Game{

	private char[][] board;
	public char currentPlayerMark;

	// Constructor Call
	public Game(){
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
		System.out.println("-------------");

		for(int i=0; i<3;i++){
			System.out.print("| ");
			for(int j=0; j<3; j++){
				System.out.print(board[i][j] + " | ");
			}
		System.out.println();
		System.out.println("-------------");
		}
	}

	// Loop through all cells of the board and if one is found to be empty then resturn false
	// Otherwise return true i.e board is full
	public boolean isBoardFull(){

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == '-') return false;
			}
		}
		return true;
	}

	// Check for Win
	public boolean checkForWin(){
		return (checkRowsForWin() || checkColsForWin() || checkDiagsForWin());
	}

	// Loop through rows to check for winners
	private boolean checkRowsForWin(){
		for(int i=0;i<3;i++){
			if(checkRowCol(board[i][0],board[i][1],board[i][2]) == true) return true;
		}
		return false;
	}

	// Loop through cols to check for winners
	private boolean checkColsForWin(){
		for(int i=0;i<3;i++){
			if(checkRowCol(board[0][i],board[1][i],board[2][i]) == true) return true;
		}
		return false;
	}

	// Check two diagonals for winner
	private boolean checkDiagsForWin(){
		return ((checkRowCol(board[0][0],board[1][1],board[2][2]) == true) || (checkRowCol(board[0][2],board[1][1],board[2][0]) == true) );
	}

	// Check if all the three values are same
	private boolean checkRowCol(char c1, char c2, char c3){
		return ((c1 != '-') && (c1 ==  c2) && (c2 == c3));
	}

	// Change Turns
	public void changePlayer(){
		if (currentPlayerMark == 'x'){
			currentPlayerMark = 'o';
		}
		else {
			currentPlayerMark = 'x';
		}
	}

	// Place a mark of the current player at given row and col
	public boolean placeMark(int row, int col){
		if ((row >= 1) && (row <= 3)){
			if ((col >= 1) && (col <= 3)){
				if(board[row-1][col-1] == '-'){
					board[row-1][col-1] = currentPlayerMark;
					return true;
				}
			}
		}
		return false;
	}
}

class TicTacToe{
	public static void main(String[] args){
		Game game = new Game();
		game.printBoard();
		int row = -1;
		int col = -1;
		int turnsFinished = 0;
		Scanner sc = new Scanner(System.in);
		while(game.isBoardFull() == false && game.checkForWin() == false){
			if (turnsFinished % 2 == 0) System.out.println("Place Mark Player 1:");
			else System.out.println("Place Mark Player 2:");
			turnsFinished++;
			System.out.print("row = ");
			row = sc.nextInt();
			System.out.print("col = ");
			col = sc.nextInt();
			game.placeMark(row,col);
			game.printBoard();
			if (game.isBoardFull() == false && game.checkForWin() == false)
				{
					game.changePlayer();
				}
		}

		if(game.checkForWin()){
			System.out.println ("!!! We have a Winner !!!");
			if (game.currentPlayerMark == 'x') System.out.println("Winner is Player 1 ");
			else System.out.println ("Winner is Player 2");
			System.exit(0);
		}
		else if (game.isBoardFull()){
			System.out.println(" The Game Ended in a Tie ");
			System.exit(0);
		}
	}
}
