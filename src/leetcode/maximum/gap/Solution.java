package leetcode.maximum.gap;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
	public int maximumGap(int[] num)
	{
		if (num == null || num.length < 2)
			return 0;

		// allocate 0 - 9 buckets.
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(10);
		for (int i = 0; i < 10; i++)
			buckets.add(new ArrayList<Integer>());

		int maxVal = num[0];
		for (int i = 1; i < num.length; i++)
			maxVal = Math.max(maxVal, num[i]);
		int times = String.valueOf(maxVal).length();

		int mod = 10;
		int div = 1;

		int count = 0;
		while (count++ < times)
		{
			for (int i = 0; i < 10; i++)
				buckets.get(i).clear();

			for (int i = 0; i < num.length; i++)
			{
				int index = ((num[i] % mod) / div);
				buckets.get(index).add(num[i]);
			}

			// refresh the array from bucket 0 to 9;
			int index = 0;
			for (int i = 0; i < 10; i++)
			{
				if (!buckets.get(i).isEmpty())
				{
					for (int j = 0; j < buckets.get(i).size(); j++)
						num[index++] = buckets.get(i).get(j);
				}
			}

			mod = mod * 10;
			div = div * 10;
		}

		// transverse all element to find max gap.
		int maxGap = 0;
		for (int i = 1; i < num.length; i++)
			maxGap = Math.max(maxGap, num[i] - num[i - 1]);

		return maxGap;

	}
}
