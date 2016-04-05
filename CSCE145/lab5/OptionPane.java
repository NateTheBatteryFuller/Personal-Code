import javax.swing.JOptionPane;
public class OptionPane {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Pane in the butt!");
		String uInput = JOptionPane.showInputDialog("Please enter a date, you Pane!");
		String month = uInput.substring(0, 2);
		int m = Integer.parseInt(month);
		String year = uInput.substring(6, 10);
		int y = Integer.parseInt(year);
		String day = uInput.substring(3, 5);
		int d = Integer.parseInt(day);
		System.out.println(uInput);
		JOptionPane.showMessageDialog(null, uInput);
		if (y < 0 || m > 12 || m < 1 || d > 31 || d < 1)
		{
			System.out.println("What in the world? What planet did you come from???");
			System.exit(0);
		}
		if ((d>31) || (m>12))
		{
			System.out.println("Why do you have to be such a Pane?!?!?!");
			System.exit(0);
		}
		

		if ((m == 4) || (m == 6) || (m == 9) || (m == 11))
		{
			if (d>30)
			{
				JOptionPane.showMessageDialog(null, "You don't know how many days are in a month??! I laugh at thee!!!");
				System.exit(0);
			}
		}
		if (m == 2)
		{ 
			if (d>29)
			{
				JOptionPane.showMessageDialog(null, "You obviously don't have a Valentine this year!");
				System.exit(0);
			}
		}
	
		if ((y%4 == 0) && !(y%100 == 0) || (y%400 == 0))
					{
			System.out.println("Leap year!!!");
					}
		else
			{
			System.out.println("Not a leap year, you Pane!!!");
			if (m == 2)
				if (d>28)
				JOptionPane.showMessageDialog(null, "Incorrect, Wanna-be-Cupid");
			}
		System.out.println(uInput);
		JOptionPane.showMessageDialog(null, "The Day is " + day + " and the month is "  + month + " and the year is " + year);
		}
		
	

	private static boolean m(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return false;
	}

}
