import java.util.Arrays;
import java.util.Scanner;

/**
*@author Vince Ou
*/
public class AnagramCheck
{

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String lineOne = keyboard.nextLine();
		String lineTwo = keyboard.nextLine();
		int[] oneAlphabet = new int[26];
		int[] twoAlphabet = new int[26];
		for (int stringPosition = 0; stringPosition < lineOne.length(); stringPosition++)
		{
			char letter = lineOne.charAt(stringPosition);
			if (!(letter == ' '))
				oneAlphabet[letter - 'A']++;
		}
		for (int stringPosition = 0; stringPosition < lineTwo.length(); stringPosition++)
		{
			char letter = lineTwo.charAt(stringPosition);
			if (!(letter == ' '))
				twoAlphabet[letter - 'A']++;
		}
		if (Arrays.equals(oneAlphabet, twoAlphabet))
			System.out.println("Is an anagram.");
		else
			System.out.println("Is not an anagram.");
	}

}
