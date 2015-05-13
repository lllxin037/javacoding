package leetcode.besttime.stockIII;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 */

public class Solution
{
	
	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length == 0)
			return 0;
		
		int minIndex = 0;		

		int[] forwardProfit = new int[prices.length];
		forwardProfit[0] = 0;
		
		int[] backwardProfit = new int[prices.length];
		backwardProfit[prices.length - 1] = 0;
		
		for (int i = 1; i < prices.length; i++)
		{
			if (prices[i] < prices[minIndex])
			{
				// save minIndex or secMinIndex. depends on prices[minIndex]
				minIndex = i;
				forwardProfit[i] = forwardProfit[i-1];
			}
			else
			{
				int profit = prices[i] - prices[minIndex];				
				forwardProfit[i] = Math.max(forwardProfit[i-1], profit);
			}
		}
		
		int maxProfit = 0;
		int maxIndex = prices.length - 1;		
		for (int i = prices.length - 2; i >=0 ; i--)
		{
			if (prices[i] > prices[maxIndex])
			{
				// save minIndex or secMinIndex. depends on prices[minIndex]
				maxIndex = i;
				backwardProfit[i] = backwardProfit[i+1];
			}
			else
			{
				int profit = prices[i] - prices[maxIndex];				
				backwardProfit[i] = Math.min(backwardProfit[i+1], profit);
				
				if (backwardProfit[i] < 0)
				{
					profit = Math.abs(backwardProfit[i]) + forwardProfit[i];
					maxProfit = Math.max(profit, maxProfit);
				}
			}
		}
		
		return maxProfit;
	}
}
