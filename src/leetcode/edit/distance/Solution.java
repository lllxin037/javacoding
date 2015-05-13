package leetcode.edit.distance;

public class Solution
{
	public int minDistance(String word1, String word2)
	{
		int len1 = word1.length();
		int len2 = word2.length();

		int[][] dp = new int[2][len1 + 1];

		for (int i = 0; i < len1 + 1; i++)
			dp[0][i] = i;

		for (int i = 0; i < len2; i++)
		{
			int index = ((i + 1) & 0x1);
			int lastIndex = (i & 0x1);

			dp[index][0] = i + 1;

			char c = word2.charAt(i);
			for (int j = 0; j < len1; j++)
			{
				int diff = 1;
				if (c == word1.charAt(j))
					diff = 0;

				int minDiff = dp[lastIndex][j] + diff;
				minDiff = Math.min(minDiff, dp[lastIndex][j + 1] + 1);
				minDiff = Math.min(minDiff, dp[index][j] + 1);
				dp[index][j + 1] = minDiff;
			}
		}

		return dp[len2 & 1][len1];
	}

}
