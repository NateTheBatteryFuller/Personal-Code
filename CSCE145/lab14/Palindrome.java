import java.util.Scanner;
public class Palindrome {
	
		/****************************************************************
		 * Precondition: The String input contains letters and blanks in
		 * position input[0] through input[length - 1].
		 * Returns true if the string is a palindrome and false otherwise.
		 ****************************************************************/
	
	public static boolean palindrome(String inputUser) {
		boolean test = false;
		inputUser = inputUser.toLowerCase();
		char[] input = new char[inputUser.length];
		char[] output = new char[input.length];
		inputUser.getChars(0, inputUser.length(), input, 0);
		for (int i=0; i<input.length; i++) {
			output[i] = input[input.length - 1 - i];
			
		}

		for(int i = 0; i <input.length; i++) {
			if(output[i] == input[i]) {
				test = true;
			}
			else {
				test = false;
				return test;
			}
		}
		
		return test;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		int n = 1;
		do {
			System.out.println("Input something to check if it is a palindrome.");
			System.out.println("Enter n to terminate.");
			String userInput = keyboard.nextLine();
			userInput = userInput.toLowerCase();
			if (userInput.contentEquals("n") == true){
				n = 0;
			}
			else {
				boolean value = palindrome(userInput);
				if (value == true) {
					System.out.println("Good job. It's a palindrome.");
				}
				else if (value == false){
					System.out.println("Negatory. Not a Palindrome.");
				}
				
			}
			
		} while (n > 0);
			System.out.println("Goodbye.");
			System.exit(0);
			
		
		
	}

}
