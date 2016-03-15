public class C7Q21
{

	public static void main(String[] args)
	{
		boolean[][] seating = new boolean[6][7];
	}

	public static int bestRowAvailable(boolean[][] seating, int seats)
	{
		for (int row = 0; row < seating.length; row++)
		{
			for (int col = 0; col < seating[row].length; col++)
			{
				if(seating[row][col] == false)
				{
					int currentStreak = 0;
					while (currentStreak < seats && seating[row][col + 1])
					{
						currentStreak++;
					}
					
					if (currentStreak == seats)
						return row;
				}
			}
		}
		return -1;
	}

}
