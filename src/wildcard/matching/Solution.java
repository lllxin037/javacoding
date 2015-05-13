package wildcard.matching;

import java.util.Arrays;

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

public class Solution
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

		boolean[][] matches = new boolean[2][sLen + 1];
		matches[0][0] = true;

		int cur = 0;
		int next = 0;
		for (int i = 0; i < pLen; i++)
		{
			cur = i & 1;
			next = 1 - cur;

			Arrays.fill(matches[next], false);

			char c = p.charAt(i);			
			if (c == '*')
			{
				int startPos = 0;
				while (startPos <= sLen && !matches[cur][startPos])
					startPos++;
				
				if (startPos == sLen + 1)
					continue;
				
				Arrays.fill(matches[next], startPos, sLen + 1, true);
				continue;
			}
			
			for (int j = 0; j < sLen; j++)
			{
				if (c == s.charAt(j) || c == '?')
					matches[next][j + 1] = matches[cur][j];
				if (c == '*')
				{
					int startPos = j;
					while (startPos <= sLen && !matches[cur][startPos])
						startPos++;
					
					if (startPos == sLen + 1)
						break;
					
					Arrays.fill(matches[next], startPos, sLen + 1, true);
					break;
				}
			}
		}

		return matches[next][sLen];
	}
}