package leetcode.two.sum.ii;

/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number. The function
 * twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2. Please note that your returned
 * answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * <pre>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * </pre>
 * 
 */

public class Solution
{
	public int[] twoSum(int[] numbers, int target)
	{
		int[] ret = new int[2];
		if (numbers == null || numbers.length < 2)
			return ret;

		int low = 0;
		int high = numbers.length - 1;
		while (low < high)
		{
			if (numbers[low] + numbers[high] < target)
				low++;
			else if (numbers[low] + numbers[high] > target)
				high--;
			else
			{
				ret[0] = low + 1;
				ret[1] = high + 1;
				break;
			}
		}

		return ret;
	}
}
