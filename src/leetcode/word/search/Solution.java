package leetcode.word.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * <pre>
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * </pre>
 * 
 */

public class Solution
{
	public boolean exist(char[][] board, String word)
	{
		if (word == null || word.isEmpty())
			return true;

		if (board == null || board.length == 0)
			return false;

		if (board.length * board[0].length < word.length())
			return false;

		Map<Character, List<Position>> dict = preprocess(board);
		boolean visited[][] = new boolean[board.length][board[0].length];

		if (!dict.containsKey(word.charAt(0)))
			return false;

		for (Position node : dict.get(word.charAt(0)))
		{
			if (expand(board, node, word, 1, visited, dict))
				return true;

		}

		return false;
	}

	private Map<Character, List<Position>> preprocess(char[][] board)
	{
		Map<Character, List<Position>> dict = new HashMap<Character, List<Position>>();

		for (int i = 0; i < board.length; i++)
		{
			char[] row = board[i];
			for (int j = 0; j < row.length; j++)
			{
				List<Position> items = dict.get(board[i][j]);
				if (items == null)
				{
					items = new ArrayList<Position>();
					dict.put(board[i][j], items);
				}

				items.add(new Position(i, j));
			}
		}

		return dict;
	}

	private static class Position
	{
		int x;
		int y;

		Position(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	private boolean expand(char[][] board, Position preNode, String word,
			int cur, boolean visited[][], Map<Character, List<Position>> dict)
	{
		if (cur == word.length())
			return true;
		
		if (!dict.containsKey(word.charAt(cur)))
			return false;

		// determine preNode is adjacent to the new node, or has been visited or
		// not.
		visited[preNode.x][preNode.y] = true;
		for (Position node : dict.get(word.charAt(cur)))
		{
			if (!visited[node.x][node.y] && isAdjacent(node, preNode)
					&& expand(board, node, word, cur + 1, visited, dict))
				return true;
		}
		visited[preNode.x][preNode.y] = false;
		return false;
	}

	private boolean isAdjacent(Position preNode, Position node)
	{
		if ((node.x - preNode.x == 0) && Math.abs((node.y - preNode.y)) == 1)
			return true;

		if ((node.y - preNode.y == 0) && Math.abs((node.x - preNode.x)) == 1)
			return true;

		return false;
	}
}
