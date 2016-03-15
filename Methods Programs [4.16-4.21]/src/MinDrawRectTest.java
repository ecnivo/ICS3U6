/**
 * The "MinDrawRectTest" class. Purpose: To test the min and drawRect methods
 * 
 * @author main by Ridout, methods by Vince Ou
 * @version October 2014
 */
public class MinDrawRectTest
{
	/**
	 * This method finds the smallest value of three integers
	 * @param firstNumber 	the first number
	 * @param secondNumber 	the second number
	 * @param thirdNumber 	the third number
	 * @return 				the smallest value of three numbers
	 */
	private static int min(int firstNumber, int secondNumber, int thirdNumber)
	{
		// Using if statements, find the smallest of three numbers
		if (firstNumber <= secondNumber && firstNumber <= thirdNumber)
			return firstNumber;
		else if (secondNumber <= thirdNumber)
			return secondNumber;
		else
			return thirdNumber;
	}

	/**
	 * This method prints a rectangle of given height and width using asterisks
	 * @param width 						width of desired rectangle
	 * @param height 						height of desired rectangle
	 * @throws IllegalArgumentException 	when height or width are non-negative
	 */
	private static void drawRect(int width, int height)
	{

		// Throws exception if the rectangle has negative values
		if (width < 0 || height < 0)
		{
			throw new IllegalArgumentException(
					"Rectangle dimensions must be non-negative");
		}

		// Draw rectangle, width first, then height
		for (int heightIterator = 0; heightIterator < height; heightIterator++)
		{
			for (int widthIterator = 0; widthIterator < width; widthIterator++)
				System.out.print("*");
			System.out.println();
		}
	}

	// Do not modify the main program code below
	public static void main(String[] args)
	{
		System.out.println("Testing the min Method\n");
		System.out.println(min(4, 5, 6));
		System.out.println(min(8, 5, 6));
		System.out.println(min(11, 9, 6));
		System.out.println(min(7, 7, 7));
		System.out.println(min(8, 8, 9));
		System.out.println(min(9, 10, 9));
		System.out.println(min(12, 10, 10));

		System.out.println("Testing the drawRect Method\n");
		drawRect(1, 1);
		System.out.println();
		drawRect(3, 4);
		System.out.println();
		drawRect(4, 3);
		System.out.println();
		drawRect(5, 1);
		System.out.println();
		drawRect(1, 3);
		System.out.println();
		drawRect(0, 1);
		System.out.println();
		// Should end program by throwing an Exception
		// with an appropriate message
		drawRect(8, -1); 

		System.out.println("\nTest Program is complete");
	} // main method
} // MinDrawRectTest class

