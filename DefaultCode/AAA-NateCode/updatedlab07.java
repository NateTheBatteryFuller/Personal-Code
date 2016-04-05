//import javax.swing.JOptionPane;
import java.util.Scanner;
public class updatedlab07
{
		/**
		 * @param args
		 */
		public static void main(String[] args) 
		{
			System.out.println("Here we go...");
			System.out.println("Please input number values!");
			Scanner kb = new Scanner(System.in);
//			double userInput = kb.nextDouble();
//			System.out.println(userInput + " is the number of inputs you can enter.");
			double min = Double.POSITIVE_INFINITY;
			double max = Double.NEGATIVE_INFINITY;
			double sum = 0;
			int count = 0;
			
			String userInput = "";
//			boolean erp = true;
			while(userInput != "stop" || userInput != "quit" || userInput != "exit")
//			for(int i = 0; i < userInput; i++)
			{
				userInput = kb.nextLine();
//				if(userInput.equals("stop") || userInput.equals("quit") || userInput.equals("exit"))
//				{
//					erp = false;
//				}
//				
//				else
//				{	
					double uInput = Double.parseDouble(userInput);
//					double uInput = kb.nextDouble();
					if(uInput < min)
					{
						min = uInput;
					}
					if(uInput > max)
					{
						max = uInput;
					}
					sum = sum + uInput;
					count = count + 1;
//				}
			}
			double avg = sum/count;
			double range = max-min;
			
			System.out.println("The minimum is: " + min);
			System.out.println("The maximum is: " + max);
			System.out.println("The sum is: " + sum);
			System.out.println("The total amount of numbers I typed in is: " + count);
			System.out.println("The average of all the numbers is: " + avg);
			System.out.println("The range of my minimum and maximum numbers is: " + range);
			System.out.println("Congratulations!!! You're doing alright on your labs!!!");
		}
	

}
