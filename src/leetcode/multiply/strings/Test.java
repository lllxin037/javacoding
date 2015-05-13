package leetcode.multiply.strings;

import java.math.BigDecimal;

public class Test
{
	private static void oneCase(String num1, String num2)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.multiply(num1, num2));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/*	*/
		oneCase("12", "1");
		oneCase("52", "2");

		oneCase("321", "23");
		oneCase("321", "123");

		oneCase("321111111111", "1231111111111111111111111111");

		BigDecimal a = new BigDecimal("321111111111");
		BigDecimal b = new BigDecimal("1231111111111111111111111111");
		System.out.println(a.multiply(b));
	}

}
