
public class Grid {
	
	public static final int ROWS = 9;
	public static final int COLS = 9;
	
	Cell[][] aGrid;
	int currentRow, currentCol;
	
	public Grid(){
		char alp = 'A';
		aGrid = new Cell[ROWS][COLS];
		for(int row=1; row<=ROWS; row++){
			for(int col=1; col<=COLS; col++){
				aGrid[row][col] = new Cell(row,alp);
			}
			alp++;
		}
	}
	
}
