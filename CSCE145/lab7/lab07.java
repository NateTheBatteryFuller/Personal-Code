import javax.swing.JOptionPane;
public class lab07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Here we go...");
		JOptionPane.showMessageDialog(null, "Please input number values!");
		String userInput = JOptionPane.showInputDialog("Alrighty then!");
		double min = Double.POSITIVE_INFINITY;
		double max = Double.NEGATIVE_INFINITY;
		//double uInput ;
		double sum = 0;
		int count = 0;
		
		while (!userInput.equals("stop") && !userInput.equals("quit") && !userInput.equals("exit"))
		{
//			JOptionPane.showMessageDialog(null, "We're done here!");
//			System.exit(0);
			
			double uInput = Double.parseDouble(userInput);
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
			
			
			userInput = JOptionPane.showInputDialog("Again! Again! More! More!");
			
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
		
		
		//System.out.println(uInput);
		
		
//		while (uInput>min && uInput<max)
//		{
//			String userInput2 = JOptionPane.showInputDialog("Please input number values...again!");
//			
//			if (userInput2.equals("stop") || userInput.equals("quit") || userInput.equals("exit") || userInput.equals(""))
//			{
//				JOptionPane.showMessageDialog(null, "We're done here!");
//				System.exit(0);
//			}
//			double uInput2 = Double.parseDouble(userInput2);
//			double number = (1 + m++ );
//			double Addition = (uInput2 + uInput);
//			double Average = (Addition/number);
//		
//			
//			JOptionPane.showMessageDialog(null, uInput + uInput2 + Addition + Average);
//	}

}}
