package leetcode.next.permutation;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * <pre>
 * Here are some examples. Inputs are in the left-hand column and its corresponding 
 * outputs are in the right-hand column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 * </pre>
 * 
 */

public class Solution
{
	public void nextPermutation(int[] num)
	{
		if (num == null || num.length <= 1)
			return;

		int len = num.length;

		int i = len - 1;
		while (i > 0 && num[i - 1] >= num[i])
			i--;

		// reverse the whole string.
		reverse(num, i, len - 1);
		if (i == 0)
			return;

		int b = i - 1;
		for (; i < len; i++)
		{
			if (num[i] > num[b])
				break;
		}

		swap(num, b, i);
	}

	private void reverse(int[] num, int start, int end)
	{
		while (start < end)
			swap(num, start++, end--);
	}

	private void swap(int[] num, int a, int b)
	{
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}
}
