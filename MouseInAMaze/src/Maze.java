import java.io.*;

public class Maze {
	public String mousePos;
	public String cheesePos;
	public String[] trapPos;
	public int[][] rewards;
	
	public static void main(String arg[]){	
		String mousePos = new String();
		String cheesePos = new String();
		try
		{
            FileInputStream read = new FileInputStream("C:\\Users\\HP\\Desktop\\input.txt");
            DataInputStream input = new DataInputStream(read);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String board = "";
            int line = 1;
            	while((board = br.readLine()) != null)
            		{
            			if(line==1){
            				mousePos = board;
            				System.out.println(mousePos);
            			}
            			if(line==2){
            				cheesePos = board;
            				System.out.println(cheesePos);
            			}
            			
            			if(line==3){
            					String[] trapPos = board.split(" ");
            					System.out.println(trapPos);
            				}
            			line++;
            		}
            			
            			/*if(line==4){
        					String[]  = board.split("\\s+");
        					System.out.println(trapPos[]);
        				}
            				
            			}
            			
            			line++;
           			System.out.println(board);
          			
         			String hole[] = board.split(" ");
       */     	
            	
            input.close();
		
		}
		
		catch(Exception e)
		{
          	System.out.println("Cannot read a text file:" + e.getMessage());
        }
	}
}
