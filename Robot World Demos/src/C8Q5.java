import robot.*;

import java.awt.Color;

public class C8Q5
{
	public static void main(String[] args)
	{
		World myWorld = new World(10, 10);
		Robot myRobot = new Robot("Roboto", Color.WHITE);
		myWorld.addRobot(myRobot, 0, 0, Direction.SOUTH);
		myRobot.takeBigSteps();

		while (true)
		{
			while (!myRobot.isWallAhead())
			{
				myRobot.dropMarker();
				myRobot.move();
			}

			if (myRobot.isFacing(Direction.NORTH))
			{
				myRobot.turnRight();
				myRobot.dropMarker();
				myRobot.move();
				myRobot.turnRight();
			}

			else
			{
				myRobot.turnLeft();
				myRobot.dropMarker();
				myRobot.move();
				myRobot.turnLeft();
			}

		}

	}
}
