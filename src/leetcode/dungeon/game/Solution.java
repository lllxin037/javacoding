package leetcode.dungeon.game;

/**
 * <pre>
 * -2 (K)	-3	  3
 * -5	    -10	  1
 * 10	    30	 -5 (P)
 * 
 * </pre>
 */

public class Solution
{
	public int calculateMinimumHP(int[][] dungeon)
	{
		if (dungeon == null || dungeon.length == 0)
			return 0;

		int cols = dungeon[0].length;
		int dp[][] = new int[2][cols];

		int rows = dungeon.length;

		int cur = -1;

		for (int i = rows - 1; i >= 0; i--)
		{
			cur = i & 1;
			int last = 1 - cur;
			
			// calculate dungeon[i][cols - 1] first.
			int min = 1;			
			if (i == rows - 1)
				last = -1;
			else
				min = dp[last][cols - 1];

			if (dungeon[i][cols - 1] >= min)
				dp[cur][cols - 1] = 1;
			else
				dp[cur][cols - 1] = min - dungeon[i][cols - 1];

			for (int j = cols - 2; j >= 0; j--)
			{
				min = dp[cur][j + 1];
				if (last != -1)
					min = Math.min(dp[last][j], min);

				if (dungeon[i][j] >= min)
					dp[cur][j] = 1;
				else
					dp[cur][j] = min - dungeon[i][j];
			}
		}

		return dp[cur][0];
	}
}