package epi.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectSortedArray
{
	// A.length << as B.length
	// if n << m then nlog(m) << mlog(n);
	public static int[] getIntersection(int[] A, int[] B)
	{
		int n = A.length;
		int m = B.length;

		// choose the shorter array as the outside looper.
		if (n > m)
			return getIntersection(B, A);

		List<Integer> C = new ArrayList<Integer>(n);
		for (int i = 0; i < A.length; i++)
		{
			int valA = A[i];
			if ((i == 0 || A[i] != A[i - 1]) && binarySearch(B, valA))
				C.add(valA);
		}

		int[] ret = new int[C.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = C.get(i);
		return ret;
	}

	private static boolean binarySearch(int[] B, int value)
	{
		int low = 0;
		int high = B.length;

		while (low <= high)
		{
			int mid = low + ((high - low) >> 1);
			if (B[mid] == value)
				return true;
			else if (B[mid] < value)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(getIntersection(new int[]
		{ 10, 11, 23 }, new int[]
		{ 9, 11, 15, 17, 20, 23, 32, 50 })));
	}
}
