
public class CutPrime
{

	public static void main(String[] args)
	{
		while (true)
		{
			int integerCounter =  Integer.MAX_VALUE;
			int primeCheck = integerCounter;
			while (IsPrime.isPrime(primeCheck))
			{
				primeCheck /= 10;
				if (primeCheck < 10)
				{
					System.out.println(integerCounter);
					return;
				}
			}
			integerCounter -= 2;
		}
	}
}
