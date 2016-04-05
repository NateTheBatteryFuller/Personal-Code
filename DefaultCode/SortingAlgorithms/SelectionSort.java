
public class SelectionSort
{
	public static void PrintArray(int array[], int length)
	{
		for(int I = 0; I < length; I++)
		{
			System.out.println(array[I]);
		}
	}

	public static void main(String[] args)
	{
		int iaArray[] = {1, 21, 32, 43, -10};
		int iLength = 5;
		// Selection Sort algorithm
		for(int I = 0; I < iLength - 1; I++)
		{
			int iSmallest = I;
			for(int j = I + 1; j < iLength; j++)
			{
				if(iaArray[iSmallest] > iaArray[j])
				{
					iSmallest = j;
				}
			}
			//swap - put the smallest remaining
			//in the ith position
			int iSwap = iaArray[iSmallest];
			iaArray[iSmallest] = iaArray[I];
			iaArray[I] = iSwap;
		}
		PrintArray(iaArray, iLength);
	}
}
