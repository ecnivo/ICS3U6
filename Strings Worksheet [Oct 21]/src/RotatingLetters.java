import java.util.Scanner;
import java.io.*;

/**
 * Finds if all letters in a String are rotation-compatible
 * @author Vince Ou
 * @version October 2014
 */

public class RotatingLetters
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// Gets input from text file and finds number of test cases
		Scanner inputFile = new Scanner(new File("rotateNew.txt"));
		int noOfCases = inputFile.nextInt();
		inputFile.nextLine();

		// Loops to go through every test case
		for (int caseCounter = 1; caseCounter <= noOfCases; caseCounter++)
		{
			// Converts entire string to lower case for easier processing
			String inputLine = inputFile.nextLine().toLowerCase();

			if (rotate(inputLine))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		inputFile.close();
	}

	/**
	 * Goes through the string to find if letters are not matching
	 * @param line given String to find if it is mirror-compatible
	 * @return returns false if letter does not satisfy condition
	 */
	public static boolean rotate(String line)
	{
		// Goes through characters in the string individually until it finds
		// character that does not satisfy condition
		int lineLength = line.length();
		for (int pos = 0; pos < lineLength; pos++)
		{
			if (!((line.charAt(pos) == 'i') || (line.charAt(pos) == 'o')
					|| (line.charAt(pos) == 's') || (line.charAt(pos) == 'h')
					|| (line.charAt(pos) == 'z') || (line.charAt(pos) == 'x') || (line
						.charAt(pos) == 'n')))
				return false;
		}

		// Returns true if none of the characters do not work
		return true;
	}

}
