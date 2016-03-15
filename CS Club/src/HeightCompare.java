import java.util.*;

/**
*@author Vince Ou
*/
public class HeightCompare
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int noOfStudents = input.nextInt();
		int comparisons = input.nextInt();
		
		boolean[][] students = new boolean[noOfStudents + 1][noOfStudents + 1];
		for (int bleh = comparisons; bleh > 0; bleh--)
		{
			int x = input.nextInt();
			int y = input.nextInt();
			students[y][x] = true;
		}
		
				
		
		
		
		for (boolean[] i : students)
		{
			for (boolean j : i)
			{
				System.out.print(j ? 1 : 0);
			}
			System.out.println();
		}
	}	
}
