package leetcode.longest.palindromic.substring;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 */

public class Solution
{
	public String longestPalindrome(String s)
	{
		if (s == null || s.length() <= 1)
			return s;

		StringBuilder newS = new StringBuilder();
		newS.append('#');
		for (int i = 0; i < s.length(); i++)
		{
			newS.append(s.charAt(i));
			newS.append('#');
		}

		int[] P = new int[newS.length()];
		P[0] = 1;

		// id is the center index of the longest palindrome
		// right is the index of the id+P[id]. The right edge of palindrome
		int id = 0, right = 0;
		int newLen = P.length;
		for (int i = 1; i < newLen; i++)
		{
			if (right - i <= 0)
				P[i] = 1;
			else
			{
				// mirror = id + (id - i) = 2 * id - i, mirror is the mirror
				// index of i to id
				int mirror = (id << 1) - i;

				/* P[j] >= mx - i */
				if (right - i > P[mirror])
					P[i] = P[mirror];
				else
					P[i] = right - i;
			}

			while (i + P[i] < newLen && i - P[i] >= 0
					&& newS.charAt(i + P[i]) == newS.charAt(i - P[i]))
				P[i]++;

			if (i + P[i] > right)
			{
				id = i;
				right = id + P[id];
			}
		}

		right = P[0];
		id = 0;
		for (int i = 1; i < P.length; i++)
		{
			if (P[i] > right)
			{
				id = i;
				right = P[i];
			}
		}

		return s.substring(id - right > 0 ? (id - right + 1) / 2 : 0,
				(id + right) / 2);
	}
}