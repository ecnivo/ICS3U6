import java.util.Scanner;

/**
 * This program finds the factorial of a number (eg. 5 factorial = 5 * 4 * 3 * 2
 * * 1)
 * @author Vince Ou
 * @version 2014-10-09
 */

public class Factorial
{
	/**
	 * This method finds the factorial of a given integer, that factorial must
	 * be less than the long limit
	 * @param number number to find its factorial
	 * @return number's factorial
	 * @throws IllegalArgumentException when the number is negative
	 */
	public static long factorial(int number)
	{
		// Negative numbers don't have a factorial, throws exception accordingly
		if (number < 0)
			throw new IllegalArgumentException("Negative numbers not supported");

		// numberFactorial (output) is multiplied by multiplier. Multiplier is
		// iteratively decreased.
		long numberFactorial = 1;
		for (int multiplier = number; multiplier > 1; multiplier--)
			numberFactorial *= multiplier;
		return numberFactorial;
	}

	public static void main(String[] args)
	{
		// Print title and get user input
		System.out.println("Welcome to the Factorial Calculator");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your number to find its factorial: ");
		int userInput = keyboard.nextInt();

		// Finds factorial and prints output
		long factorialResult = factorial(userInput);
		System.out.println("The factorial of " + userInput + " is "
				+ factorialResult);
		System.out.println("Thank you for using the Factorial Finder");
		keyboard.close();
	}

}
