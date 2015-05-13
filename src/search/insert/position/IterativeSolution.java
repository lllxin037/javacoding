package search.insert.position;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * <pre>
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * </pre>
 * 
 */

public class IterativeSolution
{
	public int searchInsert(int[] A, int target)
	{
		if (A == null || A.length == 0)
			return 0;

		for (int i = 0; i < A.length; i++)
		{
			if (target > A[i])
				continue;

			if (target == A[i])
				return i;

			if (i == 0 || target > A[i - 1])
				return i;
		}

		return A.length;
	}
}