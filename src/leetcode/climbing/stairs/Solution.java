package leetcode.climbing.stairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 */

public class Solution
{
	public int climbStairs(int n)
	{
		if (n <= 0)
			return 0;

		// for n == 1;
		int lastPre = 1;
		if (n == 1)
			return lastPre;

		// for n == 2;
		int pre = 2;

		for (int i = 3; i <= n; i++)
		{
			int steps = lastPre + pre;
			lastPre = pre;
			pre = steps;
		}

		return pre;
	}
}