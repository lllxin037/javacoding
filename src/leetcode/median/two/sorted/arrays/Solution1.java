package leetcode.median.two.sorted.arrays;

public class Solution1 {

	public double findMedianSortedArrays(int A[], int B[]) {

		if (A == null && B == null)
			return 0.0;

		if (A.length == 0 && B.length == 0)
			return 0.0;

		int m = A.length;
		int n = B.length;

		if (((m + n) & 1) == 1)
			return medianHelper(A, m, B, n, (m + n) / 2 + 1, 0, m - 1);

		return medianHelper(A, m, B, n, (m + n) / 2, 0, m - 1) * 0.5
				+ medianHelper(A, m, B, n, (m + n) / 2 + 1, 0, m - 1) * 0.5;
	}

	private double medianHelper(int[] A, int m, int[] B, int n, int k,
			int left, int right) {

		if (left > right)
			return medianHelper(B, n, A, m, k, 0, n - 1);

		// i + j = k - 2. the index of k-1 will be in one of i or j.
		int i = (right + left) / 2;
		int j = k - 1 - i - 1;

		if ((j < 0 || (j < n && A[i] >= B[j]))
				&& (j >= n - 1 || (j + 1 >= 0 && A[i] <= B[j + 1])))
			return A[i];
		else if (j + 1 < 0 || (j + 1 < n && A[i] > B[j + 1]))
			return medianHelper(A, m, B, n, k, left, i - 1);
		else
			return medianHelper(A, m, B, n, k, i + 1, right);

	}
}
