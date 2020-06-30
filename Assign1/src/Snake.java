/**
 * Class Snake stores information about snake as it moves around the board
 * @author Rena Li
 * @date June 12
 *
 */
public class Snake {
	
	int snakeLength; // number of grid squares the snake occupies
	Position[] snakeBody; // grid squares occupied by snake will be stored in this array; head stored at index 0 and tail stored at snakeLength - 1
	
	/*
	 * Constructor Snake
	 * @param are coordinates of head
	 */
	public Snake(int row, int col){
		snakeLength = 1;
		snakeBody = new Position[5]; // initializaed to array of 5
		Position obj = new Position(row, col); // object of class position storing values row and col
		snakeBody[0] = obj; // obj stored in first entry of array SnakeBody	
	}

	public int getLength() {
		return snakeLength;
	}

	Position getPosition(int index) {
		if (index < 0 || index >= snakeLength) {
			// MISTAKE: index >= (CARELESS)
			return null;
		}
		return snakeBody[index];
	}
	
	public void shrink() {
		snakeLength = snakeLength - 1;
	}
	
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < snakeLength; i++) {
			if (snakeBody[i].equals(pos)) {
				return true;
			}
		}
		return false;
	}
	
	public Position newHeadPosition(String direction) {
		// MISTAKE!!!: need to create way to return new Posito=ion
		int row = snakeBody[0].getRow();
		int col = snakeBody[0].getCol();	
		Position newHeadPos = new Position(row, col); // object "newHeadPos" store and return new position of head of snake when moved
		
		if (direction == "up") {
			row = row - 1;
			newHeadPos.setRow(row);
	
		}
		else if (direction == "down") {
			row = row + 1;
			newHeadPos.setRow(row);
		}
		else if (direction == "right") {
			col = col + 1;
			newHeadPos.setCol(col);

		}
		else if (direction == "left") {
			col = col - 1;
			newHeadPos.setCol(col);
		}
		return newHeadPos;
	}
	//BIGGEST MISTAKE!!!!! : FOR METHODS MOVESNAKE & GROW, THE FOR LOOP MUST START FROM
	// END (NEW, EMPTY ARRAY SPACE) TO FRONT; OR ELSE YOU ARE LOSING THE DATA STORED 
	public void moveSnake(String direction) {
		for (int i = snakeLength - 2; i >= 0; i--) {
			snakeBody[i+1] = snakeBody[i];
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	
	public void grow(String direction) {
		snakeLength = snakeLength + 1;
		//MISTAKE: CARELESS, FORGOT TO DO THIS STEP (+1)
		
		if (snakeLength == snakeBody.length) {
			increaseArraySize();
		}
		for (int i = snakeLength - 1; i >= 0; i--) {
			snakeBody[i+1] = snakeBody[i];
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	
	
	private void increaseArraySize() {
		Position[] temp = new Position[snakeBody.length * 2];
		
		for (int i = 0; i < snakeLength; i++) {
			temp[i] = snakeBody[i];
		}
		snakeBody = temp;
	}
}
