package leetcode.longest.substring.two.distinct.characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * <pre>
 * For example, Given s = ¡°eceba¡±,
 * 
 * T is "ece" which its length is 3.
 * </pre>
 * 
 */

public class Solution
{
	public int lengthOfLongestSubstringTwoDistinct(String s)
	{
		if (s == null)
			return 0;

		if (s.length() < 3)
			return s.length();

		int max = 0;
		Map<Character, Integer> counts = new HashMap<Character, Integer>(2);

		int left = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (counts.containsKey(c))
			{
				counts.put(c, counts.get(c) + 1);
				max = Math.max(max, i + 1 - left);
			}
			else
			{
				if (counts.size() == 2)
				{
					// move left to eliminate the 1st character.
					while (left < i)
					{
						char r = s.charAt(left++);
						int rCount = counts.get(r);
						if (rCount == 1)
						{
							counts.remove(r);
							break;
						}
						else
							counts.put(r, rCount - 1);
					}
				}

				counts.put(c, 1);

			}
		}

		return max;
	}
}