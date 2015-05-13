package leetcode.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.interval.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * <pre>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * </pre>
 * 
 */

public class Solution
{
	public List<Interval> merge(List<Interval> intervals)
	{
		if (intervals == null || intervals.isEmpty())
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>()
		{
			public int compare(Interval o1, Interval o2)
			{
				if (o1.start < o2.start)
					return -1;

				if (o1.start == o2.start)
					return 0;

				return 1;
			}
		});

		List<Interval> ret = new ArrayList<Interval>();
		Interval cur = null;

		for (int i = 0; i < intervals.size(); i++)
		{
			if (cur == null)
				cur = intervals.get(i);
			else if (cur.end < intervals.get(i).start) //gap
			{
				ret.add(cur);
				cur = intervals.get(i);
			}
			else
				cur.end = Math.max(intervals.get(i).end, cur.end);

			if (i == intervals.size() - 1 && cur != null)
				ret.add(cur);
		}

		return ret;

	}
}