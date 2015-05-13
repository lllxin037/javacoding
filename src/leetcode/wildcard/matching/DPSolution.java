package leetcode.wildcard.matching;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * <pre>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "*") ¡ú true
 * isMatch("aa", "a*") ¡ú true
 * isMatch("ab", "?*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú false
 * </pre>
 * 
 */

public class DPSolution
{
	public boolean isMatch(String s, String p)
	{
		if (s == null && p == null)
			return true;

		if (s == null || p == null)
			return false;

		int sLen = s.length();
		int pLen = p.length();

		int count = 0;
		for (int i = 0; i < pLen; i++)
		{
			if (p.charAt(i) != '*')
				count++;
		}

		if (count > sLen)
			return false;

		boolean[][] dp = new boolean[sLen + 1][pLen + 1];

		dp[0][0] = true;
		for (int i = 0; i < pLen; i++)
		{
			if (dp[0][i] && p.charAt(i) == '*')
				dp[0][i + 1] = true;

			for (int j = 0; j < sLen; j++)
			{
				if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')
					dp[j + 1][i + 1] = dp[j][i];
				if (p.charAt(i) == '*')
					dp[j + 1][i + 1] = dp[j][i + 1] || dp[j + 1][i];
			}
		}

		return dp[sLen][pLen];
	}
}