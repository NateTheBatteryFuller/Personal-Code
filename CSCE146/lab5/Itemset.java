import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*********************************************************************
 * Class that creates the Itemset for the <code>OneLine</code> class.
 *
 * Copyright (C) 2012 by Nate Fuller.  All rights reserved.
 *
 * @author Nate Fuller
 * @version 1.01 02-22-2012
**/

public class Itemset {
	
	private ArrayList<OneLine> items;
	
	public Itemset(){
		items = new ArrayList<OneLine>();
	}
	
	public void sort()
	{
		for(int i = 0; i<items.size(); i++)
		{
			for(int j = 0; j<i; j++)
			{
				if(items.get(i).compareTo(items.get(j))<0)
				{
					items.add(j,items.get(i));
					items.remove(i+1);
				}
			}
		}
	}
	
	public void doTheWork(Scanner in, PrintWriter out)
	{
		while(in.hasNext())
		{
			OneLine n = new OneLine();
			items.add(n.readLine(in));
			
		}
		this.sort();
	}
	
}
