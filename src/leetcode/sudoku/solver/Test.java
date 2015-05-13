package leetcode.sudoku.solver;

public class Test
{
	private static void oneCase(char[][] board)
	{
		System.out.println("#########################");
		RecursiveSolution s1 = new RecursiveSolution();

		s1.solveSudoku(board);
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			
			System.out.println();
		}
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new char[][]
		{
		{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
		{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
		{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
		{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
		{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
		{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
		{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
		{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
		{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }, });

	}
}
