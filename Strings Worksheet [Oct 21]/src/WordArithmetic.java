import java.util.Scanner;
import java.io.*;
import java.math.*;

/**
 * This program finds the "sum" of two words in base-26 and then converted back
 * to a String
 * @author Vince Ou
 * @version 2014-10-24
 */
public class WordArithmetic
{
	/**
	 * Converts a String's value in base-26 according to the letter value and
	 * placement
	 * @param convert given String to convert to base 26
	 * @return the value of convert in base 26
	 */
//	public static double toBase26(String convert)
//	{
//		int convertLength = convert.length();
//		double total = 0;
//
//		// Starts from the last character of the string and multiplies each
//		// character's position in the alphabet by 26 to the exponent of 0, 1,
//		// 2, 3, 4...
//		for (int exponentOrLastPos = 1; exponentOrLastPos <= convertLength; exponentOrLastPos++)
//		{
//			total += (convert.charAt(convertLength - exponentOrLastPos) - 'A')
//					* Math.pow(26, exponentOrLastPos - 1);
//		}
//		return total;
//	}
	
	public static void addToBase26(String word, BigInteger sum)
	{
		BigInteger wordTotal = new BigInteger("0");
		BigInteger twentySix = new BigInteger("26");
		for (int reversePos = 1; reversePos <= word.length(); reversePos++)
		{
			int index = word.charAt(word.length() - reversePos) - 'A';
			BigInteger indexInAlphabet = new BigInteger(String.valueOf(index));
			wordTotal = wordTotal.add(indexInAlphabet.multiply(twentySix.pow(reversePos - 1)));
			sum = sum.add(wordTotal);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File("wordsNew.txt"));
		BigInteger twentySix = new BigInteger("26");
		for (int noOfCases = 0; noOfCases < 5; noOfCases++)
		{
			String word1 = inFile.next();
			String word2 = inFile.next();

			BigInteger sum = new BigInteger("0");
			addToBase26(word1, sum);
			addToBase26(word2, sum);
//			double wordTotal = toBase26(word1) + toBase26(word2);

			// Uses base-26 to convert words' total to one word; using remainder
			// and integer division
			int currentBase = 26;
			String outputString = "";

			// Multiplies the base (of 26) by itself each time to find each
			// increasing place value
			BigInteger modValue = new BigInteger("");
			while (sum.compareTo(twentySix) > -1)
			{
				modValue = sum.mod(twentySix);
				outputString = (char) ((modValue.intValue()) + 'A') + outputString;
				sum = sum.divide(twentySix);
				currentBase *= 26;
			}

			// Appends the last remaining character onto the output String
			modValue = sum.mod(twentySix);
			outputString = (char) (modValue.intValue() + 'A') + outputString;
			System.out.println(outputString);

		}
		inFile.close();
	}
}
