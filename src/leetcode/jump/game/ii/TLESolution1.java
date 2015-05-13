package leetcode.jump.game.ii;

public class TLESolution1
{
	public int jump(int[] A)
	{
		if (A == null || A.length <= 1)
			return 0;

		int[] minsteps = new int[A.length];
		minsteps[0] = 0;
		for (int i = 1; i < minsteps.length; i++)
			minsteps[i] = Integer.MAX_VALUE;

		int right = A[0];
		for (int i = 1; i < A.length; i++)
		{
			if (right < i)
				break;

			right = Math.max(A[i] + i, right);

			int prestep = A[i - 1];
			for (int j = i; j < i + prestep && j < A.length; j++)
				minsteps[j] = Math.min(minsteps[i - 1] + 1, minsteps[j]);
		}

		return minsteps[A.length - 1];
	}
}
