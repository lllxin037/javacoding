package scramble.string;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * <pre>
 * Below is one possible representation of s1 = "great":
 * 
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * </pre>
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * 
 * <pre>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * </pre>
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 * 
 */

public class RecursiveSolution
{
	public boolean isScramble(String s1, String s2)
	{
		if (s1 == null)
			return s2 == null;

		if (s2 == null)
			return s1 == null;

		if (s1.length() != s2.length())
			return false;

		if (s1.equals(s2))
			return true;

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < s1.length(); i++)
		{
			if (c1[i] != c2[i])
				return false;
		}

		int len = s1.length();
		if (len == 1)
			return false;

		boolean flag = false;
		for (int i = 1; i < len; i++)
		{
			String s1l = s1.substring(0, i);
			String s1r = s1.substring(i, len);
			String s2l = s2.substring(0, i);
			String s2r = s2.substring(i, len);

			flag = isScramble(s1l, s2l) && isScramble(s1r, s2r);
			if (flag)
				break;

			// swap
			s2l = s2.substring(0, len - i);
			s2r = s2.substring(len - i, len);
			flag = isScramble(s1l, s2r) && isScramble(s1r, s2l);

			if (flag)
				break;
		}

		return flag;
	}
}