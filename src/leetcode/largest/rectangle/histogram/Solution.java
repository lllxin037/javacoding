package leetcode.largest.rectangle.histogram;

import java.util.Stack;

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

public class Solution
{
	public int largestRectangleArea(int[] height)
	{
		if (height == null || height.length == 0)
			return 0;

		int ret = 0;
		Stack<Integer> tmp = new Stack<Integer>();

		tmp.push(0);

		int cur = 1;
		while (cur <= height.length)
		{
			if (tmp.isEmpty()
					|| (cur < height.length && height[cur] > height[tmp.peek()]))
			{
				tmp.push(cur++);
			}
			else
			{
				int tmpValue = tmp.pop();
				ret = Math.max(ret, height[tmpValue]
						* (tmp.isEmpty() ? cur : cur - tmp.peek() - 1));
			}
		}

		return ret;
	}
}