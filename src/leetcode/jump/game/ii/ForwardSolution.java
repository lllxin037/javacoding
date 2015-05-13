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

public class ForwardSolution
{
	public int jump(int[] A)
	{
		if (A == null || A.length <= 1)
			return 0;

		/*
		 * We use "last" to keep track of the maximum distance that has been
		 * reached by using the minimum steps "steps", whereas "curr" is the
		 * maximum distance that can be reached by using "steps+1" steps. Thus,
		 * curr = max(i+A[i]) where 0 <= i <= last.
		 */

		int steps = 0;
		int last = 0;
		int curr = 0;

		for (int i = 0; i < A.length; i++)
		{
			if (i > last)
			{
				if (curr == last && last < A.length - 1)
					return -1;

				last = curr;
				++steps;
			}
			curr = Math.max(curr, A[i] + i);
		}
		return steps;
	}
}