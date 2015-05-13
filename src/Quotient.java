/**
 * Given two positive integers, compute their quotient, using only the addition,
 * subtraction, and shifting operators.
 * 
 */
public class Quotient
{

	public static int compute(int dividend, int divisor)
	{
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == 0)
			return 0;

		boolean positive = true;
		if (dividend < 0 && divisor > 0)
		{
			positive = false;
			dividend = -dividend;
		}

		if (dividend > 0 && divisor < 0)
		{
			positive = false;
			divisor = -divisor;
		}

		int result = 0;
		while (dividend - divisor >= 0)
		{
			int bitShift = 0;
			int divShift = divisor;

			while (dividend - divShift >= 0)
			{
				bitShift++;
				divShift = divShift << 1;
			}

			if (bitShift > 0)
			{
				result += 1 << (bitShift - 1);
				dividend = dividend - (divShift >> 1);
			}
		}

		if (!positive)
			return -result;

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(compute(8, 3));
		System.out.println(compute(100, 3));
	}
}
