package leetcode.divide.two.integers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 */

public class Solution
{
	public int divide(int dividend, int divisor)
	{
		if (dividend == 0)
			return 0;

		if (divisor == 0)
			return Integer.MAX_VALUE;

		if (divisor == 1)
			return dividend;

		if (divisor == -1)
			return -dividend;

		int result = 0;

		long iterResult = Math.abs(dividend);
		if (iterResult < 0)
			iterResult = -iterResult;

		long absDivisor = Math.abs(divisor);
		if (absDivisor < 0)
			absDivisor = -absDivisor;

		while (iterResult >= absDivisor)
		{
			int bitShift = 0;
			long divShift = absDivisor;

			while (divShift <= iterResult)
			{
				bitShift++;
				divShift = divShift << 1;
			}

			if (bitShift > 0)
			{
				result += 1 << (bitShift - 1);
				iterResult = iterResult - (divShift >> 1);
			}
		}

		if ((dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0))
			return -result;

		return result;
	}
}