package string.integer.atoi;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * spoilers alert... click to show requirements for atoi.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 */

public class Solution
{
	public int atoi(String str)
	{
		if (str == null || str.length() == 0)
			return 0;

		char[] s = str.toCharArray();
		int i = 0;
		for (; i < s.length && s[i] == ' '; i++)
			;

		boolean negative = false;
		if (s[i] == '-')
		{
			negative = true;
			i++;
		}
		else if (s[i] == '+')
			i++;

		long num = 0;

		for (; i < s.length && s[i] >= '0' && s[i] <= '9'; i++)
		{
			num = num * 10 + s[i] - '0';
			if (num > Integer.MAX_VALUE)
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}

		// ignore the remaining value.
		if (negative)
			return (int) -num;

		return (int) num;
	}
}
