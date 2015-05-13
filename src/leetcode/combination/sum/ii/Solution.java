package leetcode.combination.sum.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * <pre>
 * Note:
 * 
 *     All numbers (including target) will be positive integers.
 *     Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 *     The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 * </pre>
 * 
 */

public class Solution
{
	public List<List<Integer>> combinationSum2(int[] num, int target)
	{
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return combinations;

		Arrays.sort(num);

		List<Integer> oneResult = new ArrayList<Integer>();
		sum2Helper(combinations, oneResult, num, 0, target);
		return combinations;
	}

	private void sum2Helper(List<List<Integer>> combinations,
			List<Integer> oneResult, int[] num, int index, int target)
	{
		if (target == 0)
		{
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.addAll(oneResult);
			combinations.add(tmp);
			return;
		}

		if (index >= num.length || target < num[index])
			return;

		int i = index;
		while (i < num.length)
		{
			int count = 0;
			while (i < num.length - 1 && num[i] == num[i + 1])
			{
				i++;
				count++;
			}

			for (int j = 0; j <= count; j++)
			{
				for (int k = 0; k <= j; k++)
					oneResult.add(num[i]);

				sum2Helper(combinations, oneResult, num, i + 1, target
						- (num[i] * (j + 1)));

				for (int k = 0; k <= j; k++)
					oneResult.remove(oneResult.size() - 1);
			}

			i++;
		}
	}
}