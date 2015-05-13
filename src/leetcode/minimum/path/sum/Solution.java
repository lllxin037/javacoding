package leetcode.minimum.path.sum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 */
public class Solution
{
	public int minPathSum(int[][] grid)
	{
		if (grid == null || grid.length == 0)
			return 0;

		int[][] dp = new int[2][grid[0].length];
		dp[0][0] = grid[0][0];

		int cur = 0;
		for (int i = 1; i < grid[0].length; i++)
			dp[cur][i] = dp[cur][i - 1] + grid[cur][i];

		for (int i = 1; i < grid.length; i++)
		{
			int last = cur;
			cur = 1 - cur;

			dp[cur][0] = dp[last][0] + grid[i][0];

			for (int j = 1; j < grid[0].length; j++)
			{
				dp[cur][j] = Math.min(dp[cur][j - 1], dp[last][j]) + grid[i][j];
			}
		}

		return dp[cur][grid[0].length - 1];

	}
}
