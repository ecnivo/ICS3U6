import java.io.*;
import java.util.Scanner;

/**
 * This program reads in messages from a text file and encrypts them based on a
 * given monoalphabetic cipher
 * @author Vince Ou
 * @version 2014 October
 */
public class Encryption
{

	/**
	 * Encrypts a given message with a monoalphabetic substitution cipher
	 * @param cipher the first letter of this 26-letter String corresponds with
	 *            A, second letter to B, and so on until the last letter
	 *            corresponds with Z
	 * @param message the message intended to be encrypted
	 * @return the encrypted message
	 */
	public static String encrypt(String cipher, String message)
	{
		// Start with a blank string to "build up"
		String encryptedMessage = "";

		// Goes through every character of the message
		int messageLength = message.length();
		for (int pos = 0; pos < messageLength; pos++)
		{
			// Only encrypts the character if it is a letter
			char currentChar = message.charAt(pos);
			if (Character.isLetter(currentChar))
			{
				// Checks for upper or lower case
				if (Character.isLowerCase(currentChar))
					/*
					 * The position of the letter being encrypted in the
					 * alphabet is equal to the index of the encrypted letter in
					 * the cipher, so it subtracts the Unicode value of 'A' or
					 * 'a' of it (depending on lower/upper case) to find its
					 * position within the alphabet and finds the character at
					 * that same location in the cipher. This letter is then
					 * adjusted for case and then appended to the encrypted
					 * message.
					 */
					encryptedMessage += Character.toLowerCase(cipher
							.charAt(currentChar - 'a'));
				else
					encryptedMessage += cipher.charAt(currentChar - 'A');
			}

			// Appends the non-letter character to the string
			else
				encryptedMessage += currentChar;
		}
		return encryptedMessage;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		// Creates a new Scanner and finds the number of test cases
		Scanner inFile = new Scanner(new File("encryptionNew.txt"));
		int testCases = inFile.nextInt();
		inFile.nextLine();

		// Iterates through test cases
		for (int testCaseIterator = 0; testCaseIterator < testCases; testCaseIterator++)
		{
			// Gets the cipher and message, puts it into the method and prints
			// the result
			String cipher = inFile.nextLine();
			String message = inFile.nextLine();
			System.out.println(encrypt(cipher, message));
		}
		inFile.close();
	}
}
