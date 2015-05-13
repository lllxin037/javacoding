package leetcode.distinct.subsequence;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 */

public class Solution
{
	public int numDistinct(String S, String T)
	{
		if (T == null || S == null)
			return 0;
		
		if (T.length() > S.length())
			return 0;
		
		int[] times = new int[T.length()];
		for (int i = 0; i < times.length; i++)
		{
			times[i] = 0;
		}
		
		int len = S.length();
		for (int i = 0; i < len; i++)
		{
			char c = S.charAt(i);
			
			int iterNum = Math.min(i, T.length() -1);
			for (int j = iterNum; j >= 0; j--)
			{
				char d = T.charAt(j);
				if ( c != d )
					continue;

				if (j == 0)
					times[j] = times[j] + 1;
				else
				{
					times[j] =  times[j - 1] + times[j]  ;
				}
			}
		}
		
		return times[T.length() - 1];
	}
}