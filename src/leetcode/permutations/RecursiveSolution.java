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

public class RecursiveSolution
{
	public List<List<Integer>> permute(int[] num)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return ret;

		List<Integer> existing =  new ArrayList<Integer>();
		List<Integer> remaining =  new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++)
			remaining.add(num[i]);
		
		permuteHelper(ret, existing, remaining);
		return ret;
	}

	private void permuteHelper(List<List<Integer>> ret, List<Integer> existing,
			List<Integer> remaining)
	{
		if (remaining.isEmpty())
		{
			List<Integer> oneResult = new ArrayList<Integer>();
			oneResult.addAll(existing);
			ret.add(oneResult);
			return;
		}

		for (int i = 0; i < remaining.size(); i++)
		{	
			existing.add(remaining.get(i));
			
			List<Integer> newRemain = new ArrayList<Integer>();
			
			newRemain.addAll(remaining);
			newRemain.remove(remaining.get(i));
			permuteHelper(ret, existing, newRemain);
			
			existing.remove(remaining.get(i));
		}
	}
}