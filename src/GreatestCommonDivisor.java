/**
 * Design an efficient algorithm for computing the GCD of two numbers without
 * using multiplication, division or the modulus operators.
 * 
 */

public class GreatestCommonDivisor
{

	public static int compute(int a, int b)
	{
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		// use binary GCD algorithm
		int d = 1;

		while (b != 0)
		{
			boolean evenA = ((a & 1) == 0);
			boolean evenB = ((b & 1) == 0);
			if (evenA)
				a = a >> 1;
			if (evenB)
				b = b >> 1;

			if (evenA && evenB)
				d = d << 1;

			if (!evenA && !evenB)
			{
				if (a == b)
				{
					d = d * a;
					break;
				}
				int c = Math.abs(a - b) >> 1;
				a = Math.min(a, b);

				b = Math.min(a, c);
				a = Math.max(a, c);
			}
		}

		return d;
	}

	public static void main(String[] args)
	{
		System.out.println(compute(5, 101));
		System.out.println(compute(101, 5));

		System.out.println(compute(48, 18));

		System.out.println(compute(20, 5));
		
		System.out.println(compute(24, 300));
	}
}
