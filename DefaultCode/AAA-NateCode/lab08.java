import java.util.Scanner;
public class lab08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("What size would you like to make your triangle? Pick a number between 1 and 50!");
		Scanner kd = new Scanner(System.in);
		int sizeTriangle = kd.nextInt();
		
		for(int a=1; a<=sizeTriangle; a++)
		{
			for(int b=1; b<=a; b++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int c=1; c<=sizeTriangle; c++)
		{
			for(int d=1; d<=sizeTriangle-c; d++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int a=1; a<=5; a++)
		{
			for(int b=1; b<=10; b++)
			{
				if (b==10) System.out.print("|");
				else System.out.print(" ");
			}
		}
		System.out.println();
		
		for(int a=1; a<=5; a++)
		{
			for(int b=1; b<=10; b++)
			{
				if (b==10) System.out.print("0");
				else System.out.print(b);
			}
		}
	}
}

