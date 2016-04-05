import java.util.Scanner;
public class profanelanguage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please type something: ");
		Scanner keyboard= new Scanner (System.in);
		String prof= keyboard.nextLine();
		prof.equalsIgnoreCase(prof);
	
		if (prof.contains("cat") || prof.contains("dog") || prof.contains("llama"))
	
		{
		
			System.out.println("Bad boy! Do not use such language!");

		}
		else
		

			System.out.println("At a boy!");
		}
		
		
	}
