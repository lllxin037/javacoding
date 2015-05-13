package leetcode.pow;

/**
 * Implement pow(x, n).
 * 
 */

public class Solution
{
	public double pow(double x, int n)
	{
		if (x == 0 || x == 1)
			return x;
		if (x == -1)
		{
			if (n % 2 == 0)
				return 1;
			return -1;
		}

		if (n == 0)
			return 1;

		if (n == 1)
			return x;

		double value = 1;
		for (int i = Math.abs(n); i > 0; x *= x, i >>= 1)
		{
			if ((i & 1) == 1)
				value = value * x;
		}

		if (n < 0)
			return 1 / value;

		return value;
	}
}
