import java.awt.Color;

import robot.*;

/**
 * Draws a large X on a odd-numbered side length world
 * @author Vince Ou
 * @version November 2014
 */
public class C8Q6
{

	public static void main(String[] args)
	{
		// Initializes world, robot, and first marker at the top left
		World myWorld = new World(31,31);
		Robot roboto = new Robot("X Drawer", Color.WHITE);
		myWorld.addRobot(roboto, 0, 0, Direction.EAST);
		roboto.takeReallyBigSteps();

		// Measures the size of the world
		// And drops marker at the top right edge
		int lengthWidth = 0;
		while (!roboto.isWallAhead())
		{
			lengthWidth++;
			roboto.move();
		}
		roboto.turnRight();

		// The robot goes around in concentric squares
		for (int drawingDimension = 0; drawingDimension < lengthWidth / 2; drawingDimension++)
		{
			// Counts the number of sides drawn already
			for (int sidesDrawn = 0; sidesDrawn < 4; sidesDrawn++)
			{
				// Takes steps to each corner of the square and drops a marker
				// there
				int stepsToTake = lengthWidth - 2 * drawingDimension;
				for (int stepsTaken = 0; stepsTaken < stepsToTake; stepsTaken++)
				{
					roboto.move();
				}
				roboto.dropMarker();
				// Turns right to proceed along the next edge of square
				roboto.turnRight();
			}
			// Moves robot into one inner concentric square
			roboto.move();
			roboto.turnRight();
			roboto.move();
			roboto.turnLeft();
		}
	}

}
