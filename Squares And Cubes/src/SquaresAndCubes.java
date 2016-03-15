/**
 * This program prints the squares and cubes of whole numbers from 1-15
 * @author Vince Ou
 * @version September 29 2014
 *
 */
public class SquaresAndCubes {

	public static void main(String[] args) {
		System.out.println("       Squares and Cubes");
		System.out.printf("Number     Square     Cube%n");
		for (int i = 1; i <= 15; i++) {
			long square = i * i;
			long cube = i * i * i;
			System.out.printf("%-10d %-10d %-10d%n", i, square, cube);
		}

	}

}
