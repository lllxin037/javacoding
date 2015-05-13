package leetcode.implement.strStr;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 */

public class Solution
{
	public String strStr(String haystack, String needle)
	{
		// sunday algorithm.

		if (haystack == null || needle == null)
			return null;

		if (needle.length() > haystack.length())
			return null;

		if (haystack.isEmpty() && needle.isEmpty())
			return haystack;

		int left = 0;
		int cur = 0;
		int tCur = 0;

		while (cur < haystack.length())
		{
			if (tCur == needle.length())
				return haystack.substring(left);

			if (haystack.charAt(cur) == needle.charAt(tCur))
			{
				cur++;
				tCur++;
				if (tCur == needle.length())
					return haystack.substring(left);

				continue;
			}

			// find the character to match
			int pos = left + needle.length();
			if (pos >= haystack.length())
				return null;

			char c = haystack.charAt(pos);
			// find the character in needle
			int target = -1;
			for (int i = needle.length() - 1; i >= 0; i--)
			{
				if (c == needle.charAt(i))
				{
					target = i;
					break;
				}
			}

			if (target == -1)
			{
				left = pos + 1;
				tCur = 0;
				cur = left;
				continue;
			}

			left = pos - target;
			cur = left;
			tCur = 0;
		}

		return null;
	}
}