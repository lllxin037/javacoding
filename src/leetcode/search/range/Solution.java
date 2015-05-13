package leetcode.search.range;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * <pre>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * </pre>
 * 
 */

public class Solution
{
	public int[] searchRange(int[] A, int target)
	{
		int[] range = new int[2];
		range[0] = -1;
		range[1] = -1;

		if (A == null || A.length == 0)
			return range;

		int low = 0;
		int high = A.length - 1;

		while (low <= high)
		{
			int mid = (low + high) / 2;
			if (A[mid] == target)
			{
				if (mid == 0 || A[mid - 1] < target)
				{
					// find the beginning
					range[0] = mid;
					// reset
					low = mid;
					high = A.length - 1;
				}
				if (mid == A.length - 1 || A[mid + 1] > target)
				{
					// find the end
					range[1] = mid;
					// reset
					low = 0;
					high = mid;
				}
				// find the range
				if (range[0] > -1 && range[1] > -1)
					return range;

				if (range[0] < 0)
					high = mid - 1; // continue searching for beginning in (..,
									// mid)
				else
					low = mid + 1; // continue searching for end in (mid, ..)
			}
			else if (A[mid] < target)
			{
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}
		}

		return range;
	}
}