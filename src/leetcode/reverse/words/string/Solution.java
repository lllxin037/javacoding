package leetcode.reverse.words.string;

import java.util.Stack;

/**
 * Given an input string, reverse the string word by word.
 * 
 * <pre>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * </pre>
 * 
 * click to show clarification.
 * 
 */

public class Solution
{
	public String reverseWords(String s)
	{
		if (s == null || s.length() == 0)
			return s;

		// reverse the whole string then reverse words one by one.
		int head = 0;
		while (head < s.length() && s.charAt(head) == ' ')
			head++;
		int tail = s.length() - 1;
		while (tail >= 0 && s.charAt(tail) == ' ')
			tail--;

		int cur = head;
		int last = head;
		Stack<String> stack = new Stack<String>();

		while (cur <= tail)
		{
			while (cur <= tail && s.charAt(cur) != ' ')
				cur++;

			if (cur - last >= 0)
				stack.push(s.substring(last, cur));

			while (cur <= tail && s.charAt(cur) == ' ')
				cur++;
			
			last = cur;
		}

		if (stack.isEmpty())
			return "";

		String ret = stack.pop();
		while (!stack.isEmpty())
			ret = ret + " " + stack.pop();

		return ret;
	}

}