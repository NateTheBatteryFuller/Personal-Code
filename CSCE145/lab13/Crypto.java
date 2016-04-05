import java.util.Scanner;
public class Crypto {
	private char[]key = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public Crypto(char[] userKey) {
		this.key = userKey;
	}
	public static String printCharArray(char[] array) {
		String output = "";
		for (int i = 0; i<array.length; i++) {
			output = output + array[i];
		}
		return output;
	}
	
	
	public static char[] encrypt(char[] key, char[] input, int lengthInput) {
		char[] encoded = new char[lengthInput];
		for (int i = 0; i < input.length; i++) {
			char search = input[i];
			if (search == ' ') {
				encoded[i] = ' ';
			}
			for (int j = 0; j < key.length; j++) {
				if (key[j] == search) {
					int index = (int) (search - 'a');
					encoded[i] = key[index];
				}
			}
		}
		return encoded; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the key as a random ordering of the 26 letters of the English alphabet.");
		char[] key = new char[26];
		for (int k = 0; k<key.length; k++) {
			System.out.println((k+1) + ": ");
			String k1 = keyboard.nextLine();
			key[k] = k1.charAt(0);
		}
		
		while (true) {
			System.out.println("Enter your message to be encrypted: ");
			Scanner input = new Scanner(System.in);
		
			String message = input.nextLine();
			if (message.length() == 0)
				break;
			else {
				char[] msgChar = message.toCharArray();
				int lengthOfMessage = message.length();
				char[] encryption = encrypt(key, msgChar, lengthOfMessage);
				System.out.println("The encrypted message is: " + printCharArray(encryption));
				}
	
			}
			System.out.println("Have a great day.");

		

			
	}

}
