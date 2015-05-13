package leetcode.three.sum.closest;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
public class Solution
{
	public int threeSumClosest(int[] num, int target)
	{
		if (num == null || num.length < 3)
			return Integer.MIN_VALUE;

		Arrays.sort(num);

		long sum = num[0] + num[1] + num[2];

		for (int i = 0; i < num.length; i++)
		{
			if (i > 0 && num[i] == num[i - 1])
				continue;

			int remaining = target - num[i];

			int low = i + 1;
			int high = num.length - 1;
			while (low < high)
			{
				if (num[low] + num[high] == remaining)
					return target;

				if (Math.abs(sum - target) > Math.abs(remaining - num[low]
						- num[high]))
					sum = num[low] + num[high] + num[i];

				if (num[low] + num[high] > remaining)
					high--;
				else
					low++;
			}
		}

		return (int) sum;
	}
}