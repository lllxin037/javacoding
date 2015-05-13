package leetcode.jump.game;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * <pre>
 * For example:
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * </pre>
 * 
 */

public class Solution
{
	public boolean canJump(int[] A)
	{
		if (A == null || A.length <= 1)
			return true;

		int right = 0;

		for (int i = 0; i < A.length - 1; i++)
		{
			if (right < i)
				return false;
			
			right = Math.max(A[i] + i, right);
			if (right >= A.length - 1)
				return true;
		}

		return false;

	}
}
