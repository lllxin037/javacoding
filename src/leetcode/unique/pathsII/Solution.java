package leetcode.unique.pathsII;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * <pre>
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * </pre>
 * 
 * Note: m and n will be at most 100.
 * 
 */

public class Solution
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		if (obstacleGrid == null || obstacleGrid[0].length == 0)
			return 0;

		int[] dp = new int[obstacleGrid[0].length];
		dp[0] = 1 - obstacleGrid[0][0];

		for (int i = 1; i < obstacleGrid[0].length; i++)
			dp[i] = ((1 - obstacleGrid[0][i]) & dp[i - 1]);

		for (int i = 1; i < obstacleGrid.length; i++)
		{
			dp[0] = ((1 - obstacleGrid[i][0]) & dp[0]);

			for (int j = 1; j < obstacleGrid[0].length; j++)
				dp[j] = (obstacleGrid[i][j] == 0 ? (dp[j - 1] + dp[j]) : 0);
		}
		return dp[obstacleGrid[0].length - 1];
	}
}
