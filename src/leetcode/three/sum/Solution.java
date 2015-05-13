package leetcode.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <=
 * c) The solution set must not contain duplicate triplets.
 * 
 * <pre>
 *     For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 * </pre>
 * 
 */
public class Solution
{
	public List<List<Integer>> threeSum(int[] num)
	{
		List<List<Integer>> sum = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3)
			return sum;

		Arrays.sort(num);

		for (int i = 0; i < num.length; i++)
		{
			int target = -num[i];

			if (i > 0 && num[i] == num[i - 1])
				continue;

			int low = i + 1;
			int high = num.length - 1;
			while (low < high)
			{
				if (num[low] + num[high] == target)
				{
					List<Integer> oneresult = new ArrayList<Integer>();
					oneresult.add(num[i]);
					oneresult.add(num[low]);
					oneresult.add(num[high]);
					sum.add(oneresult);

					// move high and low to a different value;
					int previous = num[high];
					while (high >= 0 && num[high] == previous)
						high--;
					previous = num[low];
					while (low < num.length && num[low] == previous)
						low++;
				}
				else if (num[low] + num[high] < target)
					low++;
				else
					high--;
			}
		}

		return sum;
	}

}