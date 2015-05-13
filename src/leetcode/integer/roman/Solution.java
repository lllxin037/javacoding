package leetcode.integer.roman;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
 */

public class Solution
{
	public String intToRoman(int num)
	{
		int[] nums =
		{ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols =
		{ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		String s = "";
		for (int i = 0; num > 0 && i < nums.length; i++)
		{
			while (num >= nums[i])
			{
				s += symbols[i];
				num -= nums[i];
			}
		}

		return s;
	}
}