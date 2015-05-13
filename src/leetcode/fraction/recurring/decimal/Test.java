package leetcode.fraction.recurring.decimal;

public class Test
{
	private static void oneCase(int numerator, int denominator)
	{
		Solution s = new Solution();
		System.out.println(s.fractionToDecimal(numerator, denominator));
	}

	public static void main(String[] args)
	{
	 	oneCase(7, -12);
	 	
		oneCase( -1, -2147483648);
		oneCase(1, 3);
		oneCase(2, 4);
		oneCase(22, 7);

		oneCase(58, 2828);

		oneCase(1, 29);
	}
}
