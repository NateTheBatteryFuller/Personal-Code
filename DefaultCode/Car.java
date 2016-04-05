import java.util.Scanner;

public class Car
{

	private static final int CAPACITY = 50;
	private static double gasLeft;

	public Car()
	{
		this.gasLeft = CAPACITY;
	}

	public static void drive(int distance) throws OutOfGasException
	{
		if (distance > gasLeft)
		{
			throw new OutOfGasException();
		}
		else
		{
			gasLeft = gasLeft - distance;
			System.out.println("You drove " + distance + " miles." + "\nYou have " + gasLeft
					+ " gallons left in your tank.");
		}
	}

	public static void refill(double fillAmount) throws OverflowException
	{
		if ((gasLeft + fillAmount) > CAPACITY)
		{
			throw new OverflowException();
		}
		else
		{
			gasLeft = gasLeft + fillAmount;
			System.out.println("You added " + fillAmount + " gallons of gas to your tank."
					+ "\nYou have " + gasLeft + " gallons in your tank.");
		}
	}

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Car c1 = new Car();
		System.out.println("Welcome to the driving simulator.");
		boolean stop = false;
		while (stop != true)
		{
			System.out.print("How far do you plan to drive? ");
			int distance = keyboard.nextInt();
			try
			{
				drive(distance);
			}
			catch (OutOfGasException e1)
			{
				System.out.println("You ran out of gas!");
				stop = true;
				break;
			}
			System.out.print("How much gas did you add? ");
			double fillAmount = keyboard.nextDouble();
			try
			{
				refill(fillAmount);
			}
			catch (OverflowException e2)
			{
				System.out.println("You've added too much to the tank. It has overflowed.");
				stop = true;
				break;
			}
		}
		System.out.println("Thank you for using this program. Goodbye.");

	}

}
