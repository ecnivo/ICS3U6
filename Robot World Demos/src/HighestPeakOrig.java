import java.awt.Color;
import robot.*;

/**
 * Picks up all letters in the world, and puts the highest recurring one on the
 * highest point in the world.
 * @author Vince Ou
 * @version November 2014
 */
public class HighestPeakOrig
{

	public static void main(String[] args)
	{
		// Initializes new world
		World myWorld = new World("world5.txt");
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
		int leastY = Integer.MAX_VALUE;
		int targetX = 0;
		while (!roboto.isWallAhead())
			roboto.pickUpAndMove();
		if (roboto.isItemHere())
			roboto.pickUpItem();
		while (roboto.currentX < worldWidth)
		{
			roboto.hugRightWall();
			if (roboto.isItemHere())
				roboto.pickUpItem();
			if (roboto.currentY <= leastY)
			{
				leastY = roboto.currentY;
				targetX = roboto.currentX ;
			}
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

		// Moves to drop off point
		roboto.turnToFace(Direction.NORTH);
		while (roboto.currentY > leastY)
			roboto.move();
		roboto.turnLeft();
		while (roboto.currentX != targetX)
			roboto.move();
			
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
