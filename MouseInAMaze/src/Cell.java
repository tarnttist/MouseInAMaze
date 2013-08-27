
public class Cell {
	String position;
	int reward;
	
	Cell(String p, int w){
		position = p;
		reward = w;
	}
	
	void displayPos(){
		System.out.print(position);
	}
}
