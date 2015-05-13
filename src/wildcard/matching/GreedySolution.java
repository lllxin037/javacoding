package wildcard.matching;

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

public class GreedySolution
{
	public boolean isMatch(String s, String p)
	{
		if (s == null && p == null)
			return true;

		if (s == null || p == null)
			return false;

		int sLen = s.length();
		int pLen = p.length();

		int sCur = 0;
		int pCur = 0;

		int lastStarNext = -1;
		int mark = -1;

		while (sCur < sLen)
		{
			if (pCur < pLen && p.charAt(pCur) == '*')
			{
				lastStarNext = pCur++;
				mark = sCur;
			}
			else if (pCur < pLen
					&& (p.charAt(pCur) == '?' || p.charAt(pCur) == s
							.charAt(sCur)))
			{
				sCur++;
				pCur++;
			}
			else if (lastStarNext != -1)
			{
				pCur = lastStarNext + 1;
				sCur = ++mark;
			}
			else
				return false;
		}

		while (pCur < p.length() && p.charAt(pCur) == '*')
			pCur++;

		return pCur == pLen;
	}
}