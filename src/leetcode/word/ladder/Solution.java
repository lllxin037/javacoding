package leetcode.word.ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

public class Solution
{
	public int ladderLength(String start, String end, HashSet<String> dict)
	{
		if (start.equals(end))
			return 1;

		if (dict.isEmpty())
			return 0;

		if (start.length() != end.length())
			return 0;
		
		Queue<String> words = new LinkedList<String>();
		Queue<Integer> depth = new LinkedList<Integer>();
		
		Set<String> visited = new HashSet<String>();
		words.add(start);
		depth.add(1);
		visited.add(start);
		
		while (!words.isEmpty())
		{
			String one = words.poll();
			int currentLen = depth.poll();

			for (int i = 0; i < one.length(); i++)
			{
				char[] array = one.toCharArray();
				
				char existed = array[i];
				for (int j = 'a'; j <= 'z'; j++)
				{
					if (existed == j)
						continue;
					
					array[i] = (char) j;
					String s = new String(array);
					
					if (s.equals(end))
						return currentLen + 1;
					
					if (!dict.contains(s))
						continue;
					
					if (visited.contains(s))
						continue;
										
					// insert into the queue
					words.offer(s);
					depth.offer(currentLen + 1);
					visited.add(s);
				}
			}
		}
		
		return 0;
	}
}