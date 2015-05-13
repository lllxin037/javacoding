package epi.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectSortedArray1
{

	// A.length alomst same as B.length
	public static int[] getIntersection(int[] A, int[] B)
	{
		int n = A.length;
		int m = B.length;

		if (n == 0 || m == 0)
			return new int[0];

		List<Integer> C = new ArrayList<Integer>();

		// two points to trace the array traveral
		int curA = 0;
		int curB = 0;

		while (curA < n && curB < m)
		{
			if (A[curA] == B[curB])
			{
				C.add(A[curA]);
				// increase curA and curB to skip this value
				while (++curA < n && A[curA] == C.get(C.size() - 1))
					;
				while (++curB < m && B[curB] == C.get(C.size() - 1))
					;
			}
			else if (A[curA] < B[curB])
				curA++;
			else
				curB++;
		}

		int[] ret = new int[C.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = C.get(i);
		return ret;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(getIntersection(new int[]
		{ 2, 4, 6, 8, 10, 11, 23, 30, 32, 40 }, new int[]
		{ 9, 11, 15, 17, 20, 30, 32, 50 })));
	}
}
