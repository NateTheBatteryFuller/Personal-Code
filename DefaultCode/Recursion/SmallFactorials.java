import java.util.Scanner;
public class SmallFactorials 
{
	
	public static void main(String[] args) 
	{
		System.out.println("Please enter the number of "
				+ "factorials you would like calculated:");
		Scanner kbd = new Scanner(System.in);
		int numberOfFactorials = kbd.nextInt();
		System.out.println("Please enter " + numberOfFactorials
				+ " numbers to be calculated:");
		int[] factList = new int[numberOfFactorials];
		for(int i = 0; i < numberOfFactorials; i++)
		{
			factList[i] = kbd.nextInt();
			//int n = factList.length;
			
		} 
		System.out.println("Here are your calculated factorials:");
		for (int j = 0; j < factList.length; j++) 
		{
			System.out.println(factorial(factList[j]));
		}
	}
	
	public static int factorial(int fact)
	{
		if(fact == 1)
		{
			return 1;
		}
		else
		{
			return fact*factorial(fact-1);
		}
	}
}
