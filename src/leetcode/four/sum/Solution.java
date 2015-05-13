package leetcode.four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a <= b <= c <= d) The solution set must not contain duplicate
 * quadruplets.
 * 
 * <pre>
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * </pre>
 * 
 */

public class Solution
{
	public List<List<Integer>> fourSum(int[] num, int target)
	{
		List<List<Integer>> sums = new ArrayList<List<Integer>>();
		if (num == null || num.length < 4)
			return sums;

		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++)
		{
			if (i > 0 && num[i] == num[i - 1])
				continue;

			int remaining1 = target - num[i];
			for (int j = i + 1; j < num.length - 2; j++)
			{
				if (j > i + 1 && num[j] == num[j - 1])
					continue;

				int remaining2 = remaining1 - num[j];
				int low = j + 1;
				int high = num.length - 1;

				while (low < high)
				{
					if (num[low] + num[high] == remaining2)
					{
						List<Integer> oneresult = new ArrayList<Integer>();
						oneresult.add(num[i]);
						oneresult.add(num[j]);
						oneresult.add(num[low]);
						oneresult.add(num[high]);
						sums.add(oneresult);
						
						int previous = num[low];
						do
							low++;
						while (low < num.length - 1 && previous == num[low]);

						previous = num[high];
						do
							high--;
						while (high >= 0 && previous == num[high]);
					}
					else if (num[low] + num[high] < remaining2)
						low++;
					else
						high--;
				}
			}
		}

		return sums;
	}
}