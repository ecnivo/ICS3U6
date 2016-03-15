import java.util.ArrayList;
import java.util.Scanner;
/**
*@author Vince Ou
*/
public class deal
{

	public static void main(String[] args)
	{
		ArrayList cases = new ArrayList();
		cases.add(100);
		cases.add(500);
		cases.add(1000);
		cases.add(5000);
		cases.add(10000);
		cases.add(25000);
		cases.add(50000);
		cases.add(100000);
		cases.add(500000);
		cases.add(1000000);
		Scanner keyboard = new Scanner(System.in);
		int openedCases = keyboard.nextInt();
		for (int i = 1; i <= openedCases; i++)
		{
			cases.remove(keyboard.nextInt() - 1);
		}
		long offer = keyboard.nextInt();
		
		long total = 0;
		for (int i = 1; i < cases.size(); i++)
		{
			total += (int) cases.get(i);
		}
				
		double average = total / cases.size();
		if (average > offer)
			System.out.println("deal");
		else
			System.out.println("no deal");
	}

}
