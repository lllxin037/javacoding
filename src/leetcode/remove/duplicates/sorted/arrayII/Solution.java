package leetcode.remove.duplicates.sorted.arrayII;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 */

public class Solution
{
	public int removeDuplicates(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;

		int count = 0;

		for (int i = 2; i < A.length; i++)
		{
			if (A[i - count - 1] == A[i] && A[i - count - 2] == A[i])
				count++;
			else
			{
				A[i - count] = A[i];
			}
		}

		return A.length - count;
	}
}