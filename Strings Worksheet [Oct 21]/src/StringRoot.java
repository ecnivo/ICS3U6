import java.io.*;
import java.util.Scanner;

/**
 * Finds the root of a string. The string root is the 'base' set of
 * characters that, if concatenated with itself many times, will form the
 * original string
 * @author Vince Ou
 * @version October 2014
 */
public class StringRoot
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Finds input from file and loops through number of test cases
		Scanner inputFile = new Scanner(new File("rootNew.txt"));
		int noOfCases = inputFile.nextInt();
		inputFile.nextLine();
		for (int testCaseCounter = 1; testCaseCounter <= noOfCases; testCaseCounter++)
		{
			
			// Acquires each line of input
			String inputLine = inputFile.nextLine();
			String stringRoot = inputLine.charAt(0) + "";
			int indexOfRoot = 1;

			// Tests first string of characters to see if they are the string
			// root, if they are not, then acqui re the next letter to use as
			// string root
			boolean keepLooping = true;
			while (keepLooping)
			{
				int repeat = inputLine.length() / stringRoot.length();
				String tempString = "";

				// Takes the possible string root and duplicates it each time
				// and compares with original string
				for (int duplicator = 0; duplicator < repeat; duplicator++)
					tempString += stringRoot;
				if (tempString.equals(inputLine))
					keepLooping = false;
				else
				{
					stringRoot = inputLine.substring(0, indexOfRoot + 1);
					indexOfRoot++;
				}
			}
			
			// Prints the string root when found
			System.out.println(stringRoot);
		}
		inputFile.close();
	}

}
