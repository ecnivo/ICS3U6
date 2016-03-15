import java.util.Scanner;

/**
*@author Vince Ou
*@version December 2014
*/
public class BloodDonation {
	
	private static int sorter(int blood, int people)
	{
		int output = 0;
		if (blood == people)
		{
			output = blood;
		}
		else if (blood > people)
		{
			while (people > 0)
			{
				output ++;
				blood--;
			}
		}
		else
		{
			output = people;
		}
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int oNeg = keyboard.nextInt();
		int oPos = keyboard.nextInt();
		int aNeg = keyboard.nextInt();
		int aPos = keyboard.nextInt();
		int bPos = keyboard.nextInt();
		int abNeg = keyboard.nextInt();
		int abPos = keyboard.nextInt();
		keyboard.nextLine();
		int poNeg = keyboard.nextInt();
		int poPos = keyboard.nextInt();
		int paNeg = keyboard.nextInt();
		int paPos = keyboard.nextInt();
		int pbNeg = keyboard.nextInt();
		int pbPos = keyboard.nextInt();
		int pabNeg = keyboard.nextInt();
		int pabPos = keyboard.nextInt();
		int noOfDonations;
		
		// What now?
		noOfDonations = poNeg - oNeg;
		oNeg -= poNeg;
		noOfDonations += poPos - oNeg;
		oNeg -= poPos;
		noOfDonations += poPos - 
	}

}
