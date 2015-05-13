package leetcode.combinations;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * <pre>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </pre>
 * 
 */

public class Solution
{
	public ArrayList<ArrayList<Integer>> combine(int n, int k)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		for (; k > 0; k--)
		{
			if (ret.size() == 0)
			{
				for (int i = 1; i <= n - k + 1; i++)
				{
					ArrayList<Integer> one = new ArrayList<Integer>();
					one.add(i);
					ret.add(one);
				}
				continue;
			}

			int count = ret.size();
			for (int i = 0; i < count; i++)
			{
				ArrayList<Integer> one = ret.get(i);
				int last = one.get(one.size() - 1) + 1;

				for (; last < n - k + 1; last++)
				{
					ArrayList<Integer> newOne = new ArrayList<Integer>(one);
					newOne.add(last);
					ret.add(newOne);
				}
				one.add(last);
			}
		}

		return ret;
	}
}