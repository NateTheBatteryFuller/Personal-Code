
public class lab06 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("From the beginning...");
		//int sum;
		for (int perfectMedian = 1; perfectMedian <=1000; perfectMedian++) 
		{
			//System.out.println(perfectMedian + " i");
			int sum = perfectMedian*(perfectMedian-1)/2;
			//System.out.println(sum + " sum");
			int number = perfectMedian + 1;
			//System.out.println(number + " number\n");
			while (sum > 0)
			{
				sum = sum - number;
				//System.out.println(sum + " second sum");
				if(sum == 0) 
				{
					System.out.println(perfectMedian + " is a perfect median.");
				}
				number = number + 1;
				//System.out.println(number + " second number\n");
			}
		}
		System.out.println("That was...not very easy for someone who doesn't know anything about Java!");
	}

	public int length;
}
