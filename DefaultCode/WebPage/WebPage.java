import java.util.Scanner;
import java.io.*;
public class WebPage {

	public static void adHelper (String name, String money, String description, String date)
	{
		System.out.println("What would you like to sell on eBay?");
		Scanner key = new Scanner(System.in);
		name = key.nextLine();
		System.out.println("How much money would you like to sell it for?");
		money = key.nextLine();
		System.out.println("What is the description of your item?");
		description = key.nextLine();
		System.out.println("What is the date the bidding of your item will close? Enter date in mm/dd/yyyy format.");
		date = key.nextLine();
		
		PrintWriter output = null;
		try
		{
			output = new PrintWriter(new File("AuctionItem.html"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		output.println("<html>\n<title>" + name + "up for grabs on eBay!</title>");
		output.println("<h1><center>" + name + "</h1></center>");
		output.println("<p>Bidding price: " + money + "</p>");
		output.println("<p>Description of item: " + description + "</p>");
		output.println("<p>Date of bidding of item: " + date + "</p>");
		output.close();
	}
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Auction Ad Helper.");
		WebPage.adHelper(null, null, null, null);
		System.out.println("Thank you for using this program.");
	}

}
