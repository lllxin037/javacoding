package google;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-
 * subsequence/
 * 
 */

public class LongestCommonSubsequence
{
	public int lcs(String s, String t)
	{
		int m = s.length();
		int n = t.length();

		int[][] dp = new int[m + 1][n + 1];
		dp[0][0] = 0;

		for (int i = 1; i < m; i++)
			dp[i][0] = 0;
		for (int i = 1; i < n; i++)
			dp[0][i] = 0;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (s.charAt(i) == t.charAt(j))
					dp[i + 1][j + 1] = dp[i][j] + 1;
				else
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
			}
		}

		return dp[m][n];
	}

	public static void main(String args[])
	{
		LongestCommonSubsequence s = new LongestCommonSubsequence();
		System.out.println(s.lcs("AGGTAB", "GXTXAYB"));
	}
}
