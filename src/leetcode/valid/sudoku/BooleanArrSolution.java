package leetcode.valid.sudoku;

import java.util.Arrays;

public class BooleanArrSolution
{
	private boolean isValid(char c, boolean[] numbers)
	{
		if (c == '.')
			return true;
		if (!(c >= '1' || c <= '9') || numbers[c - '1'])
			return false;
		numbers[c - '1'] = true;
		return true;
	}

	public boolean isValidSudoku(char[][] board)
	{
		if (board.length != 9)
			return false;
		if (board[0].length != 9)
			return false;

		for (int i = 0; i < 9; ++i)
		{
			boolean[] block = new boolean[9];
			for (int j = 0; j < 9; ++j)
			{ // row i
				if (!isValid(board[i][j], block))
					return false;
			}

			Arrays.fill(block, false);
			for (int j = 0; j < 9; ++j)
			{ // column i
				if (!isValid(board[j][i], block))
					return false;
			}

			Arrays.fill(block, false);
			int row = (i / 3) * 3, col = (i % 3) * 3;
			for (int j = 0; j < 9; ++j)
			{ // box i
				if (!isValid(board[row + j / 3][col + (j % 3)], block))
					return false;
			}
		}

		return true;
	}
}
