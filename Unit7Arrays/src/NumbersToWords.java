import java.util.Scanner;

public class NumbersToWords
{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		while (true)
		{
			String[] oneToTwenty = { "", "One", "Two", "Three", "Four", "Five",
					"Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
					"Thirteen", "Fourteen", "Fifteen", "Sixteen,", "Seventeen",
					"Eighteen", "Nineteen" };
			String[] tens = { "", "", "Twenty", "Thirty", "Forty" };

			int number = keyboard.nextInt();

			if (number < 20)
				System.out.println(oneToTwenty[number]);
			else
				System.out.println(tens[number / 10] + ' '
						+ oneToTwenty[number % 10]);
		}

	}

}
