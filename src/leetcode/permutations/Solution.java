package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * <pre>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * </pre>
 * 
 */

public class Solution
{
	public List<List<Integer>> permute(int[] num)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return ret;

		if (num.length == 1)
		{
			List<Integer> one = new ArrayList<Integer>();
			one.add(num[0]);
			ret.add(one);

			return ret;
		}

		for (int i = 0; i < num.length; i++)
		{
			// copy a new array of n-1 numbers
			int[] subset = new int[num.length - 1];
			for (int j = 0; j < i; ++j)
				subset[j] = num[j];

			for (int j = i + 1; j < num.length; ++j)
				subset[j - 1] = num[j];

			// append the current number to the end of permutations of n-1
			// subset
			for (List<Integer> perm : permute(subset))
			{
				perm.add(num[i]); // append to the end, O(1)
				ret.add(perm);
			}
		}
		
		return ret;
	}
}