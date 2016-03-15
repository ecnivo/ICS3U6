import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Handles the board play for a simple game of Connect 4
 * @author ICS3U and Vince Ou
 * @version December 2014
 */
public class ConnectFourBoard extends JPanel implements MouseListener,
		KeyListener
{
	// Program constants (declared at the top, these can be used by any method)
	private final int USSR = -1;
	private final int AMERICA = 1;
	private final int EMPTY = 0;
	private final int TIE = 2;
	//Madeline

	private final int SQUARE_SIZE = 64;
	private final int DROP_DELAY = 10;
	private final int NO_OF_ROWS = 6;
	private final int NO_OF_COLUMNS = 7;
	private final boolean ANIMATION_ON = true;

	public final Dimension BOARD_SIZE =
			new Dimension(NO_OF_COLUMNS * SQUARE_SIZE + 1,
					(NO_OF_ROWS + 1) * SQUARE_SIZE + 1);

	// Program variables (declared at the top, these can be
	// used or changed by any method)
	private int[][] board;
	private boolean droppingPiece;
	private int xFallingPiece, yFallingPiece;
	private int currentPlayer;
	private int currentColumn;
	private Image sovietImage, americaImage;
	private boolean gameOver;
	private int noOfMoves;

	/**
	 * Constructs a new ConnectFourBoard object
	 */
	public ConnectFourBoard()
	{
		// Sets up the board area, loads in piece images and starts a new game
		setPreferredSize(BOARD_SIZE);
		setBackground(new Color(200, 200, 200));

		// Add mouse listeners and Key Listeners to the game board
		addMouseListener(this);
		setFocusable(true);
		addKeyListener(this);
		requestFocusInWindow();

		// Load up the images for the pieces (images from www.iconshock.com)
		sovietImage = new ImageIcon("soviet.png").getImage();
		americaImage = new ImageIcon("america.png").getImage();

		// Sets up the board array and starts a new game
		// Board includes an extra border for easier checking
		board = new int[NO_OF_ROWS + 2][NO_OF_COLUMNS + 2];

		newGame();
	}

	/**
	 * Starts a new game
	 */
	public void newGame()
	{
		currentPlayer = AMERICA;
		clearBoard();
		gameOver = false;
		currentColumn = NO_OF_COLUMNS / 2 + 1;
		droppingPiece = false;
		repaint();
		noOfMoves = 0;
	}

	// Your code for the clearBoard, findRow and checkForWinner method goes
	// below. Remember to include proper javadoc comments
	// Since board is an instance variable that is available to all methods
	// it no longer needs to be a parameter

	/**
	 * Clears the game board, for example, during a new game command
	 */
	private void clearBoard()
	{
		// Iterates through rows
		for (int row = 0; row < board.length; row++)
			// Iterates through columns
			for (int column = 0; column < board[row].length; column++)
				// Sets each cell to empty
				board[row][column] = EMPTY;
	}

	/**
	 * Finds the lowest row to fill in piece from player
	 * @param column the column the player is dropping a piece in
	 * @return the row that will work for the column
	 */
	private int findRow(int column)
	{
		// Goes from bottom to top of each column
		int row = board.length - 1;
		while (row > 0)
		{
			// If it's empty, then returns and quits method
			if (board[row - 1][column] == EMPTY)
				return row - 1;
			row--;
		}
		// If filled, then returns zero (top)
		return 0;
	}

	/**
	 * Finds the winner of the game after every turn
	 * @param lastRow The last piece's row
	 * @param lastColumn The last piece's column
	 * @return The player that has won
	 */
	private int checkForWinner(int lastRow, int lastColumn)
	{
		// Gets the last player
		int currentPlayer = board[lastRow][lastColumn];
		// Checks all directions except up
		if (checkHoriz(lastRow, lastColumn, currentPlayer) || checkDown(lastRow, lastColumn, currentPlayer) || (checkPositiveSlope(lastRow, lastColumn, currentPlayer) || checkNegativeSlope(lastRow, lastColumn, currentPlayer)))
			return currentPlayer;
		// Checks for tie games
		else if (noOfMoves >= 41)
			return TIE;
		// If none of these combinations exist, then no player has won
		else 
			return EMPTY;
	}

	/**
	 * Checks horizontally along the grid
	 * @param row y coordinate to search from
	 * @param col x coordinate to search from
	 * @param player the player to match for
	 * @return if there is any combination of four similar tiles
	 */
	private boolean checkHoriz(int row, int col, int player)
	{
		// Gets the far left and far right coordinates of matching tiles
		int leftCol = col - 1;
		while (board[row][leftCol] == player)
			leftCol--;

		int rightCol = col + 1;
		while (board[row][rightCol] == player)
			rightCol++;

		// If the distance between them is more than then required tiles, then
		// there must be sufficient consecutive tiles
		if (rightCol - leftCol > 4)
			return true;
		else
			return false;
	}

	/**
	 * Checks vertically for any match. The player cannot win by placing a tile
	 * with other matching ones on top, so it only has to check downwards
	 * @param row The row to check from
	 * @param col The column to check from
	 * @param player The player to match to
	 * @return Whether or not there is a set of four tiles to connect
	 */
	private boolean checkDown(int row, int col, int player)
	{
		// Goes down from the starting point
		int origRow = row;
		while (board[row][col] == player)
			row++;
		// If there are sufficient tiles, then it must be a win, and returns
		// appropriately
		if (row - origRow >= 4)
			return true;
		else
			return false;
	}

	/**
	 * Checks on a slope going from the bottom left to the top right
	 * @param row The row to start from
	 * @param col The column to start from
	 * @param player The player to match to
	 * @return Whether or not there is a match
	 */
	private boolean checkPositiveSlope(int row, int col, int player)
	{
		// Gets the original row and column
		int origRow = row;
		int origCol = col;

		// Goes up and right
		int goUp = 1;
		while (board[row - goUp][col + goUp] == player)
			goUp++;

		// Goes down and left
		int goDown = 0;
		while (board[row + goDown][col - goDown] == player)
			goDown++;

		// Returns accordingly if there are sufficient tiles
		if (goUp + goDown >= 5)
			return true;
		else
			return false;
	}

	/**
	 * Checks on a slope from the bottom right to the top left
	 * @param row The row to start from
	 * @param col The column to start from
	 * @param player The player to match to
	 * @return Whether or not there are sufficient tiles to match
	 */
	private boolean checkNegativeSlope(int row, int col, int player)
	{
		// Gets the original row and column
		int origRow = row;
		int origCol = col;

		// Counts while going down
		int goDown = 1;
		while (board[row + goDown][col + goDown] == player)
			goDown++;

		// Counts while going up
		int goUp = 0;
		while (board[row - goUp][col - goUp] == player)
			goUp++;

		// If the total is sufficient, then it will return accordingly
		if (goDown + goUp >= 5)
			return true;
		else
			return false;
	}

	/**
	 * Makes a move on the board (if possible)
	 * @param selectedColumn the selected column to move in
	 */
	private void makeMove(int selectedColumn)
	{
		// Don't make any moves once the game is over
		if (gameOver)
		{
			JOptionPane.showMessageDialog(this,
					"Please Select Game...New to start a new game",
					"Game Over", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// Find the row that the piece should fall to
		// Make sure that the column is not full
		int row = findRow(selectedColumn);
		if (row <= 0)
		{
			JOptionPane.showMessageDialog(this,
					"Please Select another Column",
					"Column is Full", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Animate the falling piece if required and then place
		// the piece on the board
		if (ANIMATION_ON)
			animatePiece(currentPlayer, selectedColumn, row);
		board[row][selectedColumn] = currentPlayer;

		// Call checkForWinner and display a winning message as required.
		int winner = checkForWinner(row, selectedColumn);
		if (winner == USSR || winner == AMERICA)
		{
			gameOver = true;
			repaint(0);
			JOptionPane.showMessageDialog(this,
					(winner == USSR) ? "USSR Wins!"
							: "America Wins!", "Game Over",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else if (winner == TIE)
		{
			gameOver = true;
			repaint(0);
			JOptionPane.showMessageDialog(this, "Tie Game!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			// Switch to the other player
			currentPlayer *= -1;

		// Start piece in centre or the top row
		currentColumn = NO_OF_COLUMNS / 2 + 1;
		
		// Iterates number of moves to count for tie game
		noOfMoves++;
		System.out.println(noOfMoves);

		repaint();
	}

	/**
	 * Animates a falling piece
	 * @param player the player whose piece is falling
	 * @param column the column the piece is falling in
	 * @param finalRow the final row the piece will fall to
	 */
	private void animatePiece(int player, int column, int finalRow)
	{
		droppingPiece = true;
		for (double row = 0; row < finalRow; row += 0.20)
		{
			// Find the x and y positions for the falling piece
			xFallingPiece = (column - 1) * SQUARE_SIZE;
			yFallingPiece = (int) (row * SQUARE_SIZE);

			// Update the drawing area around the falling piece
			paintImmediately(xFallingPiece, yFallingPiece - 100,
					SQUARE_SIZE, SQUARE_SIZE + 100);

			delay(DROP_DELAY);
		}
		droppingPiece = false;
	}

	/**
	 * Delays the given number of milliseconds
	 * @param milliSec The number of milliseconds to delay
	 */
	private void delay(int milliSec)
	{
		try
		{
			Thread.sleep(milliSec);
		}
		catch (InterruptedException e)
		{
		}
	}

	/**
	 * Repaint the board's drawing panel
	 * @param g The Graphics context
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// Redraw the board with current pieces
		for (int row = 1; row <= NO_OF_ROWS; row++)
			for (int column = 1; column <= NO_OF_COLUMNS; column++)
			{
				// Find the x and y positions for each row and column
				int xPos = (column - 1) * SQUARE_SIZE;
				int yPos = row * SQUARE_SIZE;

				// Draw the squares
				g.setColor(Color.BLUE);
				g.drawRoundRect(xPos, yPos, SQUARE_SIZE, SQUARE_SIZE, 10, 10);

				// Draw each piece, depending on the value in board
				if (board[row][column] == USSR)
					g.drawImage(sovietImage, xPos, yPos, this);
				else if (board[row][column] == AMERICA)
					g.drawImage(americaImage, xPos, yPos, this);
			}

		// Draw a moving piece if animating
		if (droppingPiece)
		{
			if (currentPlayer == USSR)
				g.drawImage(sovietImage, xFallingPiece, yFallingPiece, this);
			else
				g.drawImage(americaImage, xFallingPiece, yFallingPiece, this);
		}
		else if (!gameOver)
		// Draw the next player
		{
			if (currentPlayer == USSR)
				g.drawImage(sovietImage, (currentColumn - 1) * SQUARE_SIZE,
						0, this);
			else
				g.drawImage(americaImage, (currentColumn - 1) * SQUARE_SIZE,
						0, this);
		}
	} // paint component method

	// Keyboard events you can listen for since this JPanel is a KeyListener
	/**
	 * Responds to a keyPressed event
	 * @param event information about the key pressed event
	 */
	public void keyPressed(KeyEvent event)
	{
		// Change the currentRow and currentColumn of the player
		// based on the key pressed
		if (event.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if (currentColumn > 1)
				currentColumn--;
		}
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if (currentColumn < NO_OF_COLUMNS)
				currentColumn++;
		}
		// These keys indicate player's move
		else if (event.getKeyCode() == KeyEvent.VK_DOWN
				|| event.getKeyCode() == KeyEvent.VK_ENTER
				|| event.getKeyCode() == KeyEvent.VK_SPACE)
		{
			makeMove(currentColumn);
		}

		// Repaint the screen after the change
		repaint();
	}

	// Extra methods needed since this game board is a KeyListener
	public void keyReleased(KeyEvent event)
	{
	}

	public void keyTyped(KeyEvent event)
	{
	}

	// Mouse events you can listen for since this JPanel is a MouseListener
	/**
	 * Responds to a mousePressed event
	 * @param event information about the mouse pressed event
	 */
	public void mousePressed(MouseEvent event)
	{
		// Calculate which column was clicked, then make
		// the player's move for that column
		int selectedColumn = event.getX() / SQUARE_SIZE + 1;
		makeMove(selectedColumn);
	}

	// Extra methods needed since this game board is a MouseListener

	public void mouseReleased(MouseEvent event)
	{
	}

	public void mouseClicked(MouseEvent event)
	{
	}

	public void mouseEntered(MouseEvent event)
	{
	}

	public void mouseExited(MouseEvent event)
	{
	}
}
