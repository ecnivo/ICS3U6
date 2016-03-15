import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** The "DistanceBetweenTest" class.
  * Purpose: To test distanceBetween() method
  * @author main by Ridout, methods by Vince Ou
  * @version October 2014
 */
public class DistanceBetweenTest
{
	/**
	 * Finds the distance between two provided points on a Cartesian grid
	 * @param xOne	Point 1's x value
	 * @param yOne	Point 1's y value
	 * @param xTwo	Point 2's x value
	 * @param yTwo	Point 2's y value
	 * @return		The distance between the two input points
	 */
	private static double distanceBetween(double xOne, double yOne, double xTwo, double yTwo)
	{
		return Math.sqrt(Math.pow(xTwo - xOne, 2) + Math.pow(yOne - yTwo, 2));
	}
	
    // Do not modify the main program code below
    public static void main (String [] args) throws FileNotFoundException
    {
	System.out.println ("Testing the Methods\n");

	// Test distanceBetween first
	System.out.println ("Testing distanceBetween()...");

	// Open the distanceBetween test file for input
	Scanner fileIn = new Scanner (new File("distanceBetweenData.txt"));

	int noOfCorrect = 0;
	int testCase = 1;
	while (fileIn.hasNextDouble())
	{
	    double x1 = fileIn.nextDouble ();
	    double y1 = fileIn.nextDouble ();
	    double x2 = fileIn.nextDouble ();
	    double y2 = fileIn.nextDouble ();
	    double correctDistance = fileIn.nextDouble ();

	    double distance = distanceBetween (x1, y1, x2, y2);
	    System.out.printf ("%d) Distance between (%.1f, %.1f) and (%.1f, %.1f)"
		    + " is approximately: %.3f", testCase, x1,y1, x2, y2, distance);

	    // Allows a little rounding error
	    if (Math.abs (distance - correctDistance) < 0.00000000001)
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
} // DistanceBetweenTest class


