package leetcode.largest.rectangle.histogram;

import java.util.Stack;

public class Solution1
{
	public int largestRectangleArea(int[] height)
	{

		if (height == null || height.length == 0)
			return 0;

		if (height.length == 1)
			return height[0];

		Stack<Integer> indices = new Stack<Integer>();
		int maxRec = height[0];

		indices.push(0);
		int cur = 1;
		while (cur <= height.length)
		{
			if (indices.isEmpty() || (cur < height.length && height[cur] >= height[indices.peek()]))
				indices.push(cur++);
			else
			{
				int last = indices.pop();
				maxRec = Math.max(maxRec, height[last] * (indices.isEmpty() ? cur : cur - indices.peek() - 1));
			}
		}

		return maxRec;
	}
}
