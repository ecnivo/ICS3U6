import java.awt.Color;
import robot.*;

/**
 * Picks up twenty different items on the grid of two different colours and sorts them on each side
 * @author Vince Ou
 * @version	November 2014
 */
public class TrianglesAndSquares
{

	public static void main(String[] args)
	{
		// Initializes new world and robot
		World myWorld = new World(10, 10);
		RobotPlus roboto = new RobotPlus("Squares and Triangle Sorter", Color.BLUE);
		myWorld.addRobot(roboto, 0, 0, Direction.SOUTH);
		roboto.takeReallyBigSteps();

		// Randomly places ten yellow triangles and ten blue squares
		Item triangle = new Item(Item.TRIANGLE, Color.YELLOW);
		Item square = new Item(Item.SQUARE, Color.BLUE);
		for (int createdItems = 0; createdItems < 10; createdItems++)
		{
			int squareRow = (int) (Math.random() * 10);
			int squareColumn = (int) (Math.random() * 10);
			myWorld.addItem(square, squareRow, squareColumn);
			int triangleRow = (int) (Math.random() * 10);
			int triangleColumn = (int) (Math.random() * 10);
			myWorld.addItem(triangle, triangleRow, triangleColumn);
		}
		
		// Makes robot collect all the items
		roboto.sweepAndCollect(20);
		
		// Goes to North-East corner and drops the squares
		roboto.goToCorner(Direction.NORTH, Direction.EAST);
		roboto.turnRight();
		
		// Drops squares while cycling them
		for (int cycle = roboto.getNoOfItems(); cycle > 0; cycle--)
		{
			roboto.dropFirstItem();
			roboto.pickUpItem();
			
			if (roboto.isLastItem(square))
			{
				roboto.dropLastItem();
				if (!roboto.isWallAhead())
					roboto.move();
			}
		}
		
		// Drops the rest of the triangles
		roboto.goToCorner(Direction.NORTH, Direction.WEST);
		roboto.dropInRow();
		roboto.turnLeft();
		roboto.move(2);
	}

}
