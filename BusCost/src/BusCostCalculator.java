/**
 * This is to calculate the cost of a bus trip (First program)
 * @author Vince Ou
 * @version September 2014
 */
import java.util.Scanner;
import java.lang.Math;
public class BusCostCalculator {

	public static void main(String[] args) {
		System.out.println("           ***BUS COST CALCULATOR***"); //Title
		Scanner keyboard = new Scanner(System.in);
		
		//Input 
		System.out.print("Please enter destination: ");
		String destination = keyboard.nextLine();
		System.out.printf("Please enter distance to %s (in km): ", destination);
		double distance = keyboard.nextDouble();
		System.out.print("Please enter number of students: ");
		int students = keyboard.nextInt();
		System.out.print("Please enter number of teachers: ");
		int teachers = keyboard.nextInt();
		
		//Calculate
		double roundTripDistance = distance * 2.0;
		final int BUS_CAPACITY = 48;
		int noOfBuses = (BUS_CAPACITY - 1 + students + teachers) / BUS_CAPACITY;
		final double COST_PER_BUS = 158.0;
		final double COST_PER_KM = 3.15;
		double totalCost = noOfBuses * (COST_PER_BUS + roundTripDistance * COST_PER_KM);
		double costPerStudent = totalCost / students;
		
		//Output
		System.out.println();
		System.out.println("           *Trip Summary*");
		System.out.printf("%n Destination : %s", destination);
		System.out.printf("%n Round Trip Distance: %.4f km", roundTripDistance);
		System.out.printf("%n Number of Students: %,d", students);
		System.out.printf("%n Number of Teachers: %,d", teachers);
		System.out.printf("%n Number of Buses: %d", noOfBuses);
		System.out.printf("%n Total Cost: $ %,.2f", totalCost);
		System.out.printf("%n Cost per Student: $ %.2f", costPerStudent);
		System.out.printf("%n Thanks for using the Bus Cost Calculator!");
		System.out.println("");
	}
}