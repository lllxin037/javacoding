package leetcode.search.rotated.sorted.arrayII;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 */
public class Solution
{
	public boolean search(int[] A, int target)
	{
		if (A == null || A.length == 0)
			return false;

		int low = 0;
		int high = A.length - 1;

		while (low <= high && A[low] == A[high])
		{
			if (A[low] == target)
				return true;
			low++;
			high--;
		}

		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (A[mid] == target)
				return true;

			// no rotate;
			if ((A[high] > A[low] && target < A[mid])
			// rotate in low...mid
					|| (A[mid] > A[low] && target > A[high] && target < A[mid])
					// rotate in mid..high
					|| (A[mid] < A[low] && (target > A[high] || target < A[mid])))
			{
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return false;
	}
}