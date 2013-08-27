
public class Cell {
	String position;
	int reward;
	
	public Cell(int row, char col){
		String strrow = Integer.toString(row);
		position = strrow+col;
	}
	
	void displayPos(){
		System.out.print(position);
	}
}
