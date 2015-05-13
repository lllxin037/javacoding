package leetcode.sudoku.solver;

import java.util.Stack;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 */

public class Solution
{
	public void solveSudoku(char[][] board)
	{
		if (board == null || board.length == 0)
			return;

		int i = 0;
		int j = 0;

		// used to traceback
		Stack<Integer> visitedPos = new Stack<Integer>();
		int nextCandidate = 1;

		while (i < 9)
		{
			if (board[i][j] != '.')
			{
				j++;
				if (j >= 9)
				{
					i++;
					j = 0;
				}

				if (i >= 9)
					break;
				continue;
			}

			// first time, try with 1, only consider increase when rollback
			while (nextCandidate <= 9)
			{
				board[i][j] = (char) (nextCandidate + '0');
				if (canPlace(board, i, j))
					break;

				board[i][j] = (char) (++nextCandidate + '0');
			}

			if (nextCandidate <= 9)
			{
				visitedPos.add( (i << 4) + j);
				j++;
				nextCandidate = 1;

				if (j >= 9)
				{
					i++;
					j = 0;
				}
				continue;
			}

			board[i][j] = '.';

			// need to go back to last visited. empty means invalid case.

			while (!visitedPos.isEmpty())
			{
				int position = visitedPos.pop();
				j = position & 0x0f;
				i = position >> 4;

				nextCandidate = board[i][j] - '0' + 1;
				board[i][j] = '.';
				if (nextCandidate <= 9)
					break;
			}
		}
	}

	private boolean canPlace(char[][] board, int x, int y)
	{
		for (int i = 0; i < 9; i++)
		{
			if (i != y && board[x][i] == board[x][y])
				return false;
			if (i != x && board[i][y] == board[x][y])
				return false;
		}

		for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++)
		{
			for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++)
			{
				if (i != x && j != y && board[i][j] == board[x][y])
					return false;
			}
		}

		return true;
	}
}