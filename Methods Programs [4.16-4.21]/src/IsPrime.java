import java.util.Scanner;

/**
 * This program finds out if a number is prime or composite
 * @author Vince Ou
 * @version 2014-10-10
 */

public class IsPrime
{
	/**
	 * This method determines if a number is prime or composite
	 * @param number given long to find if it's prime or composite
	 * @return boolean value 'true' if a number is prime
	 */
	public static boolean isPrime(int number)
	{
		// Does two basic checks to see if number is divisible by 2 or 3; makes
		// method faster
		if (number <= 3)
			return number > 1;
		else if (number % 2 == 0 || number % 3 == 0)
			return false;
	
		/*
		 * The above allows this part to increment by 2, testing divisibility by
		 * every odd number (instead of all numbers, therefore does half the
		 * checking) from 5 to the square root of the number (all in interests
		 * of making method faster).
		 */
		int numberSqrt = (int) Math.sqrt(number) + 1;
		for (int primeChecker = 5; primeChecker < numberSqrt; primeChecker += 2)
			if (number % primeChecker == 0)
				return false;
		return true;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		// Print title and get input from user
		System.out.println("WELCOME TO VINCE'S PRIME FINDER");
		Scanner keyboard = new Scanner(System.in);
		while (true)
		{
			System.out.print("Enter a number to find if it's prime: ");
			int number = keyboard.nextInt();

			// Formats output statements
			if (isPrime(number))
				System.out.println(number + " is prime");
			else
				System.out.println(number + " is not prime");
			System.out.println("Thanks for using Vince's Prime Finder\n");
		}
	}

}
