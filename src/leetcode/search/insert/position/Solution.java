package leetcode.search.insert.position;

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

public class Solution
{
	public int searchInsert(int[] A, int target)
	{
		if (A == null || A.length == 0)
			return 0;

		int low = 0;
		int high = A.length - 1;

		while (low <= high)
		{
			int mid = (low + high) / 2;
			if (target == A[mid])
				return mid;

			if (target < A[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}

		return low;
	}
}