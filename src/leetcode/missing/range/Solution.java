package leetcode.missing.range;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99]
 * inclusive, return its missing ranges. For example, given [0, 1, 3, 50, 75],
 * return ["2", "4->49", "51->74", "76->99"]
 * 
 */

public class Solution
{
	public List<String> findMissingRanges(int[] vals, int start, int end)
	{
		List<String> ret = new ArrayList<String>();
		if (vals == null || vals.length == 0)
		{
			ret.add(start + "->" + end);
			return ret;
		}

		int last = start;

		for (int i = 0; i <= vals.length; i++)
		{
			int ceil = ((i == vals.length) ? (end + 1) : vals[i]);

			int shift = ceil - 1 - last;
			if (shift == 1)
				ret.add(String.valueOf(ceil - 1));
			else if (shift > 1)
				ret.add(String.valueOf(last + 1) + "->"
						+ String.valueOf(ceil - 1));
			last = ceil;
		}

		return ret;
	}
}
