import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */

public class MaxProfit
{

	public static int twoTimes(int[] prices)
	{
		if (prices == null || prices.length < 2)
			return 0;

		int[] profits = new int[prices.length];
		profits[0] = 0;

		int low = prices[0];
		for (int i = 1; i < prices.length; i++)
		{
			if (low > prices[i])
			{
				low = prices[i];
				profits[i] = profits[i - 1];
			}
			else
				profits[i] = Math.max(profits[i - 1], prices[i] - low);
		}

		int high = prices[prices.length - 1];
		int maxProfit = profits[prices.length - 1];

		int bbMaxProfit = 0;
		for (int i = prices.length - 2; i > 0; i--)
		{
			if (prices[i] > high)
				high = i;
			else
				bbMaxProfit = Math.max(bbMaxProfit, high - prices[i]);

			maxProfit = Math.max(maxProfit, bbMaxProfit + profits[i - 1]);
		}

		return maxProfit;
	}

	private static void fill(List<Integer> list, int numOfElements, int value)
	{
		for (int i = 1; i <= numOfElements; ++i)
		{
			list.add(value);
		}
	}

	/**
	 * http://blog.csdn.net/linhuanmars/article/details/23236995
	 * 
	 * @param A
	 * @param k
	 * @return
	 */
	
	public static int kTimes(int[] A, int k)
	{
		List<Integer> kSum = new ArrayList<Integer>(k * 2);
		fill(kSum, 2 * k, Integer.MIN_VALUE);

		for (int i = 0; i < A.length; ++i)
		{
			List<Integer> preKSum = new ArrayList<Integer>(kSum);

			for (int j = 0, sign = -1; j < kSum.size() && j <= i; ++j, sign *= -1)
			{
				int diff = sign * A[i] + (j == 0 ? 0 : preKSum.get(j - 1));
				kSum.set(j, Math.max(diff, preKSum.get(j)));
			}
		}

		// Returns the last selling profits as the answer.
		return kSum.get(kSum.size() - 1);
	}

	public static void main(String[] args)
	{
		System.out.println(kTimes(new int[]
		{ 6, 1, 3, 2, 4, 7 }, 2));

		System.out.println(kTimes(new int[]
		{ 3, 2, 6, 5, 0, 3 }, 2));

		System.out.println(kTimes(new int[]
		{ 3, 3, 5, 0, 0, 3, 1, 4 }, 2));

		System.out.println(kTimes(new int[]
		{ 3, 3, 5, 0, 0, 3, 1, 4 }, 3));

		System.out.println(kTimes(new int[]
		{ 8, 11, 10, 12, 10, 15 }, 2));
	}

}
