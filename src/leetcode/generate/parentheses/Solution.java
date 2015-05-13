package leetcode.generate.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * <pre>
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * </pre>
 * 
 */
public class Solution
{
	public List<String> generateParenthesis(int n)
	{
		List<String> combinations = new ArrayList<String>();
		if (n <= 0)
			return combinations;

		parenthesisHelper(combinations, n, 0, 0, new StringBuilder());
		return combinations;
	}

	private void parenthesisHelper(List<String> combinations, int n, int l,
			int r, StringBuilder sb)
	{
		if (l == n)
		{
			while (r++ < n)
				sb.append(')');
			combinations.add(sb.toString());
		}
		else if (l == r)
			parenthesisHelper(combinations, n, l + 1, r, sb.append('('));
		else
		{
			int oldlen = sb.length();
			parenthesisHelper(combinations, n, l + 1, r, sb.append('('));
			sb = sb.delete(oldlen, sb.length());
			parenthesisHelper(combinations, n, l, r + 1, sb.append(')'));
		}
	}
}