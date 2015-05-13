package leetcode.besttime.stockIII;

public class Solution1 {

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length < 2)
			return 0;

		int[] profits = new int[prices.length];
		int minIndex = 0;
		int maxProfit = 0;

		profits[0] = 0;

		// go forward

		for (int i = 1; i < prices.length; i++) {

			if (prices[i] < prices[minIndex])
				minIndex = i;

			profits[i] = Math.max(profits[i - 1], prices[i] - prices[minIndex]);
		}

		int maxIndex = prices.length - 1;
		for (int i = prices.length - 2; i >= 0; i--) {

			if (prices[i] > prices[maxIndex])
				maxIndex = i;

			maxProfit = Math.max(maxProfit, prices[maxIndex] - prices[i]
					+ profits[i]);
		}

		return maxProfit;

	}
}