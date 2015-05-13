package leetcode.container.with.most.water;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 */

public class Solution
{
	public int maxArea(int[] height)
	{
		if (height == null)
			return 0;

		int sum = 0;

		int low = 0;
		int high = height.length - 1;

		while (low < high)
		{
			int tmp = Math.min(height[high], height[low]) * (high - low);
			sum = Math.max(tmp, sum);

			if (height[low] < height[high])
				low++;
			else
				high--;
		}

		return sum;
	}
}