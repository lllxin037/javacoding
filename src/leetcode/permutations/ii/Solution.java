package leetcode.permutations.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * <pre>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * </pre>
 * 
 */

public class Solution
{
	public List<List<Integer>> permuteUnique(int[] num)
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
		
		int n = num.length;
		int[] sortedNum = new int[n];
		System.arraycopy(num, 0, sortedNum, 0, n);
		Arrays.sort(sortedNum);

		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < n; i++)
		{
			if (visited.contains(num[i]))
				continue;

			int[] subset = new int[n - 1];
			for (int j = 0; j < i; j++)
				subset[j] = num[j];

			for (int j = i + 1; j < n; j++)
				subset[j - 1] = num[j];

			// append the current number to the end of pernutations of n-1
			// subset
			for (List<Integer> perm : permuteUnique(subset))
			{
				perm.add(num[i]); // append to the end, O(1)
				ret.add(perm);
			}

			visited.add((num[i]));
		}
		
		return ret;
	}
}