import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ArrayStuff {
	
	
	
	public static void main(String[] args) 
	{
		int j = 0;
		int[]a = new int[4];
		int[]b = new int[4];
		
		Scanner keyboard = new Scanner(System.in);
		String filename = "result.txt";
		try 
		{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
			outputStream.writeObject(a);
			outputStream.writeObject(b);
			outputStream.close();
		}
		catch(IOException e)
		{
			System.out.println("Error writing to file " + filename);
			System.exit(0);
		}
		System.out.println("Array written to file " + filename);
		for (int i=0; i<a.length; i++)
		{
			a[i] = keyboard.nextInt();
			b[i] = keyboard.nextInt();
			System.out.println(a[i]);
			System.out.println(b[i]);
		}
		
		System.out.println("\nEnd of program.");
		
		 

		 

	}
}
