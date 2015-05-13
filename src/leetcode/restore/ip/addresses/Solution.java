package leetcode.restore.ip.addresses;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 */

public class Solution
{
	public ArrayList<String> restoreIpAddresses(String s)
	{
		ArrayList<String> ret = new ArrayList<String>();
		if (s.isEmpty())
			return ret;

		ArrayList<Integer> oneResult = new ArrayList<Integer>();
		tryIpAddr(s, oneResult, ret);
		return ret;
	}

	public boolean tryIpAddr(String s, ArrayList<Integer> oneResult,
			ArrayList<String> results)
	{
		if (s.isEmpty())
			return false;

		// check valid len;
		int existing = oneResult.size();
		int minLen = (4 - existing) * 1;
		int maxLen = (4 - existing) * 3;
		if (s.length() < minLen || s.length() > maxLen)
			return false;

		if (s.length() <= 3 && s.length() > 0 && !isMultiDigitsStartWithZero(s))
		{
			int value = Integer.parseInt(s);

			if (value <= 255 && value >= 0)
			{
				if (oneResult.size() == 3)
				{
					results.add(oneResult.get(0) + "." + oneResult.get(1) + "."
							+ oneResult.get(2) + "." + value);
					return true;
				}
			}
		}

		for (int i = 1; i <= Math.min(3, s.length()); i++)
		{
			String str = s.substring(0, i);
			int value = Integer.parseInt(str);
			if (value > 255)
				break;

			if (isMultiDigitsStartWithZero(str))
				break;

			oneResult.add(value);
			tryIpAddr(s.substring(i), oneResult, results);
			oneResult.remove(oneResult.size() - 1);
		}

		return true;
	}

	private boolean isMultiDigitsStartWithZero(String s)
	{
		if (s.length() <= 1)
			return false;

		if (s.length() > 1 && s.charAt(0) == '0')
			return true;

		return false;
	}

}
