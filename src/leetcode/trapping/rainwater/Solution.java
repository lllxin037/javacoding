package leetcode.trapping.rainwater;


/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 */

public class Solution
{
	public int trap(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;

		int value = 0;
		int left = 0;

		while (left < A.length && A[left] == 0)
			left++;

		int tmpVol = 0;
		for (int i = left; i < A.length; i++)
		{
			if (A[i] < A[left])
				tmpVol += A[left] - A[i];
			else
			{
				value += tmpVol;

				left = i;
				tmpVol = 0;
			}
		}

		int right = A.length - 1;
		while (right > 0 && A[right] == 0)
			right--;

		tmpVol = 0;
		for (int i = right; i >= left; i--)
		{
			if (A[i] < A[right])
				tmpVol += A[right] - A[i];
			else
			{
				value += tmpVol;

				right = i;
				tmpVol = 0;
			}
		}

		return value;
	}
}