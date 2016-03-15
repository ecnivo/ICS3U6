import robot.*;
import java.awt.Color;
/** The "RobotWorldDemoThree" class.
  * Purpose: To traverse the robot world from top to bottom
  * @author Ridout
  * @version updated Nov 2012
 */
public class RobotWorldDemoThree
{
    public static void main (String [] args)
    {
	World myWorld = new World (10, 10);
	Robot myRobot = new Robot ("Demo Three", Color.GREEN);
	myWorld.addRobot (myRobot, 0, 0, Direction.EAST);

	// Move the robot back and forth in the Robot World
	// Keep going until you reach the bottom (crash)
	while (true)
	{
	    // Keep moving until you find a wall
	    while (!myRobot.isWallAhead ())
		myRobot.move ();

	    // If facing east, turn around to the right
	    if (myRobot.isFacing(Direction.EAST))
	    {
		myRobot.turnRight ();
		myRobot.move ();
		myRobot.turnRight ();
	    }
	    else  // If facing west, turn around to the left
	    {
		myRobot.turnLeft ();
		myRobot.move ();
		myRobot.turnLeft ();
	    }
	}
    } // main method
} // RobotWorldDemoThree class


