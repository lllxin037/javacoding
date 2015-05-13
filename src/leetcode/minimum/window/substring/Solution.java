package leetcode.minimum.window.substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * <pre>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * 
 * Minimum window is "BANC".
 * </pre>
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 */

public class Solution
{
	public String minWindow(String S, String T)
	{
		if (S == null || S.isEmpty())
			return "";

		Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
		Map<Character, Integer> needFound = new HashMap<Character, Integer>();

		for (int i = 0; i < T.length(); i++)
		{
			char c = T.charAt(i);

			hasFound.put(c, 0);
			Integer count = needFound.get(c);
			if (count == null)
				needFound.put(c, 1);
			else
				needFound.put(c, count + 1);
		}

		int counter = T.length();
		int c1 = 0;

		int left = 0;
		int right = 0;

		String ret = "";
		int winSize = Integer.MAX_VALUE;

		// keep found T-letters in an array to avoid revisit non-T-letters when
		// forwarding left
		List<Integer> nexts = new ArrayList<Integer>();

		while (right < S.length())
		{
			char c = S.charAt(right);
			if (!needFound.containsKey(c))
			{
				right++;
				continue;
			}

			nexts.add(right);

			Integer found = hasFound.get(c);
			hasFound.put(c, found + 1);

			if (found < needFound.get(c))
				c1++;

			right++;

			if (c1 >= counter)
			{
				// try to move left to right and make sure hasFound keep same.
				c = S.charAt(nexts.get(left));
				while (hasFound.get(c) > needFound.get(c))
				{
					hasFound.put(c, hasFound.get(c) - 1);
					left++;
					c = S.charAt(nexts.get(left));
				}

				if (right - nexts.get(left) < winSize)
				{
					winSize = right - nexts.get(left);
					ret = S.substring(nexts.get(left), right);
				}
			}
		}

		return ret;
	}
}