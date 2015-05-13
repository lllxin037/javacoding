package leetcode.divide.two.integers;

public class Test
{
	private static void oneCase(int dividend, int divisor)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.divide(dividend, divisor));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(33, 3);

		oneCase(1200, 3);

		oneCase(-999511578, -2147483648);

		oneCase(100579234, -555806774);
	}
}
