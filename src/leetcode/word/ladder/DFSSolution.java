package leetcode.word.ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary
 * 
 * <pre>
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * 
 *     Return 0 if there is no such transformation sequence.
 *     All words have the same length.
 *     All words contain only lowercase alphabetic characters.
 * </pre>
 * 
 */

public class DFSSolution
{
	public int ladderLength(String start, String end, HashSet<String> dict)
	{
		if (start.equals(end))
			return 1;

		if (dict.isEmpty())
			return 0;

		ArrayList<String> oneResult = new ArrayList<String>();
		List<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		
		oneResult.add(start);
		
		DFS(start, end, dict, results, oneResult);
		
		return 0;
	}

	public void DFS(String start, String end, HashSet<String> dict,
			List<ArrayList<String>> results, ArrayList<String> oneResult)
	{
		Iterator<String> words = dict.iterator();

		while (words.hasNext())
		{
			String one = (String) words.next();
						
			if (difference(one, start) == 1)
			{
				oneResult.add(one);
				
				if (difference(one, end) == 1)
				{
					ArrayList<String> tmp = new ArrayList<String>();
					tmp.addAll(oneResult);
					tmp.add(end);
					
					results.add(tmp);
					System.out.println(tmp);
				}

				HashSet<String> newDict = new HashSet<String>();
				newDict.addAll(dict);
				newDict.remove(one);

				DFS(one, end, newDict, results, oneResult);
				
				oneResult.remove(one);
			}
		}
	}

	private int difference(String s1, String s2)
	{
		int len = s1.length();
		int ret = 0;

		for (int i = 0; i < len; i++)
		{
			if (s1.charAt(i) - s2.charAt(i) != 0)
				ret++;
		}

		return ret;
	}
}