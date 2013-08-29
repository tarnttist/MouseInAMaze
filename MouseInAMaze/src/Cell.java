public class Cell {
	public static final int SIZE = 9;
	
	public int row;
	public int col;
	public String position;
	public int reward;
	public boolean isTrap;
	public boolean visited = false;
	
	public Cell(){}
	
	public Cell(String p){
		position = p;
		String tmp = position.substring(0,1);
		row = Integer.parseInt(tmp)-1;
		char tmpc = position.charAt(1);
		char c = 'A';
		
		for(int i=0;i<SIZE;i++){
			if(c==tmpc){
				col = i;
				break;
			}
			c++;
		}
	}
	
	public Cell(int r, int c, int w){
		row = r+1;
		col = c;
		reward = w;
		String strrow = Integer.toString(row);
		char cc = 'A';
		for(int i=0;i<SIZE;i++){
			if(col==i){
				position = strrow.concat(Character.toString(cc));
				break;
			}
			cc++;
		}
	}
	
	public void setTrap(){
		isTrap = true;
	}
	
	public void setReward(int rw){
		reward = rw;
	}
	
}
