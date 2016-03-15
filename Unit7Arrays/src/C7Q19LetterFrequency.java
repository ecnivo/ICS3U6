import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Finds the occurrences of certain letters in a text file, and displays their
 * frequencies
 * @author Vince Ou
 * @version December 2014
 */
public class C7Q19LetterFrequency
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Prints title, and creates Scanner to ask for file input
		System.out.println("          Letter Frequency Analysis");
		System.out.println("");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("File name: ");
		Scanner fileIn = new Scanner(new File(keyboard.nextLine()));
		System.out.println("");
		
//		long startTime = System.nanoTime();

		// Creates the letter array and the frequency array, as well as the number of letters
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		long[] frequency = new long[26];
		double total = 0;

		// Analyzes each line of text file
		while (fileIn.hasNextLine())
		{
			String line = fileIn.nextLine();
			line = line.toUpperCase();
			for (int charPos = 0; charPos < line.length(); charPos++)
			{
				// Increment element for the proper letter, disregards non-letters
				if (line.charAt(charPos) >= 'A' && line.charAt(charPos) <= 'Z')
				{
					frequency[(int) (line.charAt(charPos) - 'A')]++;
					total++;
				}
			}
		}
		// Sorts the arrays
		sortDoubleArray(letters, frequency);

		// Prints output headers
		System.out.println("     Letter   Frequency   Percentage");
		double totalPercent = 0;
		// Loops through every letter and prints their percentages
		for (int index = 0; index < letters.length; index++)
		{
			System.out.printf("        %-4c  %9d     %6.2f%%\n", letters[index],
					frequency[index], frequency[index] / total * 100.0);
			totalPercent += frequency[index] / total * 100;
		}

		// Concluding statement
		System.out.printf("\n    Totals       %-9.0f  %.2f%%", total, totalPercent);
		System.out.println('\n');
		System.out.println("End of File Analysis");
		
//		long endTime = System.nanoTime();
//		System.out.println("TOOK" + (endTime - startTime) / 1000000 + "ms");
		
		keyboard.close();
		fileIn.close();
	}

	/**
	 * Sorts the two parallel arrays by frequency, highest to lowest
	 * @param characters the "slave" array, that is used to match the frequency
	 *            to letter
	 * @param freq "master" array that is being  sorted
	 */
	public static void sortDoubleArray(char[] characters, long[] freq)
	{
		// Iterates through all indexes of the master array
		for (int i = 0; i < freq.length; i++)
		{
			// Compares each index to the next index, and finds the next
			// largest
			int largestIndex = i;
			for (int checkIndex = i; checkIndex < freq.length; checkIndex++)
			{
				if (freq[checkIndex] > freq[largestIndex])
				{
					largestIndex = checkIndex;
				}
			}

			// Swaps indexes in the master array
			long tempLong = freq[i];
			freq[i] = freq[largestIndex];
			freq[largestIndex] = tempLong;

			// Sways indexes in the slave array
			char tempChar = characters[i];
			characters[i] = characters[largestIndex];
			characters[largestIndex] = tempChar;
		}
	}

}
