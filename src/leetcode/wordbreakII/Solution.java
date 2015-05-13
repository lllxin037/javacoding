package leetcode.wordbreakII;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *  Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * </pre>
 * 
 */

public class Solution
{
	public ArrayList<String> wordBreak(String s, Set<String> dict)
	{
		// try with DP.

		int len = s.length();

		ArrayList<String> ret = new ArrayList<String>();

		// for each object, it could be another array or list.
		List<List<Integer>> dp = new ArrayList<List<Integer>>(len);

		for (int i = 0; i < len; i++)
		{
			dp.add(null);
		}

		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < i + 1; j++)
			{
				int endIndex = i + 1;
				String s1 = s.substring(j, endIndex);
				if (dict.contains(s1) && (j - 1 < 0 || dp.get(j - 1) != null))
				{
					List<Integer> obj = dp.get(i);
					List<Integer> lastIndex = null;
					if (obj == null)
					{
						lastIndex = new ArrayList<Integer>();
						dp.set(i, lastIndex);
					}
					else
						lastIndex = obj;

					lastIndex.add(Integer.valueOf(j - 1));
				}
			}
		}

		collect(dp, len - 1, s, "", ret);
		return ret;
	}

	private void collect(List<List<Integer>> dp, int startIndex, String s,
			String s1, List<String> ret)
	{
		List<Integer> lastIndex = dp.get(startIndex);

		if (lastIndex == null)
			return;

		for (int i = 0; i < lastIndex.size(); i++)
		{
			int oneLast = lastIndex.get(i);
			if (oneLast == -1)
			{
				// reach the beginning of the string
				String tmp = s.substring(0, startIndex + 1);
				if (!s1.isEmpty())
					tmp = tmp + " " + s1;
				ret.add(tmp);
			}
			else
			{
				String tmp = s.substring(oneLast + 1, startIndex + 1);
				if (!s1.isEmpty())
					tmp = tmp + " " + s1;

				collect(dp, oneLast, s, tmp, ret);
			}
		}

	}
}
