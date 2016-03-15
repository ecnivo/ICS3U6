import robot.*;
import java.awt.Color;
/** The "RobotWorldDemoOne" class.
  * Purpose: To demonstrate the move(), turnLeft(), turnRight() methods
  * @author Ridout
  * @version updated Nov 2012
 */
public class RobotWorldDemoOne
{
    public static void main (String [] args)
    {
	// Create a 10 by 10 world
	World myWorld = new World (10, 10);

	// Create a red robot called "Demo One"
	Robot myRobot = new Robot ("Demo One", Color.RED);
	myRobot.takeReallyBigSteps();

	// Add Demo to the world at position (0,0) facing South
	myWorld.addRobot (myRobot, 0, 0, Direction.SOUTH);

	// Move and turn the robot
	myRobot.move ();
	myRobot.move ();
	myRobot.move ();
	myRobot.turnLeft ();
	myRobot.move ();
	myRobot.move ();
	myRobot.turnRight ();
	myRobot.move ();
	myRobot.move ();
	myRobot.move ();

    } // main method
} // RobotWorldDemoOne class
