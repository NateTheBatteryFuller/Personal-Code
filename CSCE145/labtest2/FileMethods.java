import java.util.Scanner;
import java.io.*;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FileMethods {

	/**
	 * @param args
	 */
	public void fileCompare(String file1, String file2)
	{
//		Scanner keyboard = null;
//		PrintWriter output = null;
//		try
//		{
//			keyboard = new Scanner(new File("exam.txt"));
//		} catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try 
//		{
//			output = new PrintWriter (new File("newexam.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		String fileName = "exam.txt";
		try 
		{
			boolean stop = false;
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter lines of text to be evaluated for File1.");
			String fileOne;
			do
			{
				fileOne = keyboard.nextLine();
				outputStream.writeChars(fileOne);
			} while (!fileOne.equals("The End"));
			System.out.println("The text you put in the file \"exam.txt\" is" + "\n" +fileOne);
			outputStream.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening the file " + fileName);
		}
		catch(IOException e)
		{
			System.out.println("Problem with output of file " + fileName);
		}
	}
	public static void main(String[] args) {
		FileMethods filemethod = new FileMethods();
		filemethod.fileCompare("", "");

	}

}
