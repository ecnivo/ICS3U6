import java.io.File;
import java.lang.Math;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The "HighestCommonFactorTest" class. Purpose: To test highestCommonFactor()
 * method
 * @author main by Ridout, methods by Vince Ou
 * @version March 2014
 */
public class HighestCommonFactorTest
{
	/**
	 * This method finds the highest common factor using Euclid's method; given
	 * numbers don't have to be in order
	 * @param firstNumber given first number
	 * @param seondNumber given second number
	 * @return highest common factor of the two numbers
	 */
	private static int highestCommonFactor(int firstNumber, int secondNumber)
	{
		// Converts numbers to positive
		firstNumber = Math.abs(firstNumber);
		secondNumber = Math.abs(secondNumber);
	
		// If the numbers are both zero, then return 'infinity'
		if (firstNumber == 0 && secondNumber == 0)
			return Integer.MAX_VALUE;
	
		/*
		 * Using Euclid's method, find the highest common factor Euclid's method
		 * uses the two numbers, and the second number becomes the remainder
		 * between the first and second, and the first becomes the second
		 * number. This is repeated until the remainder is zero.
		 */
		while (secondNumber != 0)
		{
			int clonedFirstNumber = firstNumber;
			firstNumber = secondNumber;
			secondNumber = clonedFirstNumber % secondNumber;
		}
		return firstNumber;
	}

	// Do not modify the main program code below
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Testing the Methods\n");

		System.out.println("Testing highestCommonFactor()...");

		// Open the hcfData.txt test file for input
		Scanner fileIn = new Scanner(new File("hcfData.txt"));
		int noOfCorrect = 0;
		int testCase = 1;
		while (fileIn.hasNextInt())
		{
			int first = fileIn.nextInt();
			int second = fileIn.nextInt();
			int correctHCF = fileIn.nextInt();

			int hcf = highestCommonFactor(first, second);
			System.out.print(testCase + ")  For " + first + " and " + second
					+ " the hcf is: " + hcf);

			// Allows a little rounding error
			if (hcf == correctHCF)
			{
				noOfCorrect++;
				System.out.println(" OK "); // Check
			}
			else
			{
				System.out.println(" INCORRECT "); // X
			}
			testCase++;
		}
		// Close the input file ASAP
		fileIn.close();

		System.out.println("\nYou got " + noOfCorrect + " out of "
				+ (testCase - 1) + " correct");
		System.out.println("\nTest Program is complete");
	} // main method
} // HighestCommonFactorTest class

