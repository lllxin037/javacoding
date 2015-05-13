package leetcode.besttime.stockII;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 */

public class Solution
{
	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length == 0)
			return 0;
		
		int[] c = new int[prices.length];

		for (int i = 0; i < prices.length; i++)
		{
			if (i == 0)
			{
				c[i] = 0;
				continue;
			}
				
			if (prices[i] - prices[i-1] <= 0)
				c[i] = c[i -1];
			else
			{
				c[i] = c[i-1] + ( prices[i] - prices[i-1] );
			}
		}

		return c[prices.length - 1];
	}
}
