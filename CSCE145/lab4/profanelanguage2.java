import java.util.Scanner;
public class profanelanguage2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Please enter good language: ");
		Scanner kb = new Scanner(System.in);
		
		String sLine = kb.nextLine();
		String sWord;
		
		Scanner line = new Scanner(sLine);
		
		while(line.hasNext())
		{
			sWord = line.next();
			sWord = sWord.toLowerCase();
			if(sWord.equals("cat") || sWord.equals("dog") || sWord.equals("llama"))
			{
				System.out.println("Bad boy! You should not use such language!");
				System.exit(0);
			
		
			}
		}	
			System.out.println("At a boy!");
			System.exit(0);
		}
	}
			