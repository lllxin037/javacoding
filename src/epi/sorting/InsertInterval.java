package epi.sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval
{

	public static List<Interval> getNewInterval(List<Interval> intervals,
			Interval newOne)
	{
		List<Interval> ret = new ArrayList<Interval>();
		if (newOne == null)
			return intervals;

		if (intervals == null || intervals.isEmpty())
		{
			ret.add(newOne);
			return ret;
		}

		int index = 0;
		while (index < intervals.size()
				&& newOne.left > intervals.get(index).right)
			ret.add(intervals.get(index++));

		Interval toInsert = new Interval(newOne.left, newOne.right);
		while (index < intervals.size()
				&& toInsert.right >= intervals.get(index).left)
		{
			toInsert.left = Math.min(intervals.get(index).left, toInsert.left);
			toInsert.right = Math.max(intervals.get(index).right,
					toInsert.right);
			index++;
		}

		ret.add(toInsert);

		while (index < intervals.size())
			ret.add(intervals.get(index++));

		return ret;
	}

	public static void main(String[] args)
	{
		int[][] intervals = new int[][]
		{
		{ 0, 2 },
		{ 3, 6 },
		{ 7, 7 },
		{ 9, 12 } };

		List<Interval> A = new ArrayList<Interval>();
		for (int[] oneInterval : intervals)
		{
			Interval temp = new Interval(oneInterval[0], oneInterval[1]);
			A.add(temp);
		}

		System.out.println(getNewInterval(A, new Interval(1, 8)));

		System.out.println(getNewInterval(A, new Interval(3, 7)));
		System.out.println(getNewInterval(A, new Interval(13, 17)));

		System.out.println(getNewInterval(A, new Interval(3, 9)));
	}

	private static class Interval
	{
		int left, right;

		Interval(int left, int right)
		{
			this.left = left;
			this.right = right;
		}

		public String toString()
		{
			return "[" + left + ", " + right + "]";
		}
	}
}
