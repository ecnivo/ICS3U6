import java.awt.Color;
import robot.*;

/**
 * Creates a world with 30 random letters, and it is sorted on the top row
 * alphabetically
 * @author Vince Ou
 * @version November 2014
 *
 */
public class AlphabetSorter
{

	public static void main(String[] args)
	{
		// Initializes new world
		World myWorld = new World(20, 30);
		RobotPlus roboto = new RobotPlus("Letter Sorter", Color.YELLOW);
		myWorld.addRobot(roboto, 0, 0, Direction.SOUTH);
		roboto.takeReallyBigSteps();

		// Drops 30 letters randomly on the map/ world
		for (int letterCounter = 30; letterCounter > 0; letterCounter--)
		{
			int row = (int) (Math.random() * 20);
			int column = (int) (Math.random() * 30);
			char randomLetter = (char) ('A' + Math.random() * 26);
			Item newLetter = new Item(randomLetter, Color.BLUE);
			myWorld.addItem(newLetter, row, column);
		}

		// Collects all letters
		roboto.sweepAndCollect(30);

		// Puts all letters on top row
		roboto.goToCorner(Direction.NORTH, Direction.EAST);
		roboto.turnToFace(Direction.WEST);
		roboto.dropFirstItem();
		while (roboto.getNoOfItems() > 0)
		{
			roboto.move();
			roboto.dropFirstItem();
		}

		// Drops first letter, then sorts
		roboto.turnAround();
		roboto.pickUpAndMove();
		while (roboto.getNoOfItems() < 30)
		{
			roboto.sortMove();
		}
		
		// turns around and deposits the letters, in order, on the top row
		roboto.turnAround();
		while (roboto.getNoOfItems() > 1)
		{
			roboto.dropLastItem();
			roboto.move();
		}
		roboto.dropFirstItem();
		
		// turns away
		roboto.turnLeft();
		roboto.move(5);
		System.out.println(roboto.getNoOfMoves());
	}

}
