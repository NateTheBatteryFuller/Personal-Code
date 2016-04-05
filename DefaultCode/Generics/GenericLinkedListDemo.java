
/**
 * @author Nate Fuller
 * Demonstrates the basics of Generics
 */
public class GenericLinkedListDemo
{
	public static void main(String[] args)
	{
		GenericLinkedList<String> stringList = new GenericLinkedList<String>();
		stringList.addANodeToStart("Hello");
		stringList.addANodeToStart("Goodbye");
		stringList.showList();
		GenericLinkedList<Integer> numberList = new GenericLinkedList<Integer>();
		for(int i = 0; i < 5; i++)
		{
			numberList.addANodeToStart(i);
		}
		numberList.deleteHeadNode();
		numberList.showList();
	}
}
