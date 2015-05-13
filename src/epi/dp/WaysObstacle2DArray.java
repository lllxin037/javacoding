package epi.dp;

public class WaysObstacle2DArray
{
	public static int numberOfWaysWithObstacles(int n, int m, boolean[][] B)
	{
		if (B[0][0] || B[n - 1][m - 1])
			return 0;

		// use two row to store the cached values: last row and current row;
		int[][] dp = new int[2][m];

		dp[0][0] = (!B[0][0] ? 1 : 0);

		// calculate the initial row.
		for (int i = 1; i < m; i++)
			dp[0][i] = (dp[0][i - 1] == 1 && !B[0][i]) ? 1 : 0;

		for (int i = 1; i < n; i++)
		{
			int cur = (i & 1);
			int last = 1 - cur;

			for (int j = 0; j < m; j++)
			{
				if (B[i][j])
					dp[cur][j] = 0;
				else
				{
					dp[cur][j] = dp[last][j];
					if (j > 0)
						dp[cur][j] += dp[cur][j - 1];
				}
			}
		}

		return dp[((n - 1) & 1)][m - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(numberOfWaysWithObstacles(3, 4, new boolean[][]
		{
		{ false, false, false, false },
		{ false, true, false, false },
		{ false, false, false, false } }));

		System.out.println(numberOfWaysWithObstacles(3, 4, new boolean[][]
		{
		{ true, false, false, false },
		{ false, true, false, false },
		{ false, false, false, false } }));

		System.out.println(numberOfWaysWithObstacles(6, 3, new boolean[][]
		{
		{ false, false, true },
		{ false, false, false },
		{ false, true, false },
		{ false, false, true },
		{ false, false, false },
		{ false, false, true } }));

		System.out.println(numberOfWaysWithObstacles(3, 3, new boolean[][]
		{
		{ false, false, false },
		{ false, false, false },
		{ false, false, true } }));
	}
}
