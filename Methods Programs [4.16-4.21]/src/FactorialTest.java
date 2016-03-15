import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** The "FactorialTest" class.
  * Purpose: To test factorial() method
  * @author main by Ridout, methods by
  * @version October 2013
 */
public class FactorialTest
{
	/**
	 * This method finds the factorial of a given integer, that factorial must
	 * be less than the long limit
	 * @param number number to find its factorial
	 * @return number's factorial
	 * @throws IllegalArgumentException when the number is negative
	 */
	public static long factorial(int number)
	{
		// Negative numbers don't have a factorial, throws exception accordingly
		if (number < 0)
			throw new IllegalArgumentException("Negative numbers not supported");

		// numberFactorial (output) is multiplied by multiplier. Multiplier is
		// iteratively decreased.
		long numberFactorial = 1;
		for (int multiplier = number; multiplier > 1; multiplier--)
			numberFactorial *= multiplier;
		return numberFactorial;
	}
	
    // Do not modify the main program code below
    public static void main (String [] args) throws FileNotFoundException
    {
	System.out.println ("Testing the Methods\n");

	System.out.println ("Testing factorial()...");

	// Open the distanceBetween test file for input
	Scanner fileIn = new Scanner (new File("factorialData.txt"));
	int noOfCorrect = 0;
	double factorial;
	int testCase = 1;
	while (fileIn.hasNextInt())
	{
	    int number = fileIn.nextInt ();
	    double correctFactorial = fileIn.nextDouble ();

	    try
	    {
		factorial = factorial (number);
		System.out.print (testCase + ") " + number + "! = " + factorial (number));
	    }
	    catch (IllegalArgumentException e)
	    {
		// Tests the thrown exception
		System.out.print (testCase + ") " + number + "! is undefined (IllegalArgumentException was thrown)");
		factorial = -99; // Meaningless value for to handle code below
	    }


	    // Allows a little rounding error
	    if (Math.abs (factorial - correctFactorial) < 0.0000000001)
	    {
		noOfCorrect++;
		System.out.println (" OK ");  // Check
	    }
	    else
	    {
		System.out.println (" INCORRECT ");  // X
	    }
	    testCase++;
	}
	// Close the input file ASAP
	fileIn.close ();

	System.out.println ("\nYou got " + noOfCorrect + " out of "
		+ (testCase - 1) + " correct");
	System.out.println ("\nTest Program is complete");
    } // main method
} // FactorialTest class


