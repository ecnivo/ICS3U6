import java.util.Scanner;


public class LettersInCommon
{
	public static String lettersInCommon(String one, String two)
	{
		String output = "";
		one = one.toLowerCase();
		two = two.toLowerCase();
		int length = one.length();
		for (int pos = 0; pos < length; pos++)
		{
			char charHere = one.charAt(pos);
			if (two.indexOf(charHere) != -1 && output.indexOf(charHere) == -1)
				output += charHere;
		}
		return output;
	}
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		while (true){
			String uno = keyboard.nextLine();
			String dos = keyboard.nextLine();
			System.out.println(lettersInCommon(uno,dos));
		}
	}
}
