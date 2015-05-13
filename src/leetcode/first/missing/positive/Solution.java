package leetcode.first.missing.positive;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * <pre>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * </pre>
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 */

public class Solution
{
	public int firstMissingPositive(int[] A)
	{
		if (A == null)
			return 0;

		if (A.length == 0)
			return 1;

		int cur = 0;
		while (cur < A.length)
		{
			if (A[cur] <= 0)
			{
				cur++;
				continue;
			}

			int index = A[cur] - 1;
			if (index > A.length - 1 || index == cur || A[index] == index + 1)
			{
				cur++;
				continue;
			}

			// swap to index
			int temp = A[index];
			A[index] = A[cur];
			A[cur] = temp;
		}

		for (int i = 0; i < A.length; i++)
		{
			if (A[i] != i + 1)
				return i + 1;
		}

		return A.length + 1;
	}
}