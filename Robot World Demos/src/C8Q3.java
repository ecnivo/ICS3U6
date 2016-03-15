import java.awt.Color;

import robot.Direction;
import robot.Robot;
import robot.World;


public class C8Q3
{

	public static void main(String[] args)
	{
		World worldOne = new World(12,12);
		Robot robotOne = new Robot("Name", Color.CYAN);
		worldOne.addRobot(robotOne, 3, 10, Direction.WEST);
		for (int i = 0; i < 7; i++)
		{
			robotOne.move();
		}
		
		robotOne.turnLeft();
		robotOne.turnLeft();
		
		for (int i = 0; i < 7; i++)
		{
			robotOne.move();
		}
	}

}
