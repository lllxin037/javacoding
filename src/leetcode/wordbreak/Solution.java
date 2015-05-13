package leetcode.wordbreak;

import java.util.Set;

/**
 * <pre>
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated 
 * sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * </pre>
 * 
 */

public class Solution
{
	public boolean wordBreak(String s, Set<String> dict)
	{
		// try with DP.
		
		int len = s.length();
		
		boolean dp[] = new boolean[len];
		
		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < i+1; j++)
			{			
				int endIndex = i+1;
				String s1 = s.substring(j, endIndex);
				if (dict.contains(s1) && (j-1 < 0 || dp[j-1]))
				{
					dp[i] = true;
				}
			}
		}
		
		return dp[len - 1];
	}
}
