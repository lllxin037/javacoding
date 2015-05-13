package leetcode.two.sum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * <pre>
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * </pre>
 * 
 */

public class Solution
{
	public int[] twoSum(int[] numbers, int target)
	{
		int[] sum = new int[2];
		if (numbers == null || numbers.length == 0)
			return sum;

		Node[] vals = new Node[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			vals[i] = new Node(numbers[i], i + 1);

		Arrays.sort(vals, new Comparator<Node>()
		{
			@Override
			public int compare(Node o1, Node o2)
			{
				if (o1.val > o2.val)
					return 1;
				else if (o1.val < o2.val)
					return -1;
				return 0;
			}
		});

		int low = 0;
		int high = numbers.length - 1;
		while (low <= high)
		{
			if (vals[low].val > target - vals[high].val)
			{
				high--;
				continue;
			}
			else if (vals[low].val + vals[high].val < target)
			{
				low++;
				continue;
			}
			else if (vals[low].val + vals[high].val == target)
			{
				sum[0] = Math.min(vals[low].index, vals[high].index);
				sum[1] = Math.max(vals[low].index, vals[high].index);
				break;
			}
		}

		return sum;
	}

	static class Node
	{
		private int val;
		private int index;

		Node(int val, int index)
		{
			this.val = val;
			this.index = index;
		}
	}
}