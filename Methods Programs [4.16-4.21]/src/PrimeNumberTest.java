/** The "PrimeNumberTest" class.
  * Purpose: To write an efficient method for checking if a number is prime
  * @author Ridout and ...
  * @version October 2013
 */

public class PrimeNumberTest
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
	
    // Do not modify the main program
    public static void main (String[] args)
    {
	System.out.println ("Testing the isPrime Method\n");

	System.out.println ("Test that the code works");
	int[] numbersToCheck = { - 3, 0, 1, 2, 3,
	    4, 5, 7, 9, 10, 11, 1123231, 1999073521, 2147483647};
	boolean[] primeOrNot = {false, false, false, true, true,
	    false, true, true, false, false, true, true, false, true};
	    
	//             int[] numbersToCheck = { - 2147483648, -1, 0, 1, 2, 4, 20, 7, 25, 37,
	//     2147483629, 2147117569, 2147483647};
	// boolean[] isAPrime = {false, false, false, false, true, false, false, true,
	//     false, true, true, false, true};

	int noOfWrong = 0;
	for (int testCase = 0 ; testCase < numbersToCheck.length ; testCase++)
	{
	    System.out.print (numbersToCheck [testCase]);
	    System.out.print (": " + isPrime (numbersToCheck [testCase]));
	    if (isPrime (numbersToCheck [testCase]) == primeOrNot [testCase])
	    {
		System.out.println (" correct ");  // Check
	    }
	    else
	    {
		noOfWrong++;
		System.out.println (" wrong ");  // X
	    }
	}

	System.out.println ("No of incorrect answers: " + noOfWrong);


	// Upper limit for number of primes
	final int UPPER_LIMIT = 1000000;

	// Find and display the number of prime numbers between
	// -10 and the upper limit. Also times how long this takes
	System.out.println ("\nFind and count the number of Prime Numbers less than "
		+ UPPER_LIMIT);
	long startTime = System.nanoTime ();

	int primeCount = 0;
	for (int number = -10 ; number <= UPPER_LIMIT ; number++)
	    if (isPrime (number))
		primeCount++;

	long endTime = System.nanoTime ();
       
	System.out.println ("\nNumber of Primes: " + primeCount);
	if (primeCount == 78498)
	    System.out.println ("Correct Number of Primes");
	else
	    System.out.println ("Incorrect Number of Primes");

	System.out.printf ("Total Time: %.1f ms%n",
	 (endTime - startTime) / 1000000.0);

	System.out.println ("Program Complete");
    } // main method
} // PrimeNumber class
