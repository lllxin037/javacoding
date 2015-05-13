package leetcode.wildcard.matching;

/**
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * <pre>
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "*") ¡ú true
 * isMatch("aa", "a*") ¡ú true
 * isMatch("ab", "?*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú false
 * </pre>
 */

public class Solution1 {

	public boolean isMatch(String s, String p) {

		if (s == null && p == null)
			return true;

		if (s == null || p == null)
			return false;

		int sCur = 0;
		int pCur = 0;

		int sMark = -1;
		int pMark = -1;
		while (sCur < s.length()) {

			if (pCur < p.length() && p.charAt(pCur) == '*') {
				pMark = pCur++;
				sMark = sCur;
			}
			else if (pCur < p.length()
					&& (p.charAt(pCur) == '?' || p.charAt(pCur) == s
							.charAt(sCur))) {
				pCur++;
				sCur++;
			}
			else if (pMark != -1) {
				pCur = pMark;
				sCur = sMark + 1;
			}
			else
				return false;

		}

		while (pCur < p.length() && p.charAt(pCur) == '*')
			pCur++;

		return pCur == p.length();
	}
}
