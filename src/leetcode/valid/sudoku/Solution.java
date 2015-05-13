package leetcode.valid.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * 
 */

public class Solution
{
	public boolean isValidSudoku(char[][] board)
	{
		if (board == null || board.length != 9)
			return false;

		Set<Integer> numInRow = new HashSet<Integer>();
		Set<Integer> numInCol = new HashSet<Integer>();

		// check row and column.

		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (board[i][j] != '.')
				{
					if (numInRow.contains(Integer.valueOf(board[i][j] - '0')))
						return false;

					numInRow.add(Integer.valueOf(board[i][j] - '0'));
				}

				if (board[j][i] != '.')
				{
					if (numInCol.contains(Integer.valueOf(board[j][i] - '0')))
						return false;

					numInCol.add(Integer.valueOf(board[j][i] - '0'));
				}
			}

			numInRow.clear();
			numInCol.clear();
		}

		// check box.
		Set<Integer> numInBox = new HashSet<Integer>();
		for (int i = 0; i < 9; i += 3)
		{
			for (int j = 0; j < 9; j += 3)
			{
				for (int j2 = i; j2 < i + 3; j2++)
				{
					for (int k = j; k < j + 3; k++)
					{
						if (board[j2][k] != '.')
						{
							if (numInBox.contains(Integer
									.valueOf(board[j2][k] - '0')))
								return false;

							numInBox.add(Integer.valueOf(board[j2][k] - '0'));
						}
					}
				}

				numInBox.clear();
			}
		}

		return true;
	}
}
