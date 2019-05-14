
public class WinChecker
{

	public static Player p1 = new Player("X");
	public static Player p2 = new Player("O");
	private final int SIZE = 3;
	protected GameBoard[][] largeBoard = new GameBoard[SIZE][SIZE];
	private static GameBoard active;

	public WinChecker()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				largeBoard[i][j] = new GameBoard();
			}
		}
	}

	public boolean setBoard(GameBoard board, int x, int y, Player player)
	{

		if (active != null && !board.equals(active))
		{
			return false;
		}

		if (board.setBoard(x, y, player))
		{
			active = largeBoard[GameBoard.getLastMove()[0]][GameBoard.getLastMove()[1]];
			return true;
		}
		return false;
	}

	public Player getWinner1()
	{ // returns true if big board is won
		GameBoard consolidated = new GameBoard();
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				consolidated.board[i][j] = largeBoard[i][j].getWinner();

			}
		}
		return consolidated.getWinner();
	}

	public static void main(String[] args)
	{
		WinChecker board1 = new WinChecker();

		board1.setBoard(board1.largeBoard[0][0], 0, 2, p2);
		active = board1.largeBoard[0][0];
		board1.setBoard(board1.largeBoard[0][0], 1, 1, p2);
		active = board1.largeBoard[0][0];
		board1.setBoard(board1.largeBoard[0][0], 2, 0, p2);
		System.out.print(board1.getWinner1().getName());
	}

}