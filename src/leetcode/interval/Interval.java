package leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class Interval
{
	public int start;
	public int end;

	public Interval()
	{
		start = 0;
		end = 0;
	}

	public Interval(int s, int e)
	{
		start = s;
		end = e;
	}

	public static List<Interval> createIntervals(int[][] values)
	{
		if (values == null || values.length == 0)
			return null;

		List<Interval> ret = new ArrayList<Interval>();
		int len = values.length;
		for (int i = 0; i < values.length; i++)
		{
			int[] one = values[i];
			ret.add(new Interval(one[0], one[1]));
		}

		return ret;
	}

	public static Interval createInterval(int start, int end)
	{
		return new Interval(start, end);
	}
}