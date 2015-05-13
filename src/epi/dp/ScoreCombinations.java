package epi.dp;

import java.util.Arrays;

/**
 * You have an aggregate score s and W which specifies the points that can be
 * scored in an individual play. How would you find the number of combinations
 * of plays that result in an aggregate score of s? How would you compute the
 * number of distinct sequences of individual plays that result in a score of s?
 */

public class ScoreCombinations
{
	public static int combination(int s, int[] W)
	{
		int[] dp = new int[s + 1];
		dp[0] = 1; // one way to reach 0.

		for (int val : W)
		{
			for (int i = val; i <= s; i++)
			{
				dp[i] += dp[i - val];
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[s];
	}

	public static int permute(int s, int[] W)
	{
		int[] dp = new int[s + 1];
		dp[0] = 1; // one way to reach 0.

		for (int i = 0; i <= s; i++)
		{
			for (int val : W)
			{
				if (i >= val)
					dp[i] = dp[i] + dp[i - val];
			}
		}

		return dp[s];
	}

	public static int permute1(int s, int[] W)
	{
		int[] counter = new int[1];

		permuteHelper(s, counter, W, 0);
		return counter[0];
	}

	private static void permuteHelper(int s, int[] counter, int[] W, int index)
	{
		if (s == 0)
		{
			counter[0]++;
			return;
		}

		for (int i = index; i < W.length; i++)
		{
			int val = W[i];
			if (val > s)
				continue;

			permuteHelper(s - val, counter, W, i);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(combination(12, new int[]
		{ 2, 3, 7 }));
	}
}
