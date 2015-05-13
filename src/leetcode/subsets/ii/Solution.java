package leetcode.subsets.ii;

import java.util.ArrayList;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * <pre>
 * Note:
 * 
 *     Elements in a subset must be in non-descending order.
 *     The solution set must not contain duplicate subsets.
 * 
 * 
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * </pre>
 * 
 */

public class Solution
{
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (S == null)
			return ret;

		// order the input array in n*n
		bubbleSort(S);

		int len = S.length;
		ret.add(new ArrayList<Integer>());

		int count = 0;

		for (int i = 0; i < len; i++)
		{
			if (i > 0 && S[i] == S[i - 1])
			{
				count++;
			}
			else
				count = 0;

			int cursize = ret.size();
			while (cursize > 0)
			{
				ArrayList<Integer> one = ret.get(cursize - 1);
				if (count > 0
						&& (one.size() < count || one.get(one.size() - count) != S[i]))
				{
					cursize--;
					continue;
				}

				ArrayList<Integer> newOne = new ArrayList<Integer>();
				newOne.addAll(one);
				newOne.add(S[i]);

				ret.add(newOne);
				cursize--;
			}
		}

		return ret;
	}

	public void bubbleSort(int[] a)
	{

		int temp = 0;
		for (int i = 0; i < a.length - 1; i++)
		{
			for (int j = 0; j < a.length - 1 - i; j++)
			{
				if (a[j] > a[j + 1])
				{
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
