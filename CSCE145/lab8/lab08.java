import java.util.Scanner;
public class lab08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("What size would you like to make your triangle? Pick a number between 1 and 50!");
		Scanner keyboard = new Scanner(System.in);
		String sizeTriangle = keyboard.nextLine();
		int sizeTriangle2 = Integer.parseInt(sizeTriangle);
		
		for (int a=1; a<=sizeTriangle2; a++)
			{
				for (int b=1; b<=a; b++)
				{
					System.out.print("*");
				}
				System.out.println();
				
				
			}
		
	
		
		for (int c=1; c<=sizeTriangle2; c++)
			{
				for (int d=1; d<=sizeTriangle2-c; d++)
				{
					System.out.print("*");
				}
			System.out.println();
			}
		
		for (int a=1; a<=5; a++)
			{
				for (int b=1; b<=10; b++)
				{
					if (b==10) System.out.print("|");
					else System.out.print(" ");
				}
//				System.out.println("         |");
//				System.out.println();
			}
		System.out.println();
	//	System.out.print("\n");
		for (int a=1; a<=5; a++)
		{
			for (int b=1; b<=10; b++)
			{
				if (b==10) System.out.print("0");
				else System.out.print(b);
				
				
			}
//			System.out.println("         |");
//			System.out.println();
		}
		
	}
}

