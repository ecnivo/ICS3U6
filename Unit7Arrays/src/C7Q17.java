
public class C7Q17
{

	public static void main(String[] args)
	{
		int[] testArray = {2,1,5,3,1,85,6,84,3,48,1};
//		int[] testArray = createArray(20, -2, 10);
		showArray(testArray);
		int[] subArray = {85,6};
		System.out.println(indexOfSubArray(testArray, subArray));
		
	}
	
	public static int indexOfSubArray(int[] bigArray, int[] subArray)
	{
		for (int index = 0; index < bigArray.length - subArray.length + 1; index++)
		{
			if (bigArray[index] == subArray[0])
			{
				int checkIndex = 0;
//				while (bigArray[index + checkIndex] == subArray[checkIndex] && checkIndex < subArray.length)
				while (checkIndex < subArray.length && bigArray[index + checkIndex] == subArray[checkIndex])
				{
					checkIndex++;
				}
				
				if (checkIndex == subArray.length)
					return index;
			}
		}
		return -1;
	}
	
	public static int[] createArray(int elements, int min, int max)
	{
		// Creates a new array with necessary length
		int range = max - min;
		int[] randArray = new int[elements];

		// Goes through each index in the array and assigns it a random value
		for (int insert = 0; insert < elements; insert++)
			randArray[insert] = (int) (Math.random() * range + min);
		return randArray;
	}
	
	public static void showArray(int[] arrayIn)
	{
		// Opening square bracket
		System.out.print('[');
		// Goes through each value, and uses printf's indentation to display
		for (int index = 0; index < arrayIn.length - 1; index++)
			System.out.printf("%-2d, ", arrayIn[index]);

		// Special case for the last element in the array so there's no extra
		// space at the end
		System.out.printf("%d", arrayIn[arrayIn.length - 1]);

		// Closing square bracket
		System.out.println("]");
	}
}
