import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nate Fuller
 * ArrayList is a dynamic data structure, meaning that the size 
 * can grow or shrink while the program is running.
 * 
 * Other Methods in the Class ARRAYLIST
 * 
 * public ArrayList<BASE_TYPE>(int initialCapacity)
 * public ArrayList<BASE_TYPE>()
 * public boolean add(BASE_TYPE newElement)
 * public void add(int index, BASE_TYPE newElement)
 * public BASE_TYPE get(int index)
 * public BASE_TYPE set(int index, BASE_TYPE element)
 * public BASE_TYPE remove(int index)
 * public boolean remove(Object element)
 * public void clear()
 * public void size()
 * public boolean contains(Object element)
 * public int indexOf(Object element)
 * public boolean isEmpty()
 */

public class toDoList
{
	public static void main(String[] args)
	{
		ArrayList<String> toDoList = new ArrayList<String>();
		System.out.println("Enter items for the list, when prompted.");
		boolean done = false;
		Scanner kb = new Scanner(System.in);
		while(!done)
		{
			System.out.println("Type an entry:");
			String entry = kb.nextLine();
			toDoList.add(entry);
			System.out.println("More items for the list?");
			String answer = kb.nextLine();
			if(!answer.equalsIgnoreCase("yes"))
			{
				done = true;
			}
		}
		System.out.println("The list contains: ");
		int listSize = toDoList.size();
		for(int index = 0; index < listSize; index++)
		{
			System.out.println(toDoList.get(index));
		}
	}
}
