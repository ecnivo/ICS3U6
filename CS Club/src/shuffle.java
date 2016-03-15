import java.util.Scanner;
/**
*@author Vince Ou
*/
public class shuffle
{

	public static void main(String[] args)
	{
		char[] playlist = {'A','B','C','D','E',' '};
		
		Scanner keyboard = new Scanner(System.in);
		
		int button = keyboard.nextInt();
		int times = keyboard.nextInt();
		
		if (button == 1)
		{
			playlist[6] = playlist[1];
			
		}
	}
}
