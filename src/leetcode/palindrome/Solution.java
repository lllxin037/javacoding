package leetcode.palindrome;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * <pre>
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 * </pre>
 * 
 */

public class Solution
{
	public ArrayList<ArrayList<String>> partition(String s)
	{
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		ArrayList<String> singleRet = new ArrayList<String>();

		boolean[][] dpvalues = new boolean[s.length()][s.length()];
		DFS(s, 0, ret, singleRet, dpvalues);
		return ret;
	}

	private void DFS(String s, int index, ArrayList<ArrayList<String>> results,
			ArrayList<String> singleRet, boolean[][] dpvalues)
	{
		if (index == s.length())
		{
			ArrayList<String> tmpRet = new ArrayList<String>();
			tmpRet.addAll(singleRet);
			
			results.add(tmpRet);
			return;
		}

		for (int i = index; i < s.length(); i++)
		{
			if (isPalindrome(s, index, i, dpvalues))
			{
				singleRet.add(s.substring(index, i + 1));
				DFS(s, i + 1, results, singleRet, dpvalues);
				singleRet.remove(singleRet.size() -1);
			}
		}
	}

	private boolean isPalindrome(String toTest, int start, int end,
			boolean[][] dpvalues)
	{

		if (toTest.charAt(start) == toTest.charAt(end) )
		{
			if (end - start > 1)
				dpvalues[start][end] = isPalindrome(toTest, start + 1, end - 1,
						dpvalues);
			else
				dpvalues[start][end] = true;
		}
		else
			dpvalues[start][end] = false;

		return dpvalues[start][end];
	}
}
