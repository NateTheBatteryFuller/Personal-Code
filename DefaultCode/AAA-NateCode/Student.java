import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Student 
{
	
	public static void erf(int[] array)
	{
		//int length = 10;
		//int[] array = new int[length];
		for(int i = 0; i < array.length; i++)
		{
			//System.out.print(i + " ");
			array[i] = i;
		}
		int length = array.length;
		System.out.println(array[length-1]);
		//System.out.println(array[length]); //nothing there, throws error
	}
	
	public void creatingTextFile()
	{
		String fileName = "output.txt";
		PrintWriter outputStream = null;
		try
		{
			outputStream = new PrintWriter(fileName);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		outputStream.println("erpaderp");
		outputStream.close();
	}

	public static void main(String[] args)
	{
	   int[] a = new int[10];
	   //keyword static way of calling method
	   erf(a);
	   
	   //object way of calling method
	   Student erp = new Student();
	   erp.creatingTextFile();
	   
	   
	   
//	   int number = 4;
//	   Student[] erpa = new Student[number];
//	   for(int i = 0; i < number; i++)
//	   {
//		   Student[] order = ;
//		   erpa[i] = order[i];
//		   System.out.println(erpa[i]);
//		   System.out.println(order[i]);
//	   }
	   
	   
	   ArrayList<String> list = new ArrayList<String>(4);
	   list.add("erf");
	   list.get(0);
	   list.add("derf");
	   list.get(1);
	   
	   main(8);
	   
	   
	   
	   
	}
	
	public static void main(int erf)
	{
		erf = erf + 1;
		System.out.println("erf is " + erf);
	}
	
	public void erf(Scanner inFile)
	{
		
	}
}
