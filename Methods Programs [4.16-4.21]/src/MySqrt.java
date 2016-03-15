import java.util.Scanner;

/**
*@author Vince Ou
*/
public class MySqrt
{
	private static double mySqrt(double number)
	{
		for (int sqrt = 0; sqrt <= number; sqrt++)
		{
			if (sqrt * sqrt == number)
				return sqrt;
		}
		return Double.NaN;
	}

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		double number = keyboard.nextDouble();
//		System.out.println(mySqrt(number));
		System.out.println(mySqrt(Integer.MAX_VALUE));
	}

}
