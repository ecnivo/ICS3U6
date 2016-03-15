import java.awt.Color;

import robot.*;

/**
 * Picks up all letters in the world, and puts the highest recurring one on the
 * highest point in the world.
 * @author Vince Ou
 * @version November 2014
 */
public class HighestPeakII
{

	public static void main(String[] args)
	{
		// Initializes new world
		World myWorld = new World("world5.txt");
		RobotPlus roboto = new RobotPlus("PeakFinder", Color.ORANGE);
		myWorld.addRobot(roboto, 0, 0, Direction.EAST);
		roboto.takeReallyBigSteps();
		
		int worldWidth = 1;
		while (!roboto.isWallAhead())
		{
			roboto.move();
			worldWidth++;
		}
		roboto.turnAround();
		while (!roboto.isWallAhead())
			roboto.move();
		roboto.turnLeft();

		int minY = Integer.MAX_VALUE;
		int minX = 7;
		while (!roboto.isWallAhead())	
			roboto.move();
		while (roboto.isItemHere())
			roboto.pickUpItem();
		while (roboto.currentX + 1 < worldWidth)
		{			
			roboto.hugRightWall();
			if (minY > roboto.currentY)
			{
				minY = roboto.currentY;
			}
			if (roboto.isItemHere())
				roboto.pickUpItem();
		}
		
		roboto.turnRight();
		while (!roboto.isWallAhead())	
			roboto.pickUpAndMove();
		
		roboto.cycleAndSort();
		
		while (roboto.isWallAhead())	
			roboto.turnLeft();
		while (roboto.currentY != minY)
			roboto.hugLeftWall();
		
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
