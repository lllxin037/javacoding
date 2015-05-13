package epi.dp;

import java.util.Arrays;
import java.util.Random;

public class KnapsackProblem
{
	/**
	 * @param w
	 * @param items
	 * @return
	 */

	public static int knapsack(int w, int[][] items)
	{
		// item[0] is the value, item[1] is the weight
		int n = items.length;
		int[][] dp = new int[n + 1][w + 1];

		for (int i = 1; i <= items.length; i++)
		{
			int wi = items[i - 1][1];
			int vi = items[i - 1][0];

			for (int j = w; j >= 0; j--)
			{
				if (wi <= j)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wi] + vi);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][w];
	}

	public static int knapsackOptimized(int w, int[][] items)
	{
		// item[0] is the value, item[1] is the weight
		int[] dp = new int[w + 1];

		for (int i = 1; i <= items.length; i++)
		{
			int wi = items[i - 1][1];
			int vi = items[i - 1][0];

			for (int j = w; j >= wi; j--)
				dp[j] = Math.max(dp[j], dp[j - wi] + vi);

		}

		return dp[w];
	}

	public static void main(String[] args)
	{
		System.out.println("****************************");

		System.out.println(knapsack(97, new int[][]
		{
		{ 53, 37 },
		{ 54, 43 },
		{ 29, 26 },
		{ 93, 29 },
		{ 7, 5 } }));
		System.out.println("****************************");

		Random r = new Random();

		int n, W;

		n = r.nextInt(3) + 3;
		W = r.nextInt(100) + 10;
		int[][] items = new int[n][2];

		System.out.println("****************************");
		for (int i = 0; i < n; i++)
		{
			items[i][0] = r.nextInt(100) + 3;
			items[i][1] = r.nextInt(50) + 2;

			System.out.println(Arrays.toString(items[i]));
		}

		System.out.println("knapsack size = " + W);
		System.out.println("all value = " + knapsack(W, items));
		System.out.println("all value = " + knapsackOptimized(W, items));
		System.out.println("****************************");
	}
}
