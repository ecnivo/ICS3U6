import java.util.Arrays;
import java.util.Scanner;

public class Anagram
{

	public static void main(String[] args)
	{
		// Simple input
		System.out.print("Enter first word: ");
		Scanner keyboard = new Scanner(System.in);
		String wordOne = keyboard.next().toLowerCase(); // Note to lower case
		System.out.print("enter second word: ");
		String wordTwo = keyboard.next().toLowerCase();

		// Stores the frequency of letters in each word
		int[] firstFrequency = new int[26];
		int[] secondFrequency = new int[26];

		// Iterates through all characters of first word, and then increments
		// the frequency
		for (int one = 0; one < wordOne.length(); one++)
		{
			firstFrequency[(int) (wordOne.charAt(one) - 'a')]++;
		}
		// Repeat above for loop for the second word
		for (int two = 0; two < wordTwo.length(); two++)
		{
			secondFrequency[(int) (wordTwo.charAt(two) - 'a')]++;
		}

		if (Arrays.equals(firstFrequency, secondFrequency))
			System.out.println("Is anagram");
		else
			System.out.println("Not anagram");
		
		keyboard.close();
	}

}
