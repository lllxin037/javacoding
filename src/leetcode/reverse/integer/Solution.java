package leetcode.reverse.integer;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 */

public class Solution
{
	public int reverse(int x)
	{
		if (x >= 0 && x < 10)
			return x;

		long abs = x;
		boolean negative = (x < 0);
		if (negative)
			abs = (long) -x;

		long value = 0;
		while (abs > 0)
		{
			int div = (int) abs % 10;
			value = value * 10 + div;
			abs = abs / 10;

			if (!negative && value > Integer.MAX_VALUE)
				return 0;
			else if (negative && value * (-1) < Integer.MIN_VALUE)
				return 0;
		}

		if (negative)
			return (int) -value;

		return (int) value;
	}
}