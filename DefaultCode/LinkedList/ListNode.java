
/**
 * @author Nate Fuller
 * This class shows how implement linked data structures in Java
 * without using the LinkedList class. 
 */

public class ListNode
{
	private String data;
	private ListNode link;
	
	public ListNode()
	{
		link = null;
		data = null;
	}
	
	public ListNode(String newData, ListNode linkValue)
	{
		data = newData;
		link = linkValue;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String newData)
	{
		data = newData;
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
