package leetcode.insert.interval;

import java.util.List;

import leetcode.interval.Interval;

public class Test
{
	private static void oneCase(int[][] intervals, int[] newInterval)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<Interval> list = s1.insert(Interval.createIntervals(intervals),
				Interval.createInterval(newInterval[0], newInterval[1]));

		for (int i = 0; i < list.size(); i++)
		{
			System.out.print("[");
			System.out.print(list.get(i).start + "," + list.get(i).end);
			System.out.print("]   ");
		}
		System.out.println("");
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		// [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		oneCase(new int[][]
		{
		{ 1, 3 },
		{ 6, 9 } }, new int[]
		{ 2, 5 });

		oneCase(new int[][]
		{
		{ 1, 3 },
		{ 6, 9 } }, new int[]
		{ 4, 5 });

		oneCase(new int[][]
		{
		{ 1, 3 },
		{ 6, 9 } }, new int[]
		{ 3, 5 });

		oneCase(new int[][]
		{
		{ 1, 3 },
		{ 6, 9 } }, new int[]
		{ 4, 6 });

		oneCase(new int[][]
		{
		{ 1, 3 },
		{ 6, 9 } }, new int[]
		{ 3, 6 });

		// [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
		// [1,2],[3,10],[12,16].
		oneCase(new int[][]
		{
		{ 1, 2 },
		{ 3, 5 },
		{ 6, 7 },
		{ 8, 10 },
		{ 12, 16 } }, new int[]
		{ 4, 9 });

		oneCase(new int[][]
		{
		{ 1, 5 } }, new int[]
		{ 2, 3 });
	}
}
