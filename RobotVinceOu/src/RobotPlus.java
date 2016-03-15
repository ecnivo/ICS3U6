import robot.*;

import java.awt.Color;

/**
 * RobotPlus Class A new class which is an extension of the Robot class
 * @author Ridout and Vince Ou
 * @version April 2014
 */

public class RobotPlus extends Robot
{
	private int noOfMoves;
	public int currentX;
	public int topInv;
	public int bottomInv;

	/**
	 * RobotPlus constructor creates a new RobotPlus robot with the given name
	 * and colour
	 * @param name The name of the robot
	 * @param colour The colour of the robot's body
	 */
	public RobotPlus(String name, Color colour)
	{
		// Calls the original Robot class constructor
		super(name + "+", colour);

		// For number of moves
		this.noOfMoves = 0;

		// For highest wall finder
		this.currentX = 0;
		this.bottomInv = 0;

		// Speed optimization (thanks to Gordon)
		this.threadRobot = true;
	}

	/**
	 * Turns the robot around (180 degrees)
	 */
	public void turnAround()
	{
		// Turns left twice to accomplish task
		this.turnLeft();
		this.turnLeft();
	}

	/**
	 * Moves a robot and adds it to the moves counter, as well as keeps track of
	 * the X axis position
	 */
	public void move()
	{
		// If moved to east, then adds to the X counter (finds X position on
		// world)
		if (this.isFacing(Direction.EAST))
			currentX++;
		else if (this.isFacing(Direction.WEST))
			currentX--;
		// Calls the Robot superclass and uses its move method, as well as
		// counting number of movements
		super.move();
		noOfMoves++;
	}

	/**
	 * Allows user to access number of moves
	 * @return number of moves
	 */
	public int getNoOfMoves()
	{
		return this.noOfMoves;
	}

	/**
	 * Moves the Robot the given number of steps. If steps is negative, moves
	 * backwards and turns around to face same orientation
	 * @param noOfSteps The number of steps to move the Robot
	 */
	public void move(int noOfSteps)
	{
		// Does a negative check
		if (noOfSteps > -1)
			for (int steps = 1; steps <= noOfSteps; steps++)
				this.move();
		else
		{
			// Turns it around, moves it, then turns around again (used for
			// Letter Sorting)
			this.turnAround();
			noOfSteps = Math.abs(noOfSteps);
			for (int steps = 0; steps < noOfSteps; steps++)
				this.move();
			this.turnAround();
		}
	}

	/**
	 * Turns robot to face a certain direction
	 * @param direction the direction you want the robot to face
	 */
	public void turnToFace(Direction direction)
	{
		// Keep turning until the desired direction is reached
		while (!this.isFacing(direction))
			this.turnRight();
	}

	/**
	 * Goes to a certain corner on the world, has to be clear of obstacles (eg.
	 * maze)
	 * @param dirNS North/South (Accepted: "Direction.NORTH" or
	 *            "Direction.SOUTH")
	 * @param dirWE West/East (Accepted: "Direction.WEST" or "Direction.EAST")
	 */
	public void goToCorner(Direction dirNS, Direction dirWE)
	{
		// Moves north/south axis first
		this.turnToFace(dirNS);
		while (!this.isWallAhead())
			this.move();
		// Then moves the east/west axis
		this.turnToFace(dirWE);
		while (!this.isWallAhead())
			this.move();
	}

	/**
	 * Picks up ALL items that is/are here, then moves. With built-in crash
	 * detection
	 */
	public void pickUpAndMove()
	{
		// Picks up item
		while (this.isItemHere())
			this.pickUpItem();

		// Moves
		if (!this.isWallAhead())
			this.move();
	}

	/**
	 * Goes from the north to south and drops items along the way until it
	 * either runs into a wall, or runs out of inventory
	 */
	public void dropInRow()
	{
		this.turnToFace(Direction.SOUTH);
		// Drops items and moves
		while (!isWallAhead() && this.getNoOfItems() > 0)
		{
			this.dropLastItem();
			this.move();
		}
		// So that it drops one right before the wall
		this.dropLastItem();
	}

	/**
	 * Sweeps the entire map and collects items on the map
	 */
	public void sweepAndCollect()
	{
		while (true)
		{
			// Crash detection!
			while (!this.isWallAhead())
			{
				this.pickUpAndMove();
			}

			// If it gets to a wall, then it does accordingly, and turns around,
			// increments one more column to the East
			if (this.isFacing(Direction.NORTH))
			{
				this.turnRight();
				this.pickUpAndMove();
				this.turnRight();
			}

			else
			{
				this.turnLeft();
				this.pickUpAndMove();
				this.turnLeft();
			}
		}
	}

	/**
	 * Sweeps and collects everything with a limit to the inventory
	 * @param maxInventory the number of items to collect, if known
	 */
	public void sweepAndCollect(int maxInventory)
	{

		// Stops sweeping if number of items is already reached, more efficient
		// if all items are situated in the first two squares or something
		while (this.getNoOfItems() < maxInventory)
		{
			// Crash detection!
			while (!this.isWallAhead())
			{
				this.pickUpAndMove();
			}

			// Does things according to the direction facing, also increments
			// one column to the East
			if (this.isFacing(Direction.NORTH))
			{
				this.turnRight();
				this.pickUpAndMove();
				this.turnRight();
			}

			else
			{
				this.turnLeft();
				this.pickUpAndMove();
				this.turnLeft();
			}
		}
	}

	/**
	 * Sorts a horizontal sequence of Items. Used in Alphabet Sorter
	 */
	public void sortMove()
	{
		// Starts to check. If the same, appends to end of inventory
		if (this.compareLastItemToItemHere() <= 0)
		{
			this.pickUpItem();
			if (!this.isWallAhead())
				this.move();
		}

		/*
		 * If different, moves back, drops last item off, then goes forward and
		 * checks.
		 */
		else
		{
			while (!(this.compareLastItemToItemHere() <= 0))
			{
				this.move(-1);
				this.dropLastItem();
				this.move();
			}

			// When the item in the robot's inventory would work in the order,
			// then it moves forward and picks up thing
			this.pickUpItem();
			this.move(-1);
			this.pickUpAndMove();
			if (!this.isWallAhead())
				this.move();
		}
	}

	/**
	 * Moves robot along the left wall, useful for solving mazes
	 */
	public void hugLeftWall()
	{
		// Checks for wall on the right ("hugs" the wall)
		this.turnRight();
		while (this.isWallAhead())
			this.turnLeft();
		// Moves as long as it is moving to follow a wall
		this.move();
	}

	/**
	 * "Cycles" through the inventory to sort its inventory.
	 */
	public void cycleAndSort()
	{
		// Doesn't run the sorting algorithm if only one or no items in stack.
		if (this.getNoOfItems() > 1)
		{
			// Drops an item to compare the rest to
			this.dropLastItem();

			// Finds number of items in the inventory total, then cycles through
			// all items
			for (int compare = this.getNoOfItems(); compare > 0; compare--)
			{
				// Moves first item to bottom of stack
				this.dropFirstItem();
				this.pickUpItem();

				// Creates a pile of one type on the ground and the other type
				// in the robot
				if (this.compareLastItemToItemHere() == 0)
					this.dropLastItem();
			}
			// Allows access to the number of items of each type for comparison
			// later
			this.topInv = this.getNoOfItems();
			this.turnAround();
			// Picks up the stack on the ground and counts that as well.
			while (this.isItemHere())
			{
				this.pickUpItem();
				bottomInv++;
			}
		}
		else
			topInv++;
	}

	/**
	 * Drops a specified number of items from the inventory from either the top
	 * or bottom
	 * @param itemsToDrop Integer value for number of items to drop
	 * @param topBottom accepts a letter 't' or 'b' for from the top or from the
	 *            bottom
	 */
	public void dropThese(int itemsToDrop, char topBottom)
	{
		// Checks for specification of 't' or 'b' for top or bottom
		if (topBottom == 't')
			// Loops through, to drop the specified number of items from the top
			for (int dropped = itemsToDrop; dropped > 0; dropped--)
			{
				this.dropFirstItem();
			}
		else
			// Loops through, to drop the specified number of items from the
			// bottom
			for (int dropped = itemsToDrop; dropped > 0; dropped--)
			{
				this.dropLastItem();
			}
	}
}
