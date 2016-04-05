
/**
 * @author Nate Fuller
 * This class shows how implement linked data structures in Java
 * without using the LinkedList class. 
 */

public class StringLinkedListDemo
{
	public static void main(String[] args)
	{
			StringLinkedList list = new StringLinkedList();
			list.addANodeToStart("one");
			list.addANodeToStart("two");
			list.addANodeToStart("three");
			System.out.println("List has " + list.length() + " entries.");
			list.showList();
			if(list.onList("three"))
			{
				System.out.println("Three is on list.");
			}
			else
			{
				System.out.println("three is NOT on list.");
			}
			list.deleteHeadNode();
			if(list.onList("three"))
			{
				System.out.println("Three is on list.");
			}
			else
			{
				System.out.println("three is NOT on list.");
			}
			list.deleteHeadNode();
			list.deleteHeadNode();
			System.out.println("Start of list:");
			list.showList();
			System.out.println("End of list.");
	}
}
