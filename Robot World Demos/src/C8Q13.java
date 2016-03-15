import java.awt.Color;

import robot.Direction;
import robot.Item;
import robot.World;


public class C8Q13
{

	public static void main(String[] args)
	{
		// Initializes new world
		World myWorld = new World(12, 12);
		RobotTrack roboto = new RobotTrack("Letter Sorter", Color.YELLOW);
		myWorld.addRobot(roboto, 0, 0, Direction.SOUTH);
		roboto.takeReallyBigSteps();
		
		// Creates a square
		Item square = new Item(Item.SQUARE, Color.BLUE);
		int row = (int) (Math.random() * 12);
		int column = (int) (Math.random() * 12);
		myWorld.addItem(square, row, column);
		
		// Creates a triangle
		Item triangle = new Item(Item.TRIANGLE, Color.YELLOW);
		row = (int) (Math.random() * 12);
		column = (int) (Math.random() * 12);
		myWorld.addItem(triangle, row, column);
		
		// Finds first item
		while (roboto.getNoOfItems() == 0)
		{
			roboto.move();
			if (roboto.isWallAhead())
			{
				if (roboto.isFacing(Direction.SOUTH))
				{
					roboto.turnLeft();
					roboto.move();
					roboto.turnLeft();
				}
				else
				{
					roboto.turnRight();
					roboto.move();
					roboto.turnRight();
				}
			}
			if (roboto.isItemHere())
				roboto.pickUpItem();
		}
		
		// Marks spot
		roboto.markThisSpot();
		
		// Finds second item
		while (roboto.getNoOfItems() == 1)
		{
			roboto.move();
			if (roboto.isWallAhead())
			{
				if (roboto.isFacing(Direction.SOUTH))
				{
					roboto.turnLeft();
					roboto.move();
					roboto.turnLeft();
				}
				else
				{
					roboto.turnRight();
					roboto.move();
					roboto.turnRight();
				}
			}
			if (roboto.isItemHere())
				roboto.pickUpItem();
		}
		
		// Does the assignment
		roboto.dropFirstItem();
		
		roboto.returnToMarkedSpot();
		
		roboto.dropLastItem();
		
		roboto.move(5);
		
	}

}
