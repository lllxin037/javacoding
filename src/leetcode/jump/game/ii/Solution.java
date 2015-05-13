package leetcode.jump.game.ii;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * <pre>
 * For example:
 * Given array A = [2,3,1,1,4]
 * </pre>
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 */

public class Solution
{
	public int jump(int[] A)
	{
		if (A == null || A.length <= 1)
			return 0;

		int steps = 0;
		int right = A.length - 1;

		while (right != 0)
		{
			boolean notChanged = true;
			for (int i = 0; i < right; i++)
				if (i + A[i] >= right)
				{
					steps++;
					right = i;
					notChanged = false;
					break;
				}

			if (notChanged)
				return -1;
		}
		return steps;
	}
}