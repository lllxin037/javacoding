package leetcode.longest.common.prefix;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 */

public class Solution
{
	public String longestCommonPrefix(String[] strs)
	{
		if (strs == null)
			return null;

		if (strs.length == 0)
			return "";

		int minLen = strs[0].length();
		for (int i = 1; i < strs.length; i++)
			minLen = Math.min(minLen, strs[i].length());

		if (minLen == 0)
			return "";

		String subStr = strs[0].substring(0, minLen);
		for (int i = 1; i < strs.length; i++)
		{
			String test = strs[i];
			for (int j = 0; j < subStr.length(); j++)
			{
				if (test.charAt(j) != subStr.charAt(j))
				{
					minLen = j;
					break;
				}
			}

			if (minLen == 0)
				return "";

			subStr = strs[0].substring(0, minLen);
		}

		return subStr;
	}
}