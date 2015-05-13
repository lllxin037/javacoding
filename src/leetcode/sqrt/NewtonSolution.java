package leetcode.sqrt;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 */

public class NewtonSolution
{
	public int sqrt(int x)
	{
		double val = x / 2;
		if (val == 0)
			return x;
		
		double last = val;

		do
		{
			last = val;
			val = (val + x / val) / 2;
		}
		while (Math.abs(val - last) > 0.01);

		return (int) val;
	}
}
