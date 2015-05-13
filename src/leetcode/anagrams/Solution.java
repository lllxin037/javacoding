package leetcode.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 */

public class Solution
{
	public List<String> anagrams(String[] strs)
	{
		List<String> ret = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return ret;

		Map<String, Integer> tables = new HashMap<String, Integer>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++)
		{
			String one = strs[i];
			String key = generateKey(one);

			Integer value = tables.get(key);
			if (value != null)
			{
				if (value != -1)
				{
					ret.add(strs[value]);
					tables.put(key, Integer.valueOf(-1));
				}
				ret.add(one);
			}
			else
			{
				tables.put(key, Integer.valueOf(i));
			}

			sb.setLength(0);
		}

		return ret;
	}

	private String generateKey(String s)
	{
		int[] hash = new int[26];
		for (int i = 0; i < s.length(); i++)
		{
			int index = s.charAt(i) - 'a';
			hash[index]++;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hash.length; i++)
		{
			if (hash[i] == 0)
				continue;

			sb.append('a' + i);
			sb.append(hash[i]);
		}
		return sb.toString();
	}
}