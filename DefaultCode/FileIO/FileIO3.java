import java.util.Scanner;


public class FileIO3
{
	public static void main(String[] args)
	{
		boolean done = false;
		Scanner kb = new Scanner(System.in);
		while(!done)
		{
			System.out.println("Add something to the file:");
			String entry = kb.nextLine();
			FileIO io = new FileIO();
			io.createTextFile(fileName);
		}
	}
}
