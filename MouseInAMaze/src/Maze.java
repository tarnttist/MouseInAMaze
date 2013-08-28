import java.io.*;

public class Maze {
	public static void main(String arg[]){
		
		try
		{
            FileInputStream read = new FileInputStream("input.txt");
            DataInputStream input = new DataInputStream(read);
            BufferedReader br = new BufferedReader( new InputStreamReader(input));
            String line="";
            	while((line = br.readLine()) != null)
            		{
            			System.out.println(line);
            		}
            input.close();
        }
		
		catch(Exception e)
		{
          	System.out.println("Error while reading the file:" + e.getMessage());
        }

	}
}
