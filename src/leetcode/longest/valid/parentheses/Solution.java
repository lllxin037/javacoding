package leetcode.longest.valid.parentheses;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 */

public class Solution
{
	public int longestValidParentheses(String s)
	{
		if (s == null || s.isEmpty())
			return 0;

		return Math.max(longestHelper(s, 0, s.length(), 1, '('),
				longestHelper(s, s.length() - 1, -1, -1, ')'));
	}

	private int longestHelper(String s, int start, int end, int step,
			char expected)
	{
		int max = 0;
		int count = 0;
		int len = 0;

		for (int i = start; i != end; i = i + step)
		{
			if (s.charAt(i) == expected)
				count++;
			else
			{
				if (count > 0)
				{
					count--;
					len += 2;

					if (count == 0)
						max = Math.max(max, len);
				}
				else
					len = 0;
			}
		}

		return max;
	}
}