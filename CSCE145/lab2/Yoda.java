import java.util.Scanner;


public class Yoda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a line of text with no puncuation");
		String input = kb.nextLine();
		int index = input.indexOf(" ");
		String part1 = input.substring(0, index);
		
		String rest = input.substring(index+1);
		System.out.println(rest + " " + part1);
		System.out.println("Yoda has spoken");		
		System.out.println("one");
		System.out.println("two");
		System.out.println("three");
		
		
	}

}
