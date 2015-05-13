package epi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNondecreasingSubsequence
{
	public static void find(int[] A)
	{
		if (A == null || A.length == 0)
			return;

		int n = A.length;

		int[] curMaxLen = new int[n];
		int[] last = new int[n];

		curMaxLen[0] = 1;

		for (int i = 1; i < n; i++)
		{
			int val = A[i];
			for (int j = i - 1; j >= 0; j--)
			{
				if (val >= A[j])
				{
					if (curMaxLen[j] + 1 > curMaxLen[i])
						last[i] = j;

					curMaxLen[i] = Math.max(curMaxLen[j] + 1, curMaxLen[i]);
				}
			}
		}

		System.out.println("longest nondescreasing subsequence length: "
				+ curMaxLen[n - 1]);

		// back trace the sub sequence;
		int index = n - 1;
		for (int i = n - 2; i >= 0; i--)
		{
			if (curMaxLen[i] > curMaxLen[index])
				index = i;
		}

		List<Integer> indices = new ArrayList<Integer>();
		indices.add(index);
		while (index > 0)
		{
			index = last[index];
			indices.add(index);
		}
		Collections.reverse(indices);
		System.out.println(indices);
	}

	/**
	 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence
	 * -size-n-log-n/
	 * 
	 * <pre>
	 * A[0] = 0. Case 1. There are no active lists, create one.
	 * 0.
	 * -----------------------------------------------------------------------------
	 * A[1] = 8. Case 2. Clone and extend.
	 * 0.
	 * 0, 8.
	 * -----------------------------------------------------------------------------
	 * A[2] = 4. Case 3. Clone, extend and discard.
	 * 0.
	 * 0, 4.
	 * 0, 8. Discarded
	 * -----------------------------------------------------------------------------
	 * A[3] = 12. Case 2. Clone and extend.
	 * 0.
	 * 0, 4.
	 * 0, 4, 12.
	 * -----------------------------------------------------------------------------
	 * A[4] = 2. Case 3. Clone, extend and discard.
	 * 0.
	 * 0, 2.
	 * 0, 4. Discarded.
	 * 0, 4, 12.
	 * </pre>
	 * 
	 * @param A
	 */

	public static void greedyFind(int[] A)
	{
		int n = A.length;

		// tail[i][j] be the smallest possible tail within A[j] to A[i] where
		// j<=i

		// for any i, M[i][1] <= M[i][2] <= ... <= M[i][j]
		int[] tailIndices = new int[n];
		int[] prevIndices = new int[n];
		tailIndices[0] = 0;
		prevIndices[0] = -1;

		int len = 1;

		for (int i = 1; i < n; i++)
		{
			if (A[i] >= A[tailIndices[len - 1]])
			{
				// A[i] wants to extend largest subsequence
				prevIndices[i] = tailIndices[len - 1];
				tailIndices[len++] = i;
			}
			else if (A[i] < A[tailIndices[0]])
				tailIndices[0] = i;
			else
			{
				int toUpdateIndex = binarySearch(tailIndices, len, A[i], A);

				prevIndices[i] = tailIndices[toUpdateIndex - 1];
				tailIndices[toUpdateIndex] = i;
			}
		}

		System.out.println("longest nondescreasing subsequence length: " + len);

		int[] subsequence = new int[len];
		for (int i = tailIndices[len - 1], j = len - 1; i >= 0; i = prevIndices[i], j--)
			subsequence[j] = A[i];

		System.out.println(Arrays.toString(subsequence));
	}

	private static int binarySearch(int[] tail, int len, int k, int[] A)
	{
		// find the tail[index] which is the least one that is larger than k
		int low = 0;
		int high = len - 1;

		while (low < high)
		{
			int mid = low + ((high - low) >> 1);
			if (A[tail[mid]] == k)
				return mid;
			else if (A[tail[mid]] < k)
				low = mid + 1;
			else
				high = mid;
		}
		return high;
	}

	public static void main(String[] args)
	{
		greedyFind(new int[]
		{ 0, 5, 8, 4, 12, 7 });

		greedyFind(new int[]
		{ 0, 8, 4, 12, 2, 10, 6, 14, 1, 9 });

		// 0, 2, 6, 9, 11, 15. <-- LIS List
		greedyFind(new int[]
		{ 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 });

	}
}
