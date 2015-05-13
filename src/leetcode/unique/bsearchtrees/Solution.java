package leetcode.unique.bsearchtrees;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * <pre>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 */

public class Solution
{
	public int numTrees(int n)
	{
		if (n == 0)
			return 0;

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++)
		{
			int oneRound = 0;
			int half = i / 2;

			for (int j = 0; j < half; j++)
			{
				oneRound += dp[j] * dp[i - 1 - j] * 2;
			}
			
			if ( i % 2 == 1)
			{
				oneRound += dp[half]*dp[half];				
			}
			
			dp[i] = oneRound;
		}

		return dp[n];
	}

}
