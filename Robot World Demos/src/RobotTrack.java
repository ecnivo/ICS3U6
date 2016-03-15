import java.awt.Color;

import robot.*;

public class RobotTrack extends Robot
{
	private int NSchange;
	private int EWchange;

	/**
	 * Creates a robot called "RobotTrack" to keep track of its movements
	 * @param name
	 * @param colour
	 */
	public RobotTrack(String name, Color colour)
	{
		super(name, colour);
		this.markThisSpot();
	}

	/**
	 * Marks a spot for the robot to return to
	 */
	public void markThisSpot()
	{
		NSchange = 0;
		EWchange = 0;
	}

	/**
	 * Overrides the move method in the Robot class so that it can track changes
	 * in robot position
	 */
	public void move(int steps)
	{
		// For each direction, an increase in the coordinate grid would be
		// adding, and decrease is subtracting. So East is adding, West is
		// subtracting. North is subtracting, South is adding.
		if (this.isFacing(Direction.EAST))
			EWchange++;
		else if (this.isFacing(Direction.WEST))
			EWchange--;
		else if (this.isFacing(Direction.NORTH))
			NSchange--;
		else if (this.isFacing(Direction.SOUTH))
			NSchange++;
		
		// Adds a step counter for integer move counts (including negatives)
		if (steps > 0)
			for (int stepCount = steps; stepCount > 0; stepCount--)
				super.move();
		else 
		{
			steps = Math.abs(steps);
			this.turnRight();
			this.turnRight();
			for (int stepCount = steps; stepCount > 0; stepCount--)
				super.move();
			this.turnRight();
			this.turnRight();
		}
	}
	
	/**
	 * Calls the integer move with 1 step
	 */
	public void move()
	{
		this.move(1);
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
	 * Returns roboto to the marked spot
	 */
	public void returnToMarkedSpot()
	{
		this.turnToFace(Direction.EAST);
		this.move(EWchange * -1);
		this.turnToFace(Direction.SOUTH);
		this.move(NSchange * -1);
	}
}
