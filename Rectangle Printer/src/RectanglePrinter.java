import java.util.Scanner;
/**
 * This program prints out a solid rectangle of the * character
 * with inputted height and width dimensions by the user.
 * @author Vince Ou
 * @version September 29 2014
 */

public class RectanglePrinter {

	public static void main(String[] args) {
		System.out.println("***Welcome to the Solid Rectangle Printer***");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What is your desired width? ");
		int width = keyboard.nextInt();
		System.out.print("What is your desired height? ");
		int height = keyboard.nextInt();
		for (int heightIterator = 0; heightIterator < height; heightIterator++) {
			for (int widthIterator = 0; widthIterator < width; widthIterator++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.printf("%nProgram end");
	}

}
