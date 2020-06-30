
/**
 * Class BoardGame represents board game where snake moves around eating apples
 * @author Rena Li
 * @date June 4, 2020
 */

public class BoardGame {
	
	//private instance variables
	private int board_length; // number of columns of the grid on the board
	private int board_width; // number of rows on the grid
	private Snake theSnake; // object representing the playing snake
	private String[][] matrix; // 2d matrix storing content of each square
	
	/*
	 * Constructor
	 */
	public BoardGame(String boardFile){
		
		MyFileReader in = new MyFileReader(boardFile);
		// MISTAKE: HOW TO USE MY FILE READER
		
		in.readInt(); // ignore first two integers
		in.readInt();
		
		board_length = in.readInt();
		board_width = in.readInt();
		
		theSnake = new Snake(in.readInt(), in.readInt());
		
		matrix = new String[board_width][board_length]; // create new 2d array with given dimensions
		//MISTAKE
		
		for (int i = 0; i < board_width; i++) { // store each entry with string "empty"
			for (int j = 0; j < board_length; j++) {
				matrix[i][j] = "empty";
			}
		}
		
		while (in.endOfFile() == false) { // for rest of file, triplets of row #, col # and string 
			matrix[in.readInt()][in.readInt()] = in.readString(); // store string in given array space 
		}
	}
	
	public String getObject(int row, int col) {
		String string = matrix[row][col]; // ???? difference b/w getObject and getType...
		return string;
	}
	
	public void setObject(int row, int col, String newObject) {
		matrix[row][col] = newObject;
	}
	
	public Snake getSnake(){
		return theSnake;
	}
		
	public void setSnake(Snake newSnake) {
		theSnake = newSnake;
	}
	
	public int getLength() {
		return board_length;
	}
	
	public int getWidth() {
		return board_width;
	}
	
	public String getType(int row, int col) {
		return matrix[row][col];
	}
}
