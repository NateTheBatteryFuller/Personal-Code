import java.util.ArrayList;


/**
 * @author Nate Fuller
 * This class implements Generics using a Linked List.
 */

public class GenericLinkedList<E>
{
	private ListNode head;
	
	public GenericLinkedList()
	{
		head = null;
	}
	
	/**
	 * Displays the data on the list.
	 */
	public void showList()
	{
		ListNode position = head;
		while(position != null)
		{
			System.out.println(position.getData());
			position = position.getLink();
		}
	}
	
	/**
	 * Returns the number of nodes on the list.
	 */
	public int length()
	{
		int count = 0;
		ListNode position = head;
		while(position != null)
		{
			count++;
			position = position.getLink(); //stepping through a list
		}
		return count;
	}
	
	/**
	 * Adds a node containing the data addData at the start of the list.
	 */
	public void addANodeToStart(E addData)
	{
		head = new ListNode(addData, head);
	}
	
	/**
	 * Deletes the first node on the list.
	 */
	public void deleteHeadNode()
	{
		if(head != null)
		{
			head = head.getLink(); //removes the first node
		}
		else
		{
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
	}
	
	/**
	 * Sees whether target is on the list.
	 */
	public boolean onList(E target)
	{
		return find(target) != null;
	}
	
	/**
	 * Returns a reference to the first node containing the target data.
	 * If target is not on the list, returns null.
	 */
	private ListNode find(E target)
	{
		boolean found = false;
		ListNode position = head;
		while((position != null) && !found)
		{
			E dataAtPosition = position.getData();
			if(dataAtPosition.equals(target))
			{
				found = true;
			}
			else
			{
				position = position.getLink();
			}
		}
		return position;
	}
	
	/**
	 * Used in StringLinkedList2Demo class
	 */
	private ArrayList<E> toArrayList()
	{
		ArrayList<E> list = new ArrayList<E>(length());
		ListNode position = head;
		while(position != null)
		{
			list.add(position.data);
			position = position.link;
		}
		return list;
	}

	/**
	 * Implemented from ListNode class
	 */

	private class ListNode
	{
		private E data;
		private ListNode link;
		
		public ListNode()
		{
			link = null;
			data = null;
		}
		
		public ListNode(E newData, ListNode linkValue)
		{
			data = newData;
			link = linkValue;
		}
	
		public E getData()
		{
			return data;
		}
	
		public ListNode getLink()
		{
			return link;
		}
	
		public void setLink(ListNode newLink)
		{
			link = newLink;
		}
	}
}
