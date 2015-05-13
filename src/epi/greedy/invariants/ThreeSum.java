package epi.greedy.invariants;

import java.util.Arrays;

public class ThreeSum
{
	public static boolean hasThreeSum(int[] A, int t)
	{
		Arrays.sort(A);

		for (int i = 0; i < A.length - 2; i++)
		{
			int val = A[i];
			if (hasTwoSum(A, t - val))
				return true;
		}

		return false;
	}

	private static boolean hasTwoSum(int[] A, int t)
	{
		int low = 0;
		int high = A.length - 1;
		while (low < high)
		{
			if (A[low] + A[high] == t)
				return true;
			else if (A[low] + A[high] < t)
				low++;
			else
				high--;
		}

		return false;
	}

	public static void main(String args[])
	{
		System.out.println(hasThreeSum(new int[]
		{ -1, 0, 1 }, 0));

		System.out.println(hasThreeSum(new int[]
		{ -1, -1, 2 }, 0));

		System.out.println(hasThreeSum(new int[]
		{ -1, 0, 1, 2, -1, -4 }, 0));

		System.out.println(hasThreeSum(new int[]
		{ 0, 0, 0, 0 }, 0));

		System.out.println(hasThreeSum(new int[]
		{ -2, 0, 1, 1, 2 }, 0));

		System.out.println(hasThreeSum(new int[]
		{ 1, 2, 4, 3, 2 }, 10));
	}

}
