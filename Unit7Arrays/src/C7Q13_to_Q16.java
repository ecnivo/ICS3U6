public class C7Q13_to_Q16
{

	public static void main(String[] args)
	{
		// // Creates first list, sorts it, and prints it
		// double[] firstList = generateArray(15, 0, 50);
		// System.out.println(indexOfSmallest(firstList));
		// selectionSort(firstList);
		// printArray(firstList);
		//
		// // Average of first list
		// System.out.println(averageOfArray(firstList));
		//
		// // Creates second array, sorts it, and merges it with first, and
		// prints
		// // it
		// double[] secondList = generateArray(15, 0, 50);
		// selectionSort(secondList);
		// double[] merged = mergeArray(firstList, secondList);
		// printArray(merged);
		//
		// System.out.println("");

		// Title and Introduction
		System.out.println("                  Using Methods with Arrays");

		// Generate an array of 30 doubles between 1 and 100
		double[] firstList = generateArray(30, 1, 100);

		// Display the array in nice columns in the given Console
		System.out.println("Here are the numbers: ");
		printArray(firstList);

		// Find and display the average of the numbers in the array
		System.out.printf("The average of the array numbers is %.2f%n",
				averageOfArray(firstList));

		// Find and display the index and value of the smallest number
		int index = indexOfSmallest(firstList);
		System.out.print("\nThe index of the smallest number is: ");
		System.out.println(index);
		System.out.printf("The smallest number is: %.2f%n",
				firstList[index]);

		// Sort and then display the array
		selectionSort(firstList);
		System.out.println("\nHere is the sorted array: ");
		printArray(firstList);

		// Generate a second array of 25 elements between -100 and 100
		// and sort this second list
		double[] secondList = generateArray(25, -100, 100);
		selectionSort(secondList);

		// Merge the two sorted arrays into a single sorted array
		double[] mergedList = mergeArray(firstList, secondList);

		// Display the merged array
		System.out.println("Here is the merged array: ");
		printArray(mergedList);

		// Closing Remarks
		System.out.println("The Arrays Methods Program is Complete");
	}

	/**
	 * Generates a random array with specified length, minimum and maximum value
	 * @param elements number of elements desired array to be in
	 * @param min smallest number
	 * @param max largest number
	 * @return the generated array
	 */
	public static double[] generateArray(int elements, double min, double max)
	{
		// Creates a new array with necessary length
		double range = max - min;
		double[] randArray = new double[elements];

		// Goes through each index in the array and assigns it a random value
		for (int insert = 0; insert < elements; insert++)
			randArray[insert] = Math.random() * range + min;
		return randArray;
	}

	/**
	 * Shows a 1-D array with five digit support
	 * @param arrayIn The array to display
	 */
//	public static void printArray(double[] arrayIn)
//	{
//		// Opening square bracket
//		System.out.print('[');
//		// Goes through each value, and uses printf's indentation to display
//		for (int index = 0; index < arrayIn.length - 1; index++)
//			System.out.printf("%-6.3f ", arrayIn[index]);
//
//		// Special case for the last element in the array so there's no extra
//		// space at the end
//		System.out.printf("%.3f", arrayIn[arrayIn.length - 1]);
//
//		// Closing square bracket
//		System.out.println("]");
//	}

	static void printArray(double[] list)
	{
		for (int index = 0; index < list.length; index++)
		{
			System.out.printf("%10.2f", list[index]);
			if ((index + 1) % 8 == 0)
				System.out.println();
		}
		System.out.println();
	}

	/**
	 * Finds the average of all values in the array
	 * @param arrayIn The array to find average values of
	 * @return Average of values inside array
	 */
	public static double averageOfArray(double[] arrayIn)
	{
		// Adds array's elements together
		double sum = 0;
		for (int i = 0; i < arrayIn.length; i++)
		{
			sum += arrayIn[i];
		}

		// Divides as necessary
		return sum / arrayIn.length;
	}

	/**
	 * Finds the smallest element in the array's index
	 * @param arrayIn Array to find smallest index
	 * @return The index of the smallest value
	 */
	public static int indexOfSmallest(double[] arrayIn)
	{
		// Assumes first value is smallest
		int indexOfSmallest = 0;

		// Goes through each index and compares it to the index of smallest
		for (int i = 0; i < arrayIn.length; i++)
		{
			if (arrayIn[i] < arrayIn[indexOfSmallest])
				indexOfSmallest = i;
		}
		return indexOfSmallest;
	}

	/**
	 * Sorts an array with lowest values first
	 * @param array array to sort
	 * @return the sorted array
	 */
	public static double[] selectionSort(double[] array)
	{
		// Goes through each element of the sorted array
		for (int next = 0; next < array.length - 1; next++)
		{
			// Compares each index to the next index, and finds the next
			// smallest
			int smallIndex = next;
			for (int checkIndex = next + 1; checkIndex < array.length; checkIndex++)
			{
				if (array[checkIndex] < array[smallIndex])
					smallIndex = checkIndex;
			}

			// Swaps the next smallest element with the current index
			double temp = array[smallIndex];
			array[smallIndex] = array[next];
			array[next] = temp;
		}

		return array;
	}

	/**
	 * Returns the merged, sorted, of two arrays, assuming they're sorted to
	 * start with
	 * @param firstArray One array
	 * @param secondArray Another array
	 * @return The two arrays combined and sorted
	 */
	public static double[] mergeArray(double[] firstArray, double[] secondArray)
	{
		// Creates new, return array and trackers for position in all three
		// array
		double[] mergedArray = new double[firstArray.length
				+ secondArray.length];
		int firstIndex = 0;
		int secondIndex = 0;
		int mergedIndex = 0;

		// Goes through the elements in each of the two arrays and pulls from
		// the two input arrays comparing the first values
		while (firstIndex < firstArray.length
				&& secondIndex < secondArray.length)
		{
			// Puts the value from first array into merged array
			if (firstArray[firstIndex] > secondArray[secondIndex])
			{
				mergedArray[mergedIndex] = secondArray[secondIndex];
				secondIndex++;
			}
			// Puts the value from second array into merged array
			else
			{
				mergedArray[mergedIndex] = firstArray[firstIndex];
				firstIndex++;
			}
			mergedIndex++;
		}

		// When one array is empty, it "shunts" the rest of the other array into
		// the merged array
		if (firstIndex < firstArray.length)
		{
			for (int i = firstIndex; i < firstArray.length; i++)
			{
				mergedArray[mergedIndex] = firstArray[i];
				mergedIndex++;
			}
		}
		else
		{
			for (int i = secondIndex; i < secondArray.length; i++)
			{
				mergedArray[mergedIndex] = secondArray[i];
				mergedIndex++;
			}
		}

		return mergedArray;
	}

	/**
	 * Finds index of a certain target element in an array
	 * @param numbers an array of integers to find the value
	 * @param target the number to be found
	 * @return the index of a certain number in the array
	 */
	public static int findIndexof(int[] numbers, int target)
	{
		// Goes through all the elements in the array and checks
		for (int index = 0; index < numbers.length; index++)
		{
			// If it is a match, return and quit program.
			if (numbers[index] == target)
			{
				return target;
			}
		}
		// Returns -1 if the value is not found
		return -1;
	}

	/**
	 * Removes a number's first from an integer array
	 * @param numbers An array of integers to process
	 * @param target The number to be removed
	 * @return The array with the desired values removed
	 */
	public static int[] removeFromArray(int[] numbers, int target)
	{
		// Uses the findIndexOf to find the place where the target is
		int foundIndex = findIndexof(numbers, target);
		// If not found, just returns the original array
		if (foundIndex == -1)
			return numbers;
		// If found, then creates a new array that is for values immediately in
		// front and behind the element, excluding the element itself
		else
		{
			int[] output = new int[numbers.length - 1];
			for (int beforeIndex = 0; beforeIndex < foundIndex; beforeIndex++)
			{
				output[beforeIndex] = numbers[beforeIndex];
			}
			for (int afterIndex = foundIndex; afterIndex < numbers.length; afterIndex++)
			{
				output[afterIndex - 1] = numbers[afterIndex];
			}
			return output;
		}
	}
}
