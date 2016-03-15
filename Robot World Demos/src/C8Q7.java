import java.awt.Color;
import robot.*;

/**
 * Finds a path from the beginning to end of maze, while following the right
 * edge
 * @author Vince Ou
 * @version November 2014
 */
public class C8Q7
{

	public static void main(String[] args)
	{
		// Creates new world and robots and initializes it
		World mazeWorld = new World("maze1.txt");
		Color screwingWithColors = new Color(255,218,185,255);
		Robot roboto = new Robot("Maze Robot", screwingWithColors);
		mazeWorld.addRobotAtStart(roboto);
		roboto.turnLeft();

		while (!roboto.isExitHere())
		{
			// Checks for wall on the right ("hugs" the wall)
			roboto.turnRight();
			while (roboto.isWallAhead())
				roboto.turnLeft();
			roboto.move();
		}
	}
}
