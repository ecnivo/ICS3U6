import java.io.*;
import java.util.Scanner;

/**
 * Finds, using arbitrary rules, whether or not a given string is in French or
 * English text.
 * @author Vince Ou
 * @version October 2014
 */
public class EnglishOrFrench
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// Gets input from text file and loops through number of test cases
		Scanner inputFile = new Scanner(new File("languageNew.txt"));
		for (int testCaseCounter = 1; testCaseCounter <= 5; testCaseCounter++)
		{
			int noOfLines = inputFile.nextInt();
			inputFile.nextLine();

			// Counter totals for number of T's and S's
			int noOfS = 0;
			int noOfT = 0;

			// Checks each letter in each line of test case and finds if it is a
			// T or S, and adds to the total accordingly
			for (int lineCounter = 0; lineCounter < noOfLines; lineCounter++)
			{
				String line = inputFile.nextLine();
				line = line.toUpperCase();
				int lineLength = line.length();
				for (int pos = 0; pos < lineLength; pos++)
				{
					if (line.charAt(pos) == 'S')
						noOfS++;
					else if (line.charAt(pos) == 'T')
						noOfT++;
				}
			}

			// Print true or false depending on condition
			if (noOfT > noOfS)
				System.out.println("English");
			else
				System.out.println("French");
		}
		inputFile.close();
	}
}
