package leetcode.palindromeII;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 */

public class Solution
{

	public int minCut(String s)
	{
		boolean[][] palindromeValues = new boolean[s.length()][s.length()];

		int[] min_cut = new int[s.length() + 1];
		int len = s.length();

		for (int i = 0; i <= len; i++)
			min_cut[i] = len - i;

		for (int i = len - 1; i >= 0; i--)
		{
			for (int j = i; j < len; j++)
			{
				if (s.charAt(i) == s.charAt(j)
						&& (j - i <= 1 || palindromeValues[i + 1][j - 1]))
				{
					palindromeValues[i][j] = true;
					min_cut[i] = Math.min(min_cut[i], min_cut[j + 1] + 1);
				}
			}
		}

		return min_cut[0] -1;
	}
}
