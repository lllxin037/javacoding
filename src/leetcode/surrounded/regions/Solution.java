package leetcode.surrounded.regions;

import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * <pre>
 * For example,
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * </pre>
 * 
 * 
 */

public class Solution
{
	/**
	 * flood-fill algorithm to resolve this problem. Only consider flood from 4
	 * borders.
	 * 
	 * @param board
	 */

	public void solve(char[][] board)
	{
		if (board.length == 0)
			return;
		
		if (board[0].length == 0)
			return;
		
		int width = board[0].length;
		
		boolean[][] marked = new boolean[board.length][width];
		boolean[][] flipping = new boolean[board.length][width];

		for (int i = 0; i < flipping.length; i++)
		{
			for (int j = 0; j < width; j++)
			{
				flipping[i][j] = true;
			}
		}
		
		for (int i = 0; i < board.length; i++)
		{
			floodFill(board, i, 0, marked, flipping);
		}

		for (int i = 0; i < board.length; i++)
		{
			floodFill(board, i, board[0].length - 1, marked, flipping);
		}

		for (int i = 1; i < width - 1; i++)
		{
			floodFill(board, 0, i, marked, flipping);
		}

		for (int i = 1; i < width - 1; i++)
		{
			floodFill(board, board.length - 1, i, marked, flipping);
		}
		
		for (int i = 0; i < flipping.length; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if (flipping[i][j])
				{
					board[i][j] = 'X';
				}
			}
		}
	}

	private void floodFill(char[][] board, int i, int j, boolean[][] marked,
			boolean[][] flipping)
	{
		if (board[i][j] == 'X')
			return;

		Stack<Point> stack = new Stack<Point>();
		stack.push(new Point(i, j));

		while (!stack.isEmpty())
		{
			Point p = stack.pop();

			if (p.x < 0)
				continue;
			if (p.y < 0)
				continue;
			if (p.x >= marked.length)
				continue;
			if (p.y >= marked[0].length)
				continue;

			if (marked[p.x][p.y])
				continue;
			marked[p.x][p.y] = true;
			
			if (board[p.x][p.y] == 'X')
				continue;

			flipping[p.x][p.y] = false;

			// check (i-1, j), (i+1, j), (i, j-1), (i, j+1)
			stack.push(new Point(p.x - 1, p.y));
			stack.push(new Point(p.x + 1, p.y));
			stack.push(new Point(p.x, p.y - 1));
			stack.push(new Point(p.x, p.y + 1));
		}
	}

	private static class Point
	{
		int x;
		int y;

		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}