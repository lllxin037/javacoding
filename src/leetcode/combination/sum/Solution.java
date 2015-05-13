package leetcode.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * <pre>
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 *     All numbers (including target) will be positive integers.
 *     Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 *     The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 * </pre>
 * 
 */

public class Solution
{
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return combinations;

		// sort candidates.
		Arrays.sort(candidates);
		// remove duplicates
		List<Integer> newCandidates = new ArrayList<Integer>();
		for (int i = 0; i < candidates.length; i++)
		{
			if (newCandidates.isEmpty()
					|| candidates[i] != newCandidates
							.get(newCandidates.size() - 1))
				newCandidates.add(candidates[i]);
		}

		List<Integer> oneResult = new ArrayList<Integer>();
		sumHelper(combinations, oneResult, target, newCandidates, 0);

		return combinations;
	}

	private void sumHelper(List<List<Integer>> combinations,
			List<Integer> oneResult, int target, List<Integer> candidates,
			int index)
	{
		// find the target
		if (target == 0)
		{
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.addAll(oneResult);
			combinations.add(tmp);
			return;
		}

		// fail to find one
		if (candidates.isEmpty() || target < candidates.get(index))
			return;

		for (int i = index; i < candidates.size(); i++)
		{
			oneResult.add(candidates.get(i));
			sumHelper(combinations, oneResult, target - candidates.get(i),
					candidates, i);
			oneResult.remove(oneResult.size() - 1);
		}

	}

}