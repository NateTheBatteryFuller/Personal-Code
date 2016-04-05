import java.util.Scanner;
public class SecondStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello out there.");
		//two forward slashes means the rest of the line is a comment!!!!
		
		//make a String variable with your first name -- change this to your first name
		String firstName = "Nate";

		//make a String variable with your last name -- change this to your last name
		String lastName = "Fuller";
		
		//make a char variable that indicates the grade you want to make in this calss
		char grade = 'A'; //note single quotes ' around characters
		
		//Finally output all of that information to the screen
		System.out.println("My first name is " + firstName + " and my last name is " + lastName + "and if I study hard, I will make an " + grade + " in CSCE145!");
		
		//prompt the user to input two numbers to add
		System.out.println("I will now add two integer values. Please enter the two integer values seperated by a space: ");
		
		//now we need to create and connect a Scanner object to the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		//now we can use the keyboard object to retrieve values from the user
		int value1 = keyboard.nextInt();
		int value2 = keyboard.nextInt();
		int result = value1 + value2;
		
		System.out.println("The result of adding " + value1 + " and " + value2 + "is: " + result);
		
		System.out.println("Goodbye");
	}
}
