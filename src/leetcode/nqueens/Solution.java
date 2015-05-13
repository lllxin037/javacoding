package leetcode.nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * <pre>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * </pre>
 * 
 */

public class Solution
{
	public List<String[]> solveNQueens(int n)
	{
		if (n == 0)
			return new ArrayList<String[]>();

		// the index means the ith row; the value indicates the column position.
		// to determine different columns, board[i] != any in {board[0], board[i
		// -1]}
		// determine diagonal, Math.abs(i - board[i]) != any in {board[0],
		// board[i -1]}

		int[] board = new int[n];
		int INITIAL = -1;

		Arrays.fill(board, INITIAL);
		List<String[]> ret = new ArrayList<String[]>();
		if (n == 0)
			return ret;

		int i = 0;
		int j = 0;

		while (i < n)
		{
			while (j < n)
			{
				if (canPlace(board, i, j))
				{
					board[i] = j;
					if (i < n - 1)
					{
						j = 0;
						break;
					}

					// one result here.
					ret.add(createBoard(board));
				}

				j++;
			}

			if (j < n)
			{
				// go to next line.
				i++;
				continue;
			}

			// restore
			board[i] = INITIAL;
			if (i > 0)
			{
				i--;
				j = board[i] + 1;
				board[i] = INITIAL;
			}
			else
				// the end.
				break;
		}
		return ret;
	}

	private boolean canPlace(int[] board, int i, int j)
	{
		for (int k = 0; k < i; k++)
		{
			if (board[k] == j || Math.abs(k - i) == Math.abs(board[k] - j))
				return false;
		}

		return true;
	}

	private String[] createBoard(int[] board)
	{
		String[] ret = new String[board.length];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < board.length; i++)
		{
			int col = board[i];
			int index = 0;
			while (index++ < col)
				sb.append('.');
			sb.append('Q');
			while (index++ < board.length)
				sb.append('.');
			ret[i] = sb.toString();
			sb.setLength(0);
		}

		return ret;
	}
}