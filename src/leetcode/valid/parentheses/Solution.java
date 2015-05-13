package leetcode.valid.parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 */

public class Solution
{
	public boolean isValid(String s)
	{
		if (s == null || s.isEmpty())
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c == '}' || c == ')' || c == ']')
			{
				if (stack.isEmpty() || !isPair(c, stack.peek()))
					return false;

				stack.pop();
				continue;
			}
			
			stack.push(c);
		}

		return stack.isEmpty();
	}

	private boolean isPair(char c, char p)
	{
		if (c == ')')
			return p == '(';
		if (c == '}')
			return p == '{';
		if (c == ']')
			return p == '[';

		return false;

	}
}