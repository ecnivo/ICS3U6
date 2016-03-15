import java.awt.Color;

import robot.*;

/**
 * Draws a large X on a odd-numbered side length world
 * @author Vince Ou
 * @version November 2014
 */
public class XDrawer
{

	public static void main(String[] args)
	{
		// Initializes world, robot, and first marker at the top left
		World myWorld = new World(31, 31);
		Robot roboto = new Robot("X Drawer", Color.BLUE);
		myWorld.addRobot(roboto, 0, 0, Direction.EAST);
		roboto.takeReallyBigSteps();

		// Moves robot from the upper left to the lower right, while drawing
		// first diagonal
		while (!roboto.isWallAhead())
		{
			roboto.dropMarker();
			roboto.move();
			roboto.turnRight();
			roboto.move();
			roboto.turnLeft();
		}
		roboto.dropMarker();

		// Turns robot to move to a position to go to the lower left to draw
		// second diagonal
		roboto.turnLeft();
		roboto.turnLeft();

		// Counts the side length along bottom edge for later use (you'll see)
		int sideLength = 1;
		while (!roboto.isWallAhead())
		{
			roboto.move();
			sideLength++;
		}

		// Moves robot from lower left to upper right, while drawing the second
		// line. Includes a check to avoid double markers
		roboto.turnRight();
		while (!roboto.isWallAhead())
		{
			if (!roboto.isMarkerHere())
				roboto.dropMarker();
			roboto.move();
			roboto.turnRight();
			roboto.move();
			roboto.turnLeft();
		}
		roboto.turnLeft();
		roboto.dropMarker();

		// Moves robot to the centre of the X using side length measurement from earlier
		sideLength /= 2;
		for (int two = 0; two < 2; two++)
		{
			for (int steps = 0; steps < sideLength; steps++)
			{
				roboto.move();
			}
			roboto.turnLeft();
		}
	}

}
