import java.util.Scanner;
public class Marketplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		double totalcost = 0;
		
		while (true)
		{
			Purchase marketPlace = new Purchase();
			marketPlace.readInput();
			marketPlace.writeOutput();
			System.out.printf("Each item costs $%5.2f\n",marketPlace.getUnitCost());
			
			System.out.printf("Total cost of %s is $%5.2f\n",marketPlace.getName(),marketPlace.getTotalCost());
			totalcost += marketPlace.getTotalCost();
			
			System.out.println("Is your grocery list complete?");
			Scanner exitting = new Scanner(System.in);
			String exitting2 = exitting.nextLine();
			if (exitting2.equals("quit") || exitting2.equals("yes"))
			{
				System.out.println("Thank you for shopping at Lo-Bi.");
			    break;
			}
		}
		System.out.println("The total cost of your grocery list is: $"+totalcost);
	}
}
