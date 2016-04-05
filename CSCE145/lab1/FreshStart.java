import java.util.Scanner;
public class FreshStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello out there.");
		// two forward slashes means the rest of the line is a comment!!!!
		
		//Make a String variable for storing a first name -- change this to your first name
		String firstName = "Nate";
		//Make a String variable for storing a last name -- change this to your last name
		String lastName = "Fuller";
		
		//Make a char variable that indicates the grade you want to make in this class
		char grade = 'A'; //note single quotes ' around characters
		
		//Finally, output all of that information to the screen
		System.out.println(" My first name is " + firstName + " and my last name is " + lastName + " and if I study hard, I will make an " + grade + " in CSCE145!");
		
		//Prompt the user to input two numbers to divide
		System.out.println(" I will now compute the volume of an object, please enter the two integer values seperated by a space: ");
		
		//Now create and connect a Scanner object to the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		//Now use the keyboard object to retrieve values from the user
		int value1 = keyboard.nextInt();
		int value2 = keyboard.nextInt();
		int result = value1 / value2; //This divides the values
		
		System.out.println("The resulting computation is " + value1 + " grams and " + value2 + " grams per cubic centimeter is: " + result);
		
		System.out.println("The relationship of mass, density, and volume of an object is given by Volume = Mass / Density ");
		
		System.out.println("Goodbye");
	}

}
