import java.util.*;
import java.io.*;

public class Maze {
	public static final int SIZE = 9;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	public static final int LEFT = 4;

	int rows;	//Number of rows in a maze
	int cols;	//Number of columns in a maze
	Cell[][] aGrid;
	Cell mouse;
	Cell cheese;
	String[] traps;
	int[][] rewards;

	public static void main(String arg[]){
		Cell[][] aGrid = new Cell[SIZE][SIZE];
		Cell mouse = new Cell("3D");
		Cell cheese = new Cell("8G");

		Maze myMaze = new Maze();
		myMaze.createMaze(aGrid);
		myMaze.solveDFS(aGrid, mouse, cheese);
		myMaze.solveBestFS(aGrid, mouse, cheese);
//		for(int r=0; r<9; r++){
//			for(int c=0; c<9; c++){
//				System.out.print(aGrid[r][c].reward);
//				System.out.print("\t");
//			}
//			System.out.println();
//		}


	}

	public void createMaze(Cell[][] aGrid){
		int[][] rewards = new int[9][9];
		
		for(int r=0; r<SIZE; r++){
			for(int c=0; c<SIZE; c++){
				aGrid[r][c] = new Cell(r, c, 10);
			}
		}
		
		try
		{
            FileInputStream read = new FileInputStream("C:/Users/CappucinosaN/Downloads/input.txt");
            DataInputStream input = new DataInputStream(read);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String board = "";
            int line = 1;
            	while((board = br.readLine()) != null)
            		{
            			if(line==1)
            			{
            				Cell mouse = new Cell(board);
            			}
            			
            			else if(line==2)
            			{
            				Cell cheese = new Cell(board);
            			}
            			
            			else if(line==3)
            			{
            				traps = board.split(" ");
            				for(int i=0; i<10; i++){
            					for(int r=0; r<9; r++){
            						for(int c=0; c<9; c++){
            							if(isEqual(aGrid[r][c].position,traps[i])){
            								aGrid[r][c].setTrap();
//            								System.out.println(aGrid[r][c].isTrap);
            							}
            						}
            					}
            				}
            			}
            			
            			else
            				{
            					int t;
            					String[] temp = board.split(" ");
            					for(int i=0; i<9;i++)
            					{
            						t = Integer.parseInt(temp[i]);
            						rewards[line-4][i] = t;	
            					}	
            				}
            			
            			line++;
            		}
            	
            		for(int i=0; i<9; i++){
            			for(int j=0;j<9;j++){
            				aGrid[i][j].setReward(rewards[i][j]);
            			}
            		}
		
            
            		input.close();
		}
		
            catch(Exception e)
            {
            	System.out.println("Cannot read a text file:" + e.getMessage());
            }
	}
	public void solveDFS(Cell[][] aGrid, Cell current, Cell dest){
		Stack<Integer> rKeep = new Stack<Integer>();
		Stack<Integer> cKeep = new Stack<Integer>();
		ArrayList<String> sqSearch = new ArrayList<String>();
		ArrayList<String> sPath = new ArrayList<String>();
		int r,c;
		int direction=UP;
		
		rKeep.push(current.row);
		cKeep.push(current.col);
		sqSearch.add(current.position);
		
		while(!rKeep.isEmpty()){
			r = rKeep.peek();
			c = cKeep.peek();

			aGrid[r][c].visited = true;
			
			if(isEqual(current.position, dest.position)){	//end game
				while(!rKeep.isEmpty()){
					r = rKeep.pop();
					c = cKeep.pop();
					String tmpPos = aGrid[r][c].position;
					sPath.add(0, tmpPos);
				}
				int searchSize = sqSearch.size();
				int pathSize = sPath.size();
				for(int i=0; i<searchSize; i++){
					System.out.print(sqSearch.get(i));
					System.out.print(" ");
				}
				System.out.println("");
				for(int i=0; i<pathSize; i++){
					System.out.print(sPath.get(i));
					System.out.print(" ");
				}
				System.out.println("");
			}
			else{
				if(r>0 && 
						aGrid[r-1][c].visited==false && 
						aGrid[r-1][c].isTrap == false ){	//move up
					rKeep.push(r-1);
					cKeep.push(c);
					current = aGrid[r-1][c];
					direction = UP;
					sqSearch.add(current.position);
				}
				else if(c<SIZE-2 && 
						aGrid[r][c+1].visited==false && 
						aGrid[r][c+1].isTrap == false ){	//move right
					rKeep.push(r);
					cKeep.push(c+1);
					current = aGrid[r][c+1];
					direction = RIGHT;
					sqSearch.add(current.position);
				}
				else if(r<SIZE-2 && 
						aGrid[r+1][c].visited==false && 
						aGrid[r+1][c].isTrap == false ){	//move down
					rKeep.push(r+1);
					cKeep.push(c);
					current = aGrid[r+1][c];
					direction = DOWN;
					sqSearch.add(current.position);
				}
				else if(c>0 && 
						aGrid[r][c-1].visited==false && 
						aGrid[r][c-1].isTrap == false ){	//move left
					rKeep.push(r);
					cKeep.push(c-1);
					current = aGrid[r][c-1];
					direction = LEFT;
					sqSearch.add(current.position);
				}
				else{
					int rv = rKeep.pop();
					int cv = cKeep.pop();
					current = aGrid[rv][cv];
				}
			}
		}
	}
	
	public void solveBestFS(Cell[][] aGrid, Cell current, Cell dest){
		Cell tmp = new Cell();
		PriorityQueue<Cell> bQueue = new PriorityQueue<Cell>();
		bQueue.add(current);
		while(!(bQueue.isEmpty())){
			tmp = bQueue.remove();
			if(isEqual(tmp.position, dest.position)){	//A mouse find a cheese 
				
			}
			else{
				
			}
		}
		
	}

	public static boolean isEqual(Object o1, Object o2) {
		return o1 == o2 || (o1 != null && o1.equals(o2));
	}
}
