import java.util.Scanner;

/**
 * This program finds the number of primes within a given integer 
 * @author Vince Ou
 * @version October 2014
 */
public class IsPrimeTest
{
	private static int noOfPrimes(int number)
	{
		int noOfPrimes;
		if(number > 2)
			noOfPrimes = 1;
		else
			noOfPrimes = 0;
		for (int i = 3; i <= number; i += 2)
		{
			if (IsPrime.isPrime(i))
			{
				noOfPrimes++;
//				System.out.print(i);
//				System.out.println(" " + noOfPrimes);
			}
		}
		return noOfPrimes;
	}

	
	public static void main(String[] args)
	{
		System.out.print("Enter number: ");
		Scanner keyboard = new Scanner(System.in);
		int inputNumber = keyboard.nextInt();
		double startTime = System.currentTimeMillis();
		System.out.println(noOfPrimes(inputNumber));
//		System.out.println(noOfPrimes(Integer.MAX_VALUE));
		System.out.println(System.currentTimeMillis() - startTime);
		keyboard.close();
	}
}