import java.util.Scanner;
/**
 * This program prints out a hollow rectangle
 * formed by the * character, with dimensions
 * as user input.
 * @author Vince Ou
 * @version September 29 2014
 */
public class HollowRectanglePrinter {

	public static void main(String[] args) {
		System.out.println("***Welcome to the Hollow Rectangle Printer***");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What is your desired width? ");
		int width = keyboard.nextInt();
		System.out.print("What is your desired height? ");
		int height = keyboard.nextInt();
		for (int widthIterator = 0; widthIterator < width; widthIterator++) {
			System.out.print("*");
		}
		for (int heightIterator = 0; heightIterator < (height-2); heightIterator++){	
			System.out.printf("%n*");
			for (int emptyWidth = 0; emptyWidth < (width - 2); emptyWidth++) {
				System.out.print(" ");			
			}
			System.out.print("*");
		}
		System.out.println();
		for (int widthIterator = 0; widthIterator < width; widthIterator++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("Printing done.");
	}
}
