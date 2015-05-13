package leetcode.three.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class HashMapSolution
{
	public List<List<Integer>> threeSum(int[] num)
	{
		List<List<Integer>> sum = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return sum;

		Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++)
		{
			Integer count = mapping.get(num[i]);
			if (count == null)
				mapping.put(num[i], 1);
			else
				mapping.put(num[i], count + 1);
		}

		Iterator<Integer> iter1 = mapping.keySet().iterator();
		while (iter1.hasNext())
		{
			int one = iter1.next();

			Integer oneCount = mapping.get(one);
			mapping.put(one, oneCount - 1);

			Set<Integer> newSet = new HashSet<Integer>();
			newSet.addAll(mapping.keySet());

			Iterator<Integer> iter2 = newSet.iterator();
			while (iter2.hasNext())
			{
				int another = iter2.next();
				Integer anotherCount = mapping.get(another);
				if (!newSet.contains(another) || anotherCount == null
						|| anotherCount == 0)
				{
					newSet.remove(another);
					iter2 = newSet.iterator();
					continue;
				}

				int remaining = -one - another;
				Integer count = mapping.get(remaining);
				if (!newSet.contains(remaining) || count == null || count == 0
						|| (remaining == another && anotherCount == 1))
				{
					newSet.remove(another);
					iter2 = newSet.iterator();
					continue;
				}

				sum.add(order(one, another, remaining));
				newSet.remove(another);
				iter2 = newSet.iterator();
			}

			mapping.remove(Integer.valueOf(one));
			iter1 = mapping.keySet().iterator();
		}

		return sum;
	}

	private List<Integer> order(int one, int another, int remaining)
	{
		List<Integer> ret = new ArrayList<Integer>();
		if (one <= another && one <= remaining)
		{
			ret.add(one);
			if (another <= remaining)
			{
				ret.add(another);
				ret.add(remaining);
			}
			else
			{
				ret.add(remaining);
				ret.add(another);
			}
		}
		else if (another <= one && another <= remaining)
		{
			ret.add(another);

			if (one <= remaining)
			{

				ret.add(one);
				ret.add(remaining);
			}
			else
			{
				ret.add(remaining);
				ret.add(one);
			}
		}
		else
		{
			ret.add(remaining);

			if (one <= another)
			{
				ret.add(one);
				ret.add(another);
			}
			else
			{
				ret.add(another);
				ret.add(one);
			}
		}

		return ret;
	}

}