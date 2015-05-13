package leetcode.longest.substring.without.repeating.characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 */

public class Solution
{
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null)
			return 0;

		if (s.length() <= 1)
			return s.length();

		int left = 0, right = 0;
		int len = s.length();

		Map<Character, Integer> unique = new HashMap<Character, Integer>();
		int max = 0;

		while (right < len)
		{
			char rc = s.charAt(right);
			if (unique.get(rc) != null &&  unique.get(rc) >= left)
			{
				max = Math.max(max, right - left);
				left = unique.get(rc) + 1;
			}
			unique.put(rc, right++);
		}
		max = Math.max(max, right - left);
		return max;
	}
}