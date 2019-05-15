import java.awt.*;
import javax.swing.*;

public class GameRunner
{

	private static final int SIZE = 3;
	public static JFrame frame = new JFrame();
	public static JFrame frame2 = new JFrame();
	public static JButton[][] buttonArray = new JButton[SIZE * SIZE][SIZE * SIZE];
	public static JButton[][] labelArray = new JButton[SIZE][SIZE];
	public static WinChecker game = new WinChecker();
	public static JFrame winFrame = new JFrame();

	public static Player p1 = new Player("X");
	public static Player p2 = new Player("O");
	public static Player currentPlayer = p1;

	public static void main(String args[])
	{
		
		winFrame.setSize(600,300);
		winFrame.setBackground(Color.LIGHT_GRAY);
		winFrame.setLayout(new FlowLayout());
		frame.setSize(600, 600);
		frame2.setSize(200,200);
		frame.setLayout(new GridLayout(SIZE * SIZE, SIZE * SIZE));
		frame2.setLayout(new GridLayout(SIZE, SIZE));
		frame2.setBackground(Color.LIGHT_GRAY);
		create();
		frame.setVisible(true);
		frame2.setVisible(true);
		while (game.getWinner1() == null)
		{
		}
		JLabel winLB1 = new JLabel();
		winLB1.setIcon(new ImageIcon("winGif.gif"));
		JLabel winLB2 = new JLabel("Congrats Player \""+game.getWinner1().getName() + "\"");
		winFrame.add(winLB1);
		winLB2.setFont(new Font("Comic Sans", Font.BOLD, 30));
		winFrame.add(winLB2);
		frame.setVisible(false);
		frame2.setVisible(false);
		winFrame.setVisible(true);
		
	}

	public static void create()
	{
		JButton button;
		JButton label;
		boolean midRow;
		boolean midColumn;
		for (int i = 0; i < SIZE * SIZE; i++)
		{
			for (int j = 0; j < SIZE * SIZE; j++)
			{
				button = new JButton();
				buttonArray[i][j] = button;
				frame.add("", button);
				button.setBackground(Color.WHITE);
				button.setFont(new Font("Comic Sans", Font.BOLD, 30));
				midRow = i >= SIZE && i < SIZE * 2;
				midColumn = j >= SIZE && j < SIZE * 2;
				if ((midRow || midColumn) && !(midRow && midColumn))
				{
					button.setBackground(Color.LIGHT_GRAY);
				}
				button.addActionListener(new ButtonListener());
			}
		}
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				label = new JButton();
				labelArray[i][j] = label;
				
				label.setBackground(Color.WHITE);
				label.setFont(new Font("Comic Sans", Font.BOLD, 30));
				
				frame2.add("",label);
				
			}
		}
	}

	public static void pressed(JButton button)
	{
		int xVal = 0;
		int yVal = 0;
		for (int x = 0; x < SIZE * SIZE; x++)
		{
			for (int y = 0; y < SIZE * SIZE; y++)
			{
				if (button.equals(buttonArray[x][y]))
				{
					xVal = x;
					yVal = y;

				}
			}
		}
		GameBoard smallPlayingBoard = game.largeBoard[xVal / SIZE][yVal / SIZE];
		xVal = (xVal % SIZE);
		yVal = (yVal % SIZE);
		if (game.setBoard(smallPlayingBoard, xVal, yVal, currentPlayer))
		{
			button.setText(currentPlayer.getName());

			if (currentPlayer.equals(p1))
			{
				currentPlayer = p2;
			} else
			{
				currentPlayer = p1;
			}
		}
	}
	public static JButton[][] getLabelArray()
	{
		return labelArray;
	}

}