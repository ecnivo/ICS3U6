import java.awt.Color;

import robot.*;

/**
 * Picks up four letters on the grid, and places them in the corners
 * @author Vince Ou
 * @version November 2014
 */
public class C8Q11
{

	public static void main(String[] args)
	{
		// Creates a new world and robot
		World myWorld = new World(12, 12);
		RobotPlus roboto = new RobotPlus("Roboto", Color.WHITE);
		myWorld.addRobot(roboto, 0, 0, Direction.SOUTH);
		roboto.takeReallyBigSteps();

		// Randomly places letters in the world
		for (char letter = 'A'; letter <= 'D'; letter++)
		{
			Item newLetter = new Item(letter, Color.BLUE);
			int row = (int) (Math.random() * 12);
			int column = (int) (Math.random() * 12);
			myWorld.addItem(newLetter, row, column);
		}

		// Picks up all the items, by going through in a north-south pattern,
		// going from west to east
		while (roboto.getNoOfItems() < 4)
		{
			while (!roboto.isWallAhead())
			{
				roboto.pickUpAndMove();
			}

			if (roboto.isFacing(Direction.NORTH))
			{
				roboto.turnRight();
				roboto.pickUpAndMove();
				roboto.turnRight();
			}

			else
			{
				roboto.turnLeft();
				roboto.pickUpAndMove();
				roboto.turnLeft();
			}
		}

		// Goes to each corner, dropping items off in each, going clockwise from
		// northeast corner
		roboto.goToCorner(Direction.NORTH, Direction.EAST);
		roboto.dropFirstItem();
		roboto.goToCorner(Direction.SOUTH, Direction.WEST);
		roboto.dropFirstItem();
		roboto.goToCorner(Direction.NORTH, Direction.WEST);
		roboto.dropFirstItem();
		roboto.goToCorner(Direction.SOUTH, Direction.EAST);
		roboto.dropFirstItem();
		roboto.turnToFace(Direction.NORTH);
		roboto.move();
	}

}
