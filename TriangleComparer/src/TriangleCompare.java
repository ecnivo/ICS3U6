import java.util.Scanner;
import java.lang.Math;
/**
 * This is used to take the side lengths of a triangle and sort them
 * into categories: Equilateral, Scalene, Invalid , or Isosceles.
 * @author Vince Ou
 * @version September 25 2014
 */

public class TriangleCompare
{

	public static void main(String[] args)
	{
		// Print out title
		System.out.println("***Welcome to the Triangle Length Comparer!***");
		
		//Acquire user input for three lengths
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter your first length: ");
		double lengthOne = keyboard.nextDouble();
		System.out.print("Please enter your second length: ");
		double lengthTwo = keyboard.nextDouble();
		System.out.print("Please enter your third length: ");
		double lengthThree = keyboard.nextDouble();
		
		// Print first part of output
		System.out.print("Your triangle is of type: ");
		
		// Checks for each length of triangle, and prints second part of output
		if (lengthOne + lengthTwo + lengthThree < 2 * Math.max(Math.max(lengthTwo, lengthOne), lengthThree))
			System.out.println("Invalid Triangle");
		else if (lengthOne == lengthTwo && lengthTwo == lengthThree)
			System.out.print("Equilateral Triangle");
		else if (lengthOne != lengthTwo && lengthTwo != lengthThree)
			System.out.print("Scalene Triangle");
		else
			System.out.println("Isoceles Triangle");	

		// Print closing statement
		System.out.println("Thank you for using the Triangle Length Comparer!");
		keyboard.close();
	}

}
