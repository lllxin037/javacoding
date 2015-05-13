package epi.dp;

/**
 *
 */

public class MaximumSubarray
{
	public static int findMaxSubarray(int[] A)
	{
		// assume A.length >= 2;

		int max = A[0];
		int[] dp = new int[A.length];
		dp[0] = A[0];

		int left = 0, right = 0;
		for (int i = 1; i < A.length; i++)
		{
			dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
			if (A[i] > dp[i - 1] + A[i])
				left = i;

			if (dp[i] > max)
				right = i;
			max = Math.max(max, dp[i]);

		}

		System.out.println("left " + left + " right " + right);
		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(findMaxSubarray(new int[]
		{ -2, -3, 4, -1, -2, 1, 5, -3 }));

		System.out.println(findMaxSubarray(new int[]
		{ 904, 40, 523, 12, -335, -385, -124, 481, -31 }));
	}
}
