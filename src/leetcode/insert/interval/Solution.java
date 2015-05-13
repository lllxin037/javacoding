package leetcode.insert.interval;

import java.util.ArrayList;
import java.util.List;

import leetcode.interval.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * <pre>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * </pre>
 */

public class Solution
{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval)
	{
		if (intervals == null)
			return null;

		if (newInterval == null)
			return intervals;

		if (intervals.isEmpty())
		{
			intervals.add(newInterval);
			return intervals;
		}

		List<Interval> ret = new ArrayList<Interval>();
		int index = 0;

		while (index < intervals.size()
				&& intervals.get(index).end < newInterval.start)
			ret.add(intervals.get(index++));

		while (index < intervals.size()
				&& intervals.get(index).start <= newInterval.end)
		{
			newInterval.start = Math.min(newInterval.start,
					intervals.get(index).start);
			newInterval.end = Math.max(newInterval.end,
					intervals.get(index).end);
			index++;
		}

		ret.add(newInterval);

		while (index < intervals.size())
			ret.add(intervals.get(index++));

		return ret;
	}
}