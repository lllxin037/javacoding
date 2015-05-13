package leetcode.maximum.subarray;

/**
 * Divide and conquer solution.
 * 
 */

public class DCSolution
{
	public int maxSubArray(int[] A)
	{
		return maxSubHelper(A, 0, A.length - 1);
	}

	private int maxSubHelper(int[] A, int start, int end)
	{
		if (start == end)
			return A[start];

		int mid = start + ((end - start) >> 1);

		int leftMax = maxSubHelper(A, start, mid);
		int rightMax = maxSubHelper(A, mid + 1, end);

		int leftSpan = A[mid];
		int rightSpan = A[mid + 1];
		int temp = 0;

		for (int i = mid; i >= start; i--)
		{
			temp += A[i];
			if (temp > leftSpan)
				leftSpan = temp;
		}

		temp = 0;
		for (int i = mid + 1; i <= end; i++)
		{
			temp += A[i];
			if (temp > rightSpan)
				rightSpan = temp;
		}

		return Math.max(Math.max(leftMax, rightMax), leftSpan + rightSpan);
	}
}
