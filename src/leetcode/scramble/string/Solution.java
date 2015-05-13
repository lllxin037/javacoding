package leetcode.scramble.string;

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

public class Solution
{
	public boolean isScramble(String s1, String s2)
	{
		int len = s1.length();

		boolean[][][] scramble = new boolean[len][len][len];
		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				if (s1.charAt(i) == s2.charAt(j))
					scramble[i][j][0] = true;
			}
		}

		// scramble[k][i][j] indicates s1[i...i+k] can be scrambled from
		// s2[j...j+k]

		for (int k = 1; k < len; k++)
		{
			// i is for s1
			for (int i = 0; i < len - k; i++)

				// j is for s2
				for (int j = 0; j < len - k; j++)
				{
					boolean flag = false;
					for (int l = 1; l <= k; l++)
					{
						flag = scramble[i][j][l - 1]
								&& scramble[i + l][j + l][k - l];
						if (flag)
							break;
						flag = scramble[i][j + k + 1 - l][l - 1]
								&& scramble[i + l][j][k - l];
						if (flag)
							break;
					}
					scramble[i][j][k] = flag;
				}
		}

		return scramble[0][0][len - 1];
	}
}