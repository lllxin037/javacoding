package leetcode.median.two.sorted.arrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 */
public class Solution
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
			return (findKthElement(A, m, B, n, (m + n) / 2, 0, m - 1) + findKthElement(
					A, m, B, n, (m + n) / 2 + 1, 0, m - 1)) * 0.5;

		return findKthElement(A, m, B, n, (m + n) / 2 + 1, 0, m - 1);
	}

	private int findKthElement(int A[], int m, int B[], int n, int k, int left,
			int right)
	{
		// if not found in A, search in B.
		if (left > right)
			return findKthElement(B, n, A, m, k, 0, n - 1);

		int i = (left + right) >> 1;
		int j = k - 1 - i - 1;

		if ((j < 0 || (j < n && A[i] >= B[j]))
				&& (j >= n - 1 || (j + 1 >= 0 && A[i] <= B[j + 1])))
			return A[i];
		else if (j < 0 || (j + 1 < n && A[i] > B[j + 1]))
			return findKthElement(A, m, B, n, k, left, i - 1);
		else
			return findKthElement(A, m, B, n, k, i + 1, right);

	}
}
