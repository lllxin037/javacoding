package substring.concatenation.all.words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * <pre>
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 * </pre>
 * 
 */

public class Solution
{
	public List<Integer> findSubstring(String S, String[] L)
	{
		List<Integer> match = new ArrayList<Integer>();
		if (S.isEmpty() || L == null || L.length == 0)
			return match;

		Map<String, Integer> strCount = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++)
		{
			Integer count = strCount.get(L[i]);
			if (count == null)
				strCount.put(L[i], 1);
			else
				strCount.put(L[i], count + 1);
		}

		int oneLen = L[0].length();
		int n = S.length();

		Map<String, Integer> toMatched = new HashMap<String, Integer>();

		for (int i = 0; i < oneLen; i++)
		{
			int left = i;
			int count = 0;

			toMatched.clear();

			for (int j = left; j <= n - (L.length - count) * oneLen; j += oneLen)
			{
				String str = S.substring(j, j + oneLen);
				Integer expected = strCount.get(str);

				// no match, move windows left and continue;
				if (expected == null)
				{
					left = j + oneLen;
					toMatched.clear();
					count = 0;
					continue;
				}

				Integer meet = toMatched.get(str);
				if (meet == null)
				{
					toMatched.put(str, 1);
					count++;
				}
				else if (meet < expected)
				{
					toMatched.put(str, meet + 1);
					count++;
				}
				else
				{
					// duplicate one. shift the windows until the previous one
					// gone.

					while (meet >= expected)
					{
						String tmp = S.substring(left, left + oneLen);						
						left += oneLen;
						if (tmp.equalsIgnoreCase(str))
							break;
						else
						{
							toMatched.put(tmp, toMatched.get(tmp) - 1);
							count--;
						}
					}
				}

				if (count == L.length)
				{
					match.add(left);
					String tmp = S.substring(left, left + oneLen);
					toMatched.put(tmp, toMatched.get(tmp) - 1);

					left += oneLen;
					count--;
				}
			}

		}

		return match;
	}
}