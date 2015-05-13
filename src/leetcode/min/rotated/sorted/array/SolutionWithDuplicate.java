package leetcode.min.rotated.sorted.array;

public class SolutionWithDuplicate
{
	public int findMin(int[] num)
	{
		if (num == null || num.length == 0)
			return 0;

		if (num.length == 1)
			return num[0];

		int low = 0;
		int high = num.length - 1;
		while (low < high)
		{
			int mid = low + ((high - low) >> 1);
			if (num[high] < num[mid])
				low = mid + 1;
			else if (num[high] == num[low])
				high = high - 1;
			else
				high = mid;
		}

		return num[low];
	}
}
