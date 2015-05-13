package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RenderingCalendar
{

	public static int findMaxConcurrentEvents(List<Interval> A)
	{
		if (A == null || A.isEmpty())
			return 0;

		List<EndPoint> endpoints = new ArrayList<EndPoint>(A.size() << 1);
		for (Interval interv : A)
		{
			endpoints.add(new EndPoint(interv.start, true));
			endpoints.add(new EndPoint(interv.finish, false));
		}

		Collections.sort(endpoints);
		int counter = 0;
		int maxCount = 0;
		for (EndPoint endpoint : endpoints)
		{
			if (endpoint.isStart)
			{
				maxCount = Math.max(maxCount, ++counter);
			}
			else
				counter--;
		}

		return maxCount;

	}

	public static void main(String[] args)
	{
		int[][] intervals = new int[][]
		{
		{ 1, 5 },
		{ 6, 10 },
		{ 11, 13 },
		{ 14, 15 },
		{ 2, 7 },
		{ 8, 9 },
		{ 12, 15 },
		{ 4, 5 },
		{ 9, 17 } };

		List<Interval> A = new ArrayList<Interval>();
		for (int[] oneInterval : intervals)
		{
			Interval temp = new Interval(oneInterval[0], oneInterval[1]);
			A.add(temp);
		}
		int ans = findMaxConcurrentEvents(A);
		System.out.println(ans);
	}

	private static class EndPoint implements Comparable<EndPoint>
	{
		private int time;
		private boolean isStart;

		EndPoint(int time, boolean isStart)
		{
			this.time = time;
			this.isStart = isStart;
		}

		@Override
		public int compareTo(EndPoint o)
		{
			if (this.time < o.time)
				return -1;
			else if (this.time > o.time)
				return 1;
			else
			{
				if (isStart == o.isStart)
					return 0;

				if (isStart)
					return -1;

				return 1;
			}
		}
	}

	private static class Interval
	{
		int start, finish;

		Interval(int start, int finish)
		{
			this.start = start;
			this.finish = finish;
		}
	}
}
