import java.util.Scanner;
public class ATM 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Please enter the number of dollars you wish to withdraw: ");
		Scanner kb =new Scanner (System.in);
		int amount = kb.nextInt();
		int twenties = amount/20;
		amount = amount%20;
		int tens = amount/10;
		amount = amount%10;
		int fives = amount/5;
		amount = amount%5;
		int ones = amount/1;
		amount = amount%1;
		
		System.out.println("I will dispense");
		
		System.out.printf("%10d $20 bills \n", twenties);
		System.out.printf("%10d $10 bills \n", tens);
		System.out.printf("%10d $5 bills \n", fives);
		System.out.printf("%10d $1 bills \n", ones);		
	
		
		

	}

}
