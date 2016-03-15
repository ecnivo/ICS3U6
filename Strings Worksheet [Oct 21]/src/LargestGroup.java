import java.util.Scanner;
/**
*@author Vince Ou
*/
public class LargestGroup
{
	public static int sizeOfLargestGroup(String input)
	{
		int repeatRecord = 1;
		int currentRecord = 1;
		for (int pos = 1; pos <= input.length() - 1; pos++)
		{
			char charHere = input.charAt(pos);
			if (input.charAt(pos - 1) == charHere)
			{
				currentRecord++;
			}
			if (currentRecord > repeatRecord)
				repeatRecord = currentRecord;
		}
		return repeatRecord;
	}

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		while (true)
		{
			System.out.print("input pls ");
			String str = keyboard.nextLine();
			System.out.println(sizeOfLargestGroup(str));
		}
	}

}
