import java.awt.Color;
import robot.*;

/**
 * Picks up all letters in the world, and puts the highest recurring one on the
 * highest point in the world.
 * @author Vince Ou
 * @version November 2014
 */
public class HighestPeak
{

	public static void main(String[] args)
	{
		// Initializes new world
		World myWorld = new World("world4.txt");
		RobotPlus roboto = new RobotPlus("PeakFinder", Color.ORANGE);
		myWorld.addRobot(roboto, 0, 0, Direction.EAST);
		roboto.takeReallyBigSteps();

		// Goes along top wall to measure width of world
		int worldWidth = 0;
		while (!roboto.isWallAhead())
		{
			roboto.move();
			worldWidth++;
		}

		// Moves back to starting point
		roboto.turnAround();
		while (!roboto.isWallAhead())
			roboto.move();
		roboto.turnLeft();

		// Hugs left wall and picks up items if it comes along with them
		while (roboto.currentX < worldWidth)
		{
			roboto.hugLeftWall();
			if (roboto.isItemHere())
				roboto.pickUpItem();
		}

		// At rightmost edge, it turns south and picks up letters until it
		// reaches the end.
		roboto.turnRight();
		while (!roboto.isWallAhead())
		{
			roboto.pickUpAndMove();
		}
		if (roboto.isItemHere())
			roboto.pickUpItem();

		// Sorts letters that it picked up
		roboto.cycleAndSort();

		// Moves to top left corner
		roboto.turnToFace(Direction.NORTH);
		while (!roboto.isWallAhead())
			roboto.move();
		roboto.turnLeft();

		/*
		 * Paces in horizontal scans in "rows" that move downward, until the
		 * robot encounters a wall before it reaches the world's width. Uses a
		 * variable "currentPaces" to keep track of number of steps moved. If
		 * the robot takes fewer paces than the width of the world to reach a
		 * wall, then it is an "artificial" wall that the robot should climb on
		 * top of
		 */
		int currentPaces = 0;
		boolean isHighestFound = false;

		while (!isHighestFound)
		{
			// Moves side to side
			while (!roboto.isWallAhead())
			{
				roboto.move();
				currentPaces++;
			}

			// Decides what to do if it reaches the edge of world, and
			// increments one row downward
			if (currentPaces == worldWidth)
			{
				if (roboto.isFacing(Direction.EAST) && roboto.isWallAhead())
				{
					roboto.turnRight();
					roboto.move();
					roboto.turnRight();
				}
				if (roboto.isFacing(Direction.WEST) && roboto.isWallAhead())
				{
					roboto.turnLeft();
					roboto.move();
					roboto.turnLeft();
				}
				currentPaces = 0;
			}

			else
				isHighestFound = true;
		}

		// The robot has encountered a wall in the middle of the world
		// Now it will 'climb' on top of the wall
		if (roboto.isFacing(Direction.EAST))
		{
			roboto.turnLeft();
			roboto.move();
			roboto.turnRight();
			roboto.move();
		}
		else if (roboto.isFacing(Direction.WEST))
		{
			roboto.turnRight();
			roboto.move();
			roboto.turnLeft();
			roboto.move();
		}

		// Compares the inventory amounts, and drops from top or bottom,
		// depending on whichever has more letters of each category
		if (roboto.topInv > roboto.bottomInv)
			roboto.dropThese(roboto.topInv, 't');
		else
			roboto.dropThese(roboto.bottomInv, 'b');

		// Goes straight up, then when it reaches the North wall, turns East and
		// goes down to reach the exit
		roboto.turnToFace(Direction.NORTH);
		for (int two = 2; two > 0; two--)
		{
			while (!roboto.isWallAhead())
				roboto.move();
			roboto.turnRight();
		}
		while (!roboto.isExitHere())
			roboto.move();
	}
}
