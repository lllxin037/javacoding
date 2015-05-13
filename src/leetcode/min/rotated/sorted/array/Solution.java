package leetcode.min.rotated.sorted.array;

public class Solution
{
	public int findMin(int[] num)
	{
		if (num == null || num.length == 0)
			return Integer.MIN_VALUE;

		if (num.length == 1)
			return num[0];

		int low = 0;
		int high = num.length - 1;
		while (low < high)
		{
			int mid = low + ((high - low) >> 1);

			if (num[high] < num[mid])
				low = mid + 1;
			else
				high = mid;
		}

		return num[low];
	}
}