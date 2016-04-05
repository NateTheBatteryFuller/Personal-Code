
public class lab06 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("From the beginning...");
		//int sum;
		for (int perfectMedian = 1; perfectMedian <=10000; perfectMedian++) 
		{
			int sum = perfectMedian*(perfectMedian-1)/2;
			
			int number = perfectMedian + 1;
			
			while (sum > 0)
			{
				sum = sum - number;
				if(sum == 0) 
				{
					System.out.println(perfectMedian + " is a perfect median.");
				}
				number = number + 1;
		
			}
		}
		System.out.println("That was...not very easy for someone who doesn't know anything about Java!");
	}
}
