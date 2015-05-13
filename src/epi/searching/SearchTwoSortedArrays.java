package epi.searching;

public class SearchTwoSortedArrays
{
	public static int findKSamllest(int[] A, int[] B, int k)
	{
		int n = A.length;
		int m = B.length;

		if (k <= 0 || k > n + m)
			return -1;

		return findKSamllest(A, 0, B, 0, k);
	}

	public static int findKSamllestIterative(int[] A, int[] B, int k)
	{
		int n = A.length;
		int m = B.length;

		if (k <= 0 || k > n + m)
			return -1;

		int lowA = Math.max(0, k - B.length);
		int highA = Math.min(k, A.length);

		while (lowA < highA)
		{
			int offsetA = lowA + ((highA - lowA) >> 1);
			int offsetB = k - offsetA - 1;

			if (A[offsetA] < B[offsetB])
				lowA = offsetA + 1;
			else if (A[offsetA] > B[offsetB])
				highA = offsetA - 1;
			else
				return Math.min(A[offsetA], B[offsetB]);
		}

		// use up values in A.
		if (lowA >= A.length)
			return B[k - A.length - 1];

		// lowA still first element.
		if (lowA == 0)
			return Math.min(A[0], B[k - 1]);

		if (k - lowA >= B.length)
			return Math.min(A[k - B.length], B[B.length - 1]);

		return Math.min(A[lowA - 1], B[k - lowA]);
	}

	private static int findKSamllest(int[] A, int startA, int[] B, int startB,
			int k)
	{
		// swap to make sure the longer array is A.
		if (B.length - startB > A.length - startA)
			return findKSamllest(B, startB, A, startA, k);

		if (startB >= B.length)
			return A[k - 1];

		// k is from 1, instead of 0. 1 means the 1st element
		if (k == 1)
			return Math.min(A[startA], B[startB]);

		int offsetB = Math.min(startB + (k >> 1) - 1, B.length - 1);
		int offsetA = startA + (k >> 1) - 1;

		if (A[offsetA] < B[offsetB])
			return findKSamllest(A, offsetA + 1, B, startB, k
					- (offsetA - startA + 1));

		return findKSamllest(A, startA, B, offsetB + 1, k
				- (offsetB - startB + 1));
	}

	public static void main(String[] args)
	{
		/**/
		System.out.println(findKSamllestIterative(new int[]
		{ 2, 3, 7, 12, 27 }, new int[]
		{ 1, 27, 32, 74, 89 }, 7));

		System.out.println(findKSamllestIterative(new int[]
		{ 25 }, new int[]
		{ 2, 3, 7, 12, 27 }, 4));

		System.out.println(findKSamllestIterative(new int[]
		{ 2, 3, 7, 12, 27 }, new int[]
		{ 25 }, 5));

		System.out.println(findKSamllestIterative(new int[]
		{}, new int[]
		{ 25 }, 1));

		System.out.println(findKSamllestIterative(new int[]
		{}, new int[]
		{ 1, 2, 3, 4, 5 }, 2));

		System.out.println(findKSamllestIterative(new int[]
		{}, new int[]
		{ 1, 2, 3, 4, 5, 6 }, 5));

		System.out.println(findKSamllestIterative(new int[]
		{ 1, 2 }, new int[]
		{ 1, 2 }, 2));

		System.out.println(findKSamllest(new int[]
		{ 1, 2 }, new int[]
		{ 1, 2 }, 4));

		System.out.println(findKSamllest(new int[]
		{ 1, 2 }, new int[]
		{ 1, 2 }, 3));
	}
}
