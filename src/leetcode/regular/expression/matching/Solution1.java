package leetcode.regular.expression.matching;

public class Solution1
{

	public boolean isMatch(String s, String p)
	{
		if (s == null && p == null)
			return true;

		if (s == null || p == null)
			return false;

		return checkMatch(s, p, 0, 0);
	}

	private boolean checkMatch(String s, String p, int sCur, int pCur)
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
					&& ((p.charAt(pCur) == '.') || p.charAt(pCur) == s
							.charAt(sCur)))
			{
				if (checkMatch(s, p, sCur, pCur + 2) == true)
					return true;

				sCur++;
			}

			return checkMatch(s, p, sCur, pCur + 2);
		}
		else if (pCur < p.length()
				&& (p.charAt(pCur) == '.' || p.charAt(pCur) == s.charAt(sCur)))
		{
			return checkMatch(s, p, sCur + 1, pCur + 1);
		}

		return false;
	}
}
