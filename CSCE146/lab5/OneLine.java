import java.util.Arrays;
import java.util.Scanner;

/*********************************************************************
 * Class to handle one line of itemset data.
 *
 * Copyright (C) 2012 by Nate Fuller.  All rights reserved.
 *
 * @author Nate Fuller
 * @version 1.01 02-22-2012
**/

public class OneLine implements IOneLine {

/*********************************************************************
 * Instance variables for the class.
**/
	private static final String DUMMYSTRING = "dummy";
	private static final int DUMMYINT = Integer.MIN_VALUE;
	private static final int COMPARECOUNT = 4;
	private int[] n; // item numbers
	private String restOfLine; // the rest of the line
	
/*********************************************************************
 * Constructor.	
 */
	public OneLine()
	{
		n = new int[COMPARECOUNT];
		restOfLine = DUMMYSTRING;
		Arrays.fill(n,DUMMYINT);
	}
	
/*********************************************************************
 * Accessors and Mutators.
 */
	@Override
	public int getItemNumber(int which) {
			return n[which];
	}

	@Override
	public String getTheRest() {
	
		return restOfLine;
	}

	@Override
	public int compareTo(OneLine that) 
	{
		for(int i = 0; i<COMPARECOUNT; i++)
		{
			if(n[i] < that.getItemNumber(i))
			{
				return -1;
			}
			else if(n[i] > that.getItemNumber(i))
			{
				return 1;
			}
			
		}
		return 0;
	}

	@Override
	public OneLine readLine(Scanner inFile) {
		for(int i = 0;i<COMPARECOUNT;i++)
		{
			n[i] = inFile.nextInt();
		}
		restOfLine = inFile.nextLine();
		return this;
	}

}
