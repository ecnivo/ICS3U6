import robot.*;
import java.awt.Color;

/** The "RobotWorldDemoTwo" class.
  * Purpose: To draw a 7 by 7 box in the middle of the Robot World
  * @author Ridout
  * @version updated Nov 2012
 */
public class RobotWorldDemoTwo
{
    public static void main (String [] args)
    {
	// Set up the World and the Robot
	World myWorld = new World (9, 9);
	Robot myRobot = new Robot ("Demo Two", Color.BLUE);
	myRobot.takeBigSteps ();
	myWorld.addRobot (myRobot, 1, 1, Direction.EAST);

	// Trace out a 7 by 7 4-sided box
	for (int side = 1 ; side <= 4 ; side++)
	{
	    // Take 6 steps, dropping markers as you go
	    for (int step = 1 ; step <= 6 ; step++)
	    {
		myRobot.move ();
		myRobot.dropMarker ();
	    }

	    // Make a right turn before tracing out the next side
	    myRobot.turnRight ();
	}

	// Move to the centre of the box
	// This only works for a 9 by 9 world
	for (int step = 1 ; step <= 3 ; step++)
	    myRobot.move ();
	myRobot.turnRight ();
	for (int step = 1 ; step <= 3 ; step++)
	    myRobot.move ();

    } // main method
} // RobotWorldDemoTwo class
