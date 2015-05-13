package leetcode.two.sum.iii;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations:add and find.
 * 
 * add - Add the number to an internal data structure. find - Find if there
 * exists any pair of numbers which sum is equal to the value.
 * 
 * <pre>
 * For example,
 * 
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * </pre>
 * 
 */

public class TwoSum
{
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void add(int number)
	{
		if (map.containsKey(number))
			map.put(number, map.get(number) + 1);
		else
			map.put(number, 1);

	}

	public boolean find(int target)
	{
		Iterator<Integer> iter1 = map.keySet().iterator();
		while (iter1.hasNext())
		{
			int val = (Integer) iter1.next();
			if (!map.containsKey(target - val))
				continue;

			if (val == target - val)
				return (map.get(target - val) > 1);

			return (map.get(target - val) > 0);
		}

		return false;
	}
}
