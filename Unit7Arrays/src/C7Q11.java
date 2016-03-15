import java.util.Scanner;

/**
 * Re-creates a magic eight ball as a "computer advisor" program
 * @author Vince Ou
 * @version December 2014
 */
public class C7Q11
{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("MAGIC TEN COMPUTER SUGGESTION PROVIDER \n");
		System.out.print("QUESTION: ");
		String userIn = keyboard.nextLine();

		String[] answers = { "Do you expect me to know more than you?",
				"Make your own decisions!",
				"I haven't passed the Turing test yet", "You should.",
				"Why not?", "I would agree with you", "Lol nope",
				"Hey, don't do that!", "I respectfully disagree", "NO!!!!!" };
		while (!userIn.equals("Bye"))
		{
			int randomIndex = (int) (Math.random() * 10);
			System.out.println("ANSWER: " + answers[randomIndex]);
			System.out.print("QUESTION: ");
			userIn = keyboard.nextLine();
		}
		System.out.println("Thanks for using the Magic Ten Computer Suggestion Provider");
		keyboard.close();
	}
}
