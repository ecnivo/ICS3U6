/**
 * This program reads in a series of integers
 * and finds the total, average, and minimum and maximum values 
 * @author Vince Ou
 * @version 29 September 2014
 */
import java.util.Scanner;
import java.lang.Character;
public class NumberOfNumbers {

	public static void main(String[] args) {
		System.out.println("Number of Numbers Program");
		char moreNumbers;
		Scanner keyboard = new Scanner(System.in);
		long total = 0;
		int noOfNumbers = 0;
		int lowest = Integer.MAX_VALUE;
		int highest = 0;
		int input;
		do {
			System.out.print("Enter your number here: ");
			noOfNumbers++;
			input = keyboard.nextInt();
			total += input;
			if (input > highest) {
				highest = input;
			}
			else if (input < lowest){
				lowest = input;
			}
			System.out.print("Do you want to enter another number? (Y/N) ");
			moreNumbers = Character.toUpperCase(keyboard.next().charAt(0));
		} while (moreNumbers == 'Y');
		double average = total / noOfNumbers;
		System.out.println("Your total is: " + total);
		System.out.println("Your average is: " + average);
		System.out.println("Your lowest is: " + lowest);
		System.out.println("Your highest is: " + highest);
		System.out.println("Thanks for using Number of Numbers");

	}

}
