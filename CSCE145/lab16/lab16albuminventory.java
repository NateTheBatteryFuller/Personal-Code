import java.io.*;
import java.util.Scanner;
public class lab16albuminventory 
{

	/**
	 * @param args
	 */
	public static void readAndWrite() 
	{
		Scanner keyboard = null;
		PrintWriter output = null;
		try
		{
			keyboard = new Scanner(new File("Test.txt"));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try 
		{
			output = new PrintWriter (new File("newTest.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (keyboard.hasNextLine()) 
		{
			String str = keyboard.nextLine();
			output.println(str);
			str = keyboard.nextLine();
			output.println(str);
			str = keyboard.nextLine();
			int year = Integer.parseInt(str);
			str = keyboard.nextLine();
			double price = Double.parseDouble(str.substring(1, str.length()));
			if (2011 - year <= 5)
				{
					price = price - (price * .05);
				}
				else if (2011 - year <=10 && 2011-year > 5)
				{
					price = price - (price * .10);
				}
				else 
				{		
					price = price - (price * .5);			
				}
			output.println(year);
			output.println("$" + price);
		}
		output.close(); 
		}

		public static void main(String[] args)
		{
			readAndWrite();
		}
	

}
