package o1.data.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Data structure: insert, remove, contains, get random element, all at O(1).
 * 
 * a hashmap with a List. The map key is the value of the element and the value
 * is the index of array.
 * 
 */

public class Solution
{
	private Map<Object, Map<Integer, Integer>> table = new HashMap<Object, Map<Integer, Integer>>();
	private List<Object> array = new ArrayList<Object>();
	private Random r;

	public Solution()
	{
		r = new Random();
	}

	public void insert(Object value)
	{
		int nextIndex = array.size();

		array.add(value);

		Map<Integer, Integer> tmp = table.get(value);
		if (tmp == null)
		{
			tmp = new HashMap<Integer, Integer>();
			table.put(value, tmp);
		}

		tmp.put(nextIndex, null);
	}

	public void remove(Object value)
	{
		Map<Integer, Integer> tmp = table.get(value);
		if (tmp == null)
			return;

		// to remove from the end to avoid any issue.
		// still need to remove from array.
		// if (tmp.size() > 1)
		// {
		// tmp.remove(tmp.keySet().iterator().next());
		// return;
		// }

		// only contains one index
		int i = tmp.keySet().iterator().next();
		int lastOne = array.size() - 1;
		if (i != lastOne)
		{
			array.set(i, array.get(lastOne));
			table.get(array.get(lastOne)).remove(lastOne);
			table.get(array.get(lastOne)).put(i, null);
		}

		if (tmp.size() > 1)
			tmp.remove(i);
		else
			table.remove(value);

		array.remove(lastOne);
	}

	public boolean contains(Object value)
	{
		return table.containsKey(value);
	}

	public Object getRandom()
	{
		if (array.size() == 0)
			return null;
		if (array.size() == 1)
			return array.get(0);

		int ri = r.nextInt(array.size() - 1);
		// System.out.println("random index: " + ri + " in size "
		// + (array.size() - 1));
		return array.get(ri);
	}
}
