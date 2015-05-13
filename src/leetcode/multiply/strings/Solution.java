package leetcode.multiply.strings;

import java.util.Arrays;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 */

public class Solution
{
	public String multiply(String num1, String num2)
	{
		if (num1 == null || num1.isEmpty())
			return num2;

		if (num2 == null || num2.isEmpty())
			return num1;

		if (num1.equals("0") || num2.equals("0"))
			return "0";

		if (num1.equals("1"))
			return num2;

		if (num2.equals("1"))
			return num1;

		char[] result = new char[num1.length() + num2.length()];
		int rid = result.length - 1;
		Arrays.fill(result, '0');

		for (int i = num2.length() - 1; i >= 0; i--)
		{
			// shift the position for the next integer from num2
			rid = result.length - 1 - (num2.length() - 1 - i);

			int carry = 0;
			int b = num2.charAt(i) - '0';

			for (int j = num1.length() - 1; j >= 0; j--)
			{
				int a = num1.charAt(j) - '0';
				a = a * b + carry + (result[rid] - '0');

				carry = a / 10; // New carry
				result[rid--] = (char) (a % 10 + '0');
			}

			if (carry > 0)
			{
				int value = carry + (result[rid] - '0');
				carry = value / 10; // New carry
				result[rid--] = (char) (value % 10 + '0');
			}
		}

		int start = 0;
		for (int i = 0; i < result.length; i++)
		{
			if (result[i] != '0')
			{
				start = i;
				break;
			}
		}
		return new String(result, start, result.length - start);
	}
}