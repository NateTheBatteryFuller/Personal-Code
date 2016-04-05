import java.util.HashSet;

/**
 * @author Nate Fuller
 * HashSet is similar to ArrayList. It stores a set of objects and uses the COLLECTION interface.
 * It is different in that it stores a set rather than a list, meaning there are no duplicate elements. 
 *
 * Other methods to use from COLLECTION interface:
 * 
 * public boolean add(BASE_TYPE newElement)
 * public void clear()
 * public boolean remove(Object o)
 * public boolean contains(Object o)
 * public boolean isEmpty()
 * public int size()
 * public Object[] toArray() //returns an array containing all elements in collection. Make sure to type cast.
 */
public class HashSetDemo
{
	public static void main(String[] args)
	{
		HashSet<Integer> intSet = new HashSet<Integer>();
		
		intSet.add(2);
		intSet.add(7);
		intSet.add(7);
		intSet.add(3);
		printSet(intSet);
		intSet.remove(3);
		printSet(intSet);
		System.out.println("Set contains 2: " + intSet.contains(2));
		System.out.println("Set contains 3: " + intSet.contains(3));
	}

	private static void printSet(HashSet<Integer> intSet)
	{
		System.out.println("The set contains:");
		for(Object obj : intSet.toArray())
		{
			Integer num = (Integer) obj;
			System.out.println(num.intValue());
		}
	}
}

