package leetcode.sudoku.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

public class RecursiveSolution
{
	public void solveSudoku(char[][] board)
	{
		if (board == null || board.length == 0)
			return;

		Map<Integer, Set<Integer>> candidates = new HashMap<Integer, Set<Integer>>();
		init(board, candidates);

		solveSudokuHelper(board, candidates, 0, 0);
	}

	private boolean solveSudokuHelper(char[][] board,
			Map<Integer, Set<Integer>> candidates, int x, int y)
	{
		int[] position = new int[]
		{ x, y };
		getNextEmpty(position, board);
		x = position[0];
		y = position[1];

		if (x >= 9)
			return true;

		Set<Integer> options = candidates.get((x << 4) + y);
		// candidates.remove((x << 4) + y);

		for (Integer num : options)
		{
			board[x][y] = (char) (num + '0');

			List<Integer> touched = new ArrayList<Integer>();
			if (canPlace(board, x, y, num, candidates, touched)
					&& solveSudokuHelper(board, candidates, x, y))
				return true;

			for (Integer touch : touched)
				candidates.get(touch).add(Integer.valueOf(num));
		}
		// candidates.put((x << 4) + y, options);

		board[x][y] = '.';

		return false;
	}

	private void getNextEmpty(int[] position, char[][] board)
	{
		int x = position[0];
		int y = position[1];

		while (x < 9 && board[x][y] != '.')
		{
			y++;
			if (y >= 9)
			{
				x++;
				y = 0;
			}
		}

		position[0] = x;
		position[1] = y;
	}

	private boolean canPlace(char[][] board, int x, int y, int num,
			Map<Integer, Set<Integer>> candidates, List<Integer> touched)
	{
		for (Integer position : candidates.keySet())
		{
			int j = position & 0x0f;
			int i = position >> 4;

			if (i < x || (i == x && j <= y))
				continue;
			if (x == i || y == j || ((x / 3) == (i / 3) && (y / 3) == (j / 3)))
			{
				if (candidates.get(position).remove(Integer.valueOf(num)))
				{
					touched.add(position);
					if (candidates.get(position).isEmpty())
						return false;
				}
			}
		}

		return true;
	}

	private void init(char[][] board, Map<Integer, Set<Integer>> candidates)
	{
		List<Set<Integer>> numsInRow = new ArrayList<Set<Integer>>();
		List<Set<Integer>> numsInCol = new ArrayList<Set<Integer>>();
		List<Set<Integer>> numsInBox = new ArrayList<Set<Integer>>();

		for (int i = 0; i < 9; i++)
		{
			Set<Integer> oneRow = new HashSet<Integer>();
			Set<Integer> oneCol = new HashSet<Integer>();

			for (int j = 0; j < 9; j++)
			{
				if (board[i][j] != '.')
					oneRow.add(board[i][j] - '0');
				if (board[j][i] != '.')
					oneCol.add(board[j][i] - '0');
			}

			numsInRow.add(oneRow);
			numsInCol.add(oneCol);
		}

		for (int i = 0; i < 9; i += 3)
		{
			for (int j = 0; j < 9; j += 3)
			{
				Set<Integer> oneBox = new HashSet<Integer>();
				for (int k = 0; k < 3; k++)
				{
					if (board[i][j + k] != '.')
						oneBox.add(board[i][j + k] - '0');
					if (board[i + k][j] != '.')
						oneBox.add(board[i + k][j] - '0');
				}

				numsInBox.add(oneBox);
			}
		}

		for (int i = 0; i < 9; i++)
		{
			int boxnum = (i / 3) * 3;
			for (int j = 0; j < 9; j++)
			{
				if (board[i][j] != '.')
					continue;
				Set<Integer> array = new HashSet<Integer>(Arrays.asList(1, 2,
						3, 4, 5, 6, 7, 8, 9));
				array.removeAll(numsInRow.get(i));
				array.removeAll(numsInCol.get(j));
				array.removeAll(numsInBox.get(boxnum + (j / 3)));

				candidates.put((i << 4) + j, array);
			}
		}
	}
}