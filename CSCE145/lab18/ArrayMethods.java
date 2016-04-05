
public class ArrayMethods {
	
	
	public static void initArray(char[] randomLetters) 
	{
		for (int i=0; i<100; i++)
		{
			String fiveLetters = "abcde";
			int character = (int)(Math.random()*5);
			String random = fiveLetters.substring(character, character+1);
			char random1 = random.charAt(0);
			randomLetters[i]=random1;
			System.out.print(randomLetters[i] + " ");
		}
		
	}
	public static void countLetters (char[] randomLetters)
	{
		int a1 = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		for (int i = 0; i <100; i++)
		{
			if(randomLetters[i]=='a') a1++;
			else if (randomLetters[i]=='b') b++;
			else if (randomLetters[i]=='c') c++;
			else if (randomLetters[i]=='d') d++;
			else if (randomLetters[i]=='e') e++;
		}
		System.out.println("\nThere are: ");
		System.out.println(a1 + "A's");
		System.out.println(b + "B's");
		System.out.println(c + "C's");
		System.out.println(d + "D's");
		System.out.println(e + "E's");
		
	}

}
