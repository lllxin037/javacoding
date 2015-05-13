package leetcode.largest.rectangle.histogram;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 */

public class SolutionNSquare
{
	public int largestRectangleArea(int[] height)
	{
		if (height == null || height.length == 0)
			return 0;

		int len = height.length;

		int[] area = new int[len];
		for (int i = 0; i < height.length; i++)
		{
			int one = height[i];
			area[i] = one;

			int minHeight = one;
			for (int j = i; j < height.length; j++)
			{
				minHeight = Math.min(minHeight, height[j]);
				int tmpArea = minHeight * (j - i + 1);
				if (tmpArea > area[i])
					area[i] = tmpArea;
			}
		}

		int ret = 0;
		for (int i = 0; i < area.length; i++)
		{
			ret = Math.max(ret, area[i]);
		}

		return ret;
	}
}