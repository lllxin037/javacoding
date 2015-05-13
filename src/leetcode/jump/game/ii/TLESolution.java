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

public class TLESolution
{
	public int jump(int[] A)
	{
		if (A == null || A.length <= 1)
			return 0;

		int[] minsteps = new int[A.length];
		minsteps[A.length - 1] = 0;
		minsteps[0] = -1;
		for (int i = A.length - 2; i >= 0; i--)
		{
			if (A[i] >= A.length - 1 - i)
			{
				minsteps[i] = 1;
			}
			else
			{
				int min = A.length;

				for (int j = i + 1; j <= i + A[i]; j++)
					min = Math.min(min, minsteps[j]);

				minsteps[i] = min + 1;
			}
		}

		return minsteps[0];
	}
}