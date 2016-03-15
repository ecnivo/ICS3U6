import robot.*;
import java.awt.Color;

/** The "RobotWorldDemoFour" class.
  * Purpose: To demonstrate how to work with Items
  * @author Ridout
  * @version updated Nov 2012
 */
public class RobotWorldDemoFour
{
    public static void main (String [] args)
    {
	// Set up the World and the Robot
	World myWorld = new World (10, 10);
	Robot myRobot = new Robot ("Scanvenger", Color.CYAN);
	myWorld.addRobot (myRobot, 0, 0, Direction.EAST);

	// We have a choice of 3 different shape items
	// Before adding these items to the world we need to create them
	// When creating these items, you need to specify both
	// the type of shape and the colour
	Item blueTriangle = new Item (Item.TRIANGLE, Color.blue);
	Item greenCircle = new Item (Item.CIRCLE, Color.green);
	Item redSquare = new Item (Item.SQUARE, Color.red);

	// Once created we can add these items to our world by
	// specifying the row and column where we want to add them
	// Just like adding a Robot except Items don't have a direction
	myWorld.addItem (blueTriangle, 0, 1);
	myWorld.addItem (greenCircle, 0, 2);
	myWorld.addItem (redSquare, 0, 3);

	// We can also create and add some letter Items
	// Each letter item is defined by a character and a colour
	// If we want we can put more than one item in the same spot
	// In this case the A is on the bottom and the C is on top
	for (char letter = 'A' ; letter <= 'C' ; letter++)
	{
	    Item newLetter = new Item (letter, Color.YELLOW);
	    myWorld.addItem (newLetter, 0, 4);
	}

	// Now we will move our robot across the top,
	// picking up the items we just added
	while (!myRobot.isWallAhead ())
	{
	    // Since we could have more than item in the same spot
	    // we use a while loop to keep picking up all items
	    while (myRobot.isItemHere ())
		myRobot.pickUpItem ();

	    // Move on to the next spot
	    myRobot.move ();
	}

	// Now let's turn around and drop all of the items
	// We will drop the first item picked up first so the
	// items will be dropped in reverse order
	// a dropLastItem() method is also available
	myRobot.turnRight ();
	myRobot.turnRight ();

	while (myRobot.getNoOfItems () > 0)
	{
	    myRobot.dropFirstItem ();
	    myRobot.move ();
	}
    } // main method
} // RobotWorldDemoFour class
