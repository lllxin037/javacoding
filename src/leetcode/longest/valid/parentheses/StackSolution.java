package leetcode.longest.valid.parentheses;

import java.util.Stack;

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

public class StackSolution
{
	public int longestValidParentheses(String s)
	{
		if (s == null || s.isEmpty())
			return 0;

		Stack<Integer> stack = new Stack<Integer>();

		int last = -1;
		int max = 0;

		for (int cur = 0; cur < s.length(); cur++)
		{
			if (s.charAt(cur) == '(')
			{
				stack.push(cur);
				continue;
			}

			// ignore when input is ')' and the stack is empty.
			if (stack.isEmpty())
			{
				last = cur;
				continue;
			}

			stack.pop();
			if (stack.isEmpty())
				max = Math.max(max, cur - last);
			else
				max = Math.max(max, cur - stack.peek());
		}

		return max;
	}
}