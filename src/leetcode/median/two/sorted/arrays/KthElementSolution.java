package leetcode.median.two.sorted.arrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 */
public class KthElementSolution
{
	public double findMedianSortedArrays(int A[], int B[])
	{
		if (A == null && B == null)
			return 0;
		if (A.length == 0 && B.length == 0)
			return 0;

		int m = A.length;
		int n = B.length;

		if (((m + n) & 1) == 0)
			return (findKthElement(A, 0, m - 1, B, 0, n - 1, (m + n) / 2) + findKthElement(
					A, 0, m - 1, B, 0, n - 1, (m + n) / 2 + 1)) * 0.5;

		return findKthElement(A, 0, m - 1, B, 0, n - 1, (m + n) / 2 + 1);
	}

	private int findKthElement(int A[], int aLow, int aHigh, int B[], int bLow,
			int bHigh, int k)
	{
		if (bHigh - bLow > aHigh - aLow)
			return findKthElement(B, bLow, bHigh, A, aLow, aHigh, k);
		if (k == 0)
			return A[0];

		if (bHigh - bLow < 0)
			return A[k - 1];

		// k is from 1 instead of 0.
		if (k == 1)
			return Math.min(A[aLow], B[bLow]);

		int bOffset = Math.min(bHigh - bLow + 1, k >> 1);
		int aOffset = k - bOffset + aLow;

		bOffset += bLow;

		if (A[aOffset - 1] < B[bOffset - 1])
			return findKthElement(A, aOffset, aHigh, B, bLow, bOffset, k
					- aOffset + aLow);
		else if (A[aOffset - 1] > B[bOffset - 1])
			return findKthElement(A, aLow, aOffset, B, bOffset, bHigh, k
					- bOffset + bLow);

		return A[aOffset - 1];
	}
}
