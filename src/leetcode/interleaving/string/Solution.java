package leetcode.interleaving.string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * <pre>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * </pre>
 * 
 */
public class Solution
{
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if (s3 == null)
			return (s1 == null && s2 == null);

		if (s3.isEmpty())
			return ((s1 == null || s1.isEmpty()) && (s2 == null || s2.isEmpty()));

		int s1Len = s1.length();
		int s2Len = s2.length();

		if (s1Len + s2Len != s3.length())
			return false;

		boolean dp[][] = new boolean[s1Len + 1][s2Len + 1];

		for (int i = 0; i <= s1Len; i++)
		{
			for (int j = 0; j <= s2Len; j++)
			{
				if (i == 0 && j == 0)
				{
					dp[0][0] = true;
					continue;
				}

				if (i == 0 && s2.charAt(j - 1) == s3.charAt(j - 1))
					dp[0][j] = dp[0][j - 1];
				else if (j == 0 && s1.charAt(i - 1) == s3.charAt(i - 1))
					dp[i][0] = dp[i - 1][0];
				else if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)
						&& s2.charAt(j - 1) != s3.charAt(i + j - 1))
					dp[i][j] = dp[i - 1][j];
				else if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)
						&& s1.charAt(i - 1) != s3.charAt(i + j - 1))
					dp[i][j] = dp[i][j - 1];
				else if (i > 0 && j > 0
						&& s2.charAt(j - 1) == s3.charAt(i + j - 1)
						&& s1.charAt(i - 1) == s3.charAt(i + j - 1))
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

			}
		}

		return dp[s1Len][s2Len];
	}
}
