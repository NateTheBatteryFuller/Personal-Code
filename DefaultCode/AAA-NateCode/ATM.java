import java.util.*;
public class ATM 
{
	//static double initial_balance = 0;
	static double withdrawal_fee = .5;
	
	public static void main(String[] args) 
	{
		System.out.println("Hi! My name is Pooja. I want to take some money out of my account.");
		System.out.println("Please enter a number that is a multiple of 5 between 0 and 2000 for me ");
		System.out.println("to withdraw from my bank account.");
		Scanner kbd = new Scanner(System.in);
		double withdraw = kbd.nextDouble();
		System.out.println("Please enter my bank account balance:");
		double balance = kbd.nextDouble();
		if(withdraw > 0 && withdraw <= 2000 && withdraw%5 == 0 && balance > 0 && balance <= 2000)
		{
			double newBalance = balance - withdraw - withdrawal_fee;
			if(newBalance < 0 || withdraw > balance)
			{
				System.out.println(balance);
				System.exit(0);
			}
			System.out.println(newBalance);
		}
		else
		{
			System.out.println(balance);
			System.exit(0);
		}
	}
}
