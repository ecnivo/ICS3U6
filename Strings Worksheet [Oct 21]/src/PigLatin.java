import java.util.Scanner;
import java.io.*;

/**
 * This program takes an English phrase from a text file and translates and
 * outputs it into Pig Latin in a text file
 * @author Vince Ou
 * @version October 2014
 */
public class PigLatin
{
	/**
	 * Converts an English word into Pig Latin, with capitals, but no
	 * punctuation support.
	 * @param inputString given English word
	 * @return the English word converted to Pig Latin
	 */
	public static String pigLatin(String inputString)
	{
		// Finds location of initial sound
		int vowelPos = firstVowel(inputString);
		String initialSound;

		// Returns immediately if it starts with vowel
		if (vowelPos == 0)
			return inputString + "way";
		else
			// Establishes a string for the initial sound
			initialSound = inputString.substring(0, vowelPos).toLowerCase();

		// Acquires the case of the first letter
		boolean caps;
		if ((int) (inputString.charAt(0)) < 96)
			caps = true;
		else
			caps = false;
		inputString = inputString.toLowerCase();

		// Start constructing output string by initializing it to be the
		// substring after the initial sound
		String outputString = inputString.substring(initialSound.length());

		// Concatenate outputString with the initial sound and "ay"
		outputString += initialSound + "ay";

		// Apply capitalization as necessary
		if (caps)
			outputString = (char) (outputString.charAt(0) - 32)
					+ outputString.substring(1);

		return outputString;
	}

	/**
	 * Finds the index of the first vowel in the string
	 * @param inputString given string to find its first vowel index
	 * @return integer value for the first vowel within a string
	 */
	public static int firstVowel(String inputString)
	{
		// Converts entire string to lowercase, gets its length
		inputString = inputString.toLowerCase();
		int length = inputString.length();

		// Special cases for 'y' because it's a weird vowel and "qu" because 'q'
		// is weird. Adds placeholders for these letters in the String.
		if (inputString.charAt(0) == 'y')
			inputString = "x" + inputString.substring(1);
		else if (inputString.charAt(0) == 'q' && inputString.charAt(1) == 'u')
			inputString = "xx" + inputString.substring(2);

		// Checks each character to see if it is a vowel.
		// If it is vowel, return immediately
		for (int pos = 0; pos < length; pos++)
		{
			char charHere = inputString.charAt(pos);
			if (charHere == 'a' || charHere == 'o' || charHere == 'e'
					|| charHere == 'u' || charHere == 'i' || charHere == 'y')
				return pos;
		}

		// Laws of English dictate all words have vowel. If no vowel, returns -1
		return 0;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		// Creates a new Scanner for file input and output and finds the number
		// of test cases
		Scanner inFile = new Scanner(new File("English.txt"));
		int noOfCases = inFile.nextInt();
		inFile.nextLine();
		PrintWriter outFile = new PrintWriter("pigLatin.txt");

		// Iterates through test cases
		for (int testCaseNumber = 0; testCaseNumber < noOfCases; testCaseNumber++)
		{
			// Creates new Scanner to check for more data within a String
			Scanner lineScan = new Scanner(inFile.nextLine());
			while (lineScan.hasNext())
			{
				String currentWord = lineScan.next();

				// Uses pigLatin method to convert the current word into Pig
				// Latin
				outFile.print(pigLatin(currentWord));
				if (lineScan.hasNext())
					outFile.print(' ');
			}
			// Starts new line, and adds test for if it is the last test case;
			// if it is the last test case, it will not append a new line
			if (testCaseNumber != noOfCases - 1)
				outFile.print("\n");
			lineScan.close();
		}
		inFile.close();
		outFile.close();
	}
}