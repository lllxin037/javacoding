package leetcode.word.search;

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

public class DFSSolution
{
	public boolean exist(char[][] board, String word)
	{
		if (word == null || word.isEmpty())
			return true;

		if (board == null || board.length == 0)
			return false;

		if (board.length * board[0].length < word.length())
			return false;

		boolean visited[][] = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++)
		{
			char[] row = board[i];
			for (int j = 0; j < row.length; j++)
			{
				if (DFS(board, i, j, word, 0, visited)) return true;
			}
		}

		return false;
	}

	private boolean DFS(char[][] board, int i, int j, String word, int cur,
			boolean visited[][])
	{
		if (word.charAt(cur) != board[i][j] || visited[i][j])
			return false;

		if (cur == word.length() - 1)
			return true;

		visited[i][j] = true;

		if (j - 1 >= 0 && DFS(board, i, j - 1, word, cur + 1, visited))
			return true;

		if (j + 1 < board[0].length
				&& DFS(board, i, j + 1, word, cur + 1, visited))
			return true;

		if (i - 1 >= 0 && DFS(board, i - 1, j, word, cur + 1, visited))
			return true;

		if (i + 1 < board.length
				&& DFS(board, i + 1, j, word, cur + 1, visited))
			return true;

		visited[i][j] = false;
		return false;
	}
}
