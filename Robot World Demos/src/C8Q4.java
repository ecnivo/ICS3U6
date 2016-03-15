import robot.*;
import java.awt.Color;

/** The "RobotWorldDemoTwo" class.
  * Purpose: To draw a 7 by 7 box in the middle of the Robot World
  * @author Ridout
  * @version updated Nov 2012
 */
public class C8Q4
{
    public static void main (String [] args)
    {
		// Set up the World and the Robot
		World myWorld = new World (17,17);
		Robot myRobot = new Robot ("Pumpkin", Color.ORANGE);
		myRobot.takeBigSteps ();
		myWorld.addRobot (myRobot, 15, 15, Direction.NORTH);
		
		// Counts the number of sides already drawn
		for (int squareSide = 0; squareSide < 4; squareSide++)
		{
			// Loops so robot moves along side of square
			for (int squareLength = 0; squareLength < 14; squareLength++)
			{
				myRobot.move();
				myRobot.dropMarker();
			}
			myRobot.turnLeft();
		}
		
		// Moves to centre of square
		for (int stepCounter = 0; stepCounter < 2; stepCounter++)
		{
			
			for (int secondStepCounter = 0; secondStepCounter < 7; secondStepCounter++)
			{
				myRobot.move();
			}
			myRobot.turnLeft();
		}
		
		
	
	}
} // RobotWorldDemoTwo class
