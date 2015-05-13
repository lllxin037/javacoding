package leetcode.sqrt;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 */

public class Solution
{
	public int sqrt(int x)
	{
		if (x < 2)
			return x;

		int low = 1;
		int high = x;

		while (high - low > 1)
		{
			int mid = low + ((high - low) >> 1); // (high + low)/2
			int v = x / mid;
			if (v == mid)
				return mid;
			if (v > mid)
				low = mid;
			else
				high = mid;
		}

		return (int) low;
	}
}
