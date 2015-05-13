package leetcode.two.sum;

import java.util.HashMap;
import java.util.Map;

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

public class HashMapSolution
{
	public int[] twoSum(int[] numbers, int target)
	{
		Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
		int[] sum = new int[2];

		for (int i = 0; i < numbers.length; i++)
		{
			int val = numbers[i];
			Integer index = mapping.get(target - val);
			if (index == null)
				mapping.put(val, i);
			else
			{
				sum[0] = index + 1;
				sum[1] = i + 1;
			}
		}

		return sum;
	}
}