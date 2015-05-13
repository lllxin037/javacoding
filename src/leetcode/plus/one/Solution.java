package leetcode.plus.one;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 */

public class Solution
{
	public int[] plusOne(int[] digits)
	{
		if (digits == null || digits.length == 0)
			return digits;

		int stopPos = -1;
		
		for (int i = digits.length - 1; i >=0 ; i--)
		{
			int tmp = digits[i] + 1;
			if ( tmp < 10)
			{
				stopPos = i;
				break;
			}
		}
		
		int[] ret = null;
		if (stopPos == -1)
		{
			ret = new int[digits.length + 1];
			ret[0] = 1;
			for (int i = 1; i < ret.length; i++)
				ret[i] = 0;
			
			return ret;
		}
		
		ret = new int[digits.length ];
		for (int i = digits.length - 1; i >=0 ; i--)
		{
			if (i > stopPos)
				ret[i] = 0;
			else if (i == stopPos)
				ret[i] = digits[i] + 1;
			else
				ret[i] = digits[i];
		}
		
		return ret;
	}
}