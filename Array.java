
public class Array
{
	public static void whatever(int[] array)
	{
		// int length = 10;
		// int[] array = new int[length];
		for (int i = 0; i < array.length; i++)
		{
			// System.out.print(i + " ");
			array[i] = i;
		}
		int length = array.length;
		System.out.println(array[length - 1]);
		// System.out.println(array[length]); //nothing there, throws error
	}

	public static void main(String[] args)
	{
		int[] a = new int[10];
		whatever(a);
	}
}
