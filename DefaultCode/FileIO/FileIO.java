import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Nate Fuller
 * 6-23-14
 * This class adds to a text file via user input
 * with basic Scanner and String types.
 */


public class FileIO
{
	PrintWriter outputStream = null;

	public void createTextFile(String fileName)
	{
		try
		{
			outputStream = new PrintWriter(fileName);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		//close() must be called to update stream
		outputStream.close();
	}

	public void readTextFile(String fileName)
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new File(fileName));
			System.out.println("The file " + fileName + " contains the following lines:");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file: " + fileName);
			System.exit(0);
		}
		while (inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			System.out.println(line);
		}
		//close() must be called to update stream
		inputStream.close();
	}

	public void appendTextFile(String str, String fileName)
	{
		try
		{
			//FileOutputStream(fileName, whether you want to append or not)
			//in cases that you want to add to the file, 
			//the boolean is set to true
			outputStream = new PrintWriter(new FileOutputStream(fileName, true));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		outputStream.println(str);
		//close() must be called to update stream
		outputStream.close();
	}
	
	public static void main(String[] args)
	{

		System.out.println("Please create your file: ");
		Scanner kb = new Scanner(System.in);
		String fileName = kb.nextLine();
		
		// object way of calling method
		//instead of using keyword static
		FileIO io = new FileIO();
		io.createTextFile(fileName);
		System.out.println("Would you like to add some text to your file?"
				+ " Please say 'yes' or 'no'.");
		String answer = kb.nextLine();
		while(answer.equalsIgnoreCase("yes"))
		{
			System.out.println("What would you like to add to the " + 
					fileName + " file? Please enter your text.");
			String str = kb.nextLine();
			io.appendTextFile(str, fileName);
			System.out.println("Would you like to add anything else?");
			answer = kb.nextLine();
			if(answer.equalsIgnoreCase("no"))
			{
				io.readTextFile(fileName);
				System.out.println("See you next time.");
				System.exit(0);
			}
			else if(answer.equalsIgnoreCase("yes"))
			{
				//answer = kb.nextLine();
				continue;
			}
			else
			{
				System.out.println("Please enter 'yes' or 'no':");
				answer = kb.nextLine();
				while(!(answer.equalsIgnoreCase("yes")) && 
						!(answer.equalsIgnoreCase("no")))
				{
					System.out.println("Please enter 'yes' or 'no':");
					answer = kb.nextLine();
				}
			}
		}
		
		if(answer.equalsIgnoreCase("no"))
		{
			io.readTextFile(fileName);
			System.out.println("See you next time.");
			System.exit(0);
		}
		else
		{
			System.out.println("Please enter 'yes' or 'no':");
			answer = kb.nextLine();
			while(answer.equalsIgnoreCase("yes"))
			{
				System.out.println("What would you like to add to the " + 
						fileName + " file? Please enter your text.");
				String str = kb.nextLine();
				io.appendTextFile(str, fileName);
				System.out.println("Would you like to add anything else?");
				answer = kb.nextLine();
				if(answer.equalsIgnoreCase("no"))
				{
					io.readTextFile(fileName);
					System.out.println("See you next time.");
					System.exit(0);
				}
				else if(answer.equalsIgnoreCase("yes"))
				{
					answer = kb.nextLine();
					//continue;
				}
				else
				{
					System.out.println("Please enter 'yes' or 'no':");
					answer = kb.nextLine();
					while(!(answer.equalsIgnoreCase("yes")) && 
							!(answer.equalsIgnoreCase("no")))
					{
						System.out.println("Please enter 'yes' or 'no':");
						answer = kb.nextLine();
					}
				}
			}			
		}
		io.readTextFile(fileName);
	}
}

