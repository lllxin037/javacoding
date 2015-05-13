package leetcode.regular.expression.matching;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * <pre>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") -> false
 * isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false
 * isMatch("aa", "a*") -> true
 * isMatch("aa", ".*") -> true
 * isMatch("ab", ".*") -> true
 * isMatch("aab", "c*a*b") -> true
 * </pre>
 * 
 * 
 */

public class Solution
{
	public boolean isMatch(String s, String p)
	{
		if (s == null && p == null)
			return true;

		if (s == null || p == null)
			return false;

		return matchHelper(s, p, 0, 0);
	}

	private boolean matchHelper(String s, String p, int sCur, int pCur)
	{
		if (sCur == s.length())
		{
			while (pCur + 1 < p.length() && p.charAt(pCur + 1) == '*')
				pCur += 2;

			return pCur == p.length();
		}

		if (pCur + 1 < p.length() && p.charAt(pCur + 1) == '*')
		{
			while (sCur < s.length()
					&& (p.charAt(pCur) == '.' || s.charAt(sCur) == p
							.charAt(pCur)))
			{
				if (matchHelper(s, p, sCur, pCur + 2))
					return true;
				sCur++;
			}

			return matchHelper(s, p, sCur, pCur + 2);
		}
		else if (pCur < p.length()
				&& (p.charAt(pCur) == '.' || s.charAt(sCur) == p.charAt(pCur)))
		{
			return matchHelper(s, p, sCur + 1, pCur + 1);
		}

		return false;
	}
}