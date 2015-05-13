package leetcode.longest.substring.without.repeating.characters;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 */

public class HashSetSolution
{
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null)
			return 0;

		if (s.length() <= 1)
			return s.length();

		int left = 0, right = 1;
		int len = s.length();

		Set<Character> unique = new HashSet<Character>();
		unique.add(s.charAt(0));

		int max = 0;

		while (right < len && left < len - 1)
		{
			char rc = s.charAt(right);
			if (!unique.contains(rc))
			{
				unique.add(rc);
				right++;
			}
			else
			{
				max = Math.max(max, right - left);
				// move left until right character can be added into the set
				while (unique.contains(rc))
				{
					char lc = s.charAt(left);
					unique.remove(lc);
					left++;
				}
				unique.add(rc);
				right++;
			}
		}
		max = Math.max(max, right - left);
		return max;
	}
}