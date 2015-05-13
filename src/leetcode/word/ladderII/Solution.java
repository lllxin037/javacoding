package leetcode.word.ladderII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
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
	private static class Node
	{
		String s;
		int depth;
		Set<Node> lastParents;

		Node(String s, int depth, Set<Node> lastParents)
		{
			this.s = s;
			this.depth = depth;
			this.lastParents = lastParents;
		}
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict)
	{
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		if (start.equals(end))
			return ret;

		if (dict.isEmpty())
			return ret;

		if (start.length() != end.length())
			return ret;

		Queue<Node> nodes = new LinkedList<Node>();
		nodes.offer(new Node(start, 1, Collections.EMPTY_SET));

		// contains strings from 1 to currentDepth -1
		Set<String> visitedNodes = new HashSet<String>();

		Map<String, Set<Node>> depthNodes = new HashMap<String, Set<Node>>();

		int lastDepth = 1;

		Node endNode = null;

		int minLen = -1;
		while (!nodes.isEmpty())
		{
			Node one = nodes.poll();
			int currentDepth = one.depth;

			if (minLen > 0 && currentDepth > minLen)
			{
				depthNodes.clear();
				break;
			}

			// add the 1 to depth - 1 to the set. So, no need to recheck the
			// word that has been done in the previous depth.
			if (currentDepth > lastDepth)
			{
				visitedNodes.addAll(depthNodes.keySet());
				depthNodes.clear();

				lastDepth = currentDepth;
			}

			for (int i = 0; i < one.s.length(); i++)
			{
				char[] array = one.s.toCharArray();

				char existed = array[i];
				for (int j = 'a'; j <= 'z'; j++)
				{
					if (existed == j)
						continue;

					array[i] = (char) j;
					String s = new String(array);

					if (s.equals(end))
					{
						if (minLen < 0)
							minLen = currentDepth + 1;

						if (minLen < currentDepth + 1)
							break;

						Set<Node> parents = depthNodes.get(s);
						if (parents == null)
						{
							parents = new HashSet<Node>();
							depthNodes.put(s, parents);
							
							endNode = new Node(end, currentDepth + 1, parents);
						}
						parents.add(one);
						

						continue;
					}

					if (!dict.contains(s))
						continue;

					if (visitedNodes.contains(s))
						continue;

					Set<Node> parents = depthNodes.get(s);
					if (parents == null)
					{
						parents = new HashSet<Node>();
						depthNodes.put(s, parents);
						nodes.offer(new Node(s, currentDepth + 1, parents));
					}
					parents.add(one);
				}
			}
		}

		if (endNode != null)
		{
			LinkedList<String> p = new LinkedList<String>();
			p.add(endNode.s);
			backtrace(endNode, ret, minLen, start, p);
		}

		return ret;
	}

	private void backtrace(Node endNode, ArrayList<ArrayList<String>> ret,
			int minLen, String start, LinkedList<String> p)
	{
		if (endNode.s.equals(start))
		{
			ret.add(new ArrayList<String>(p));
		}
		
		else if(minLen > 0) {
	        Set<Node> adjs = endNode.lastParents;
	        for(Node lad : adjs){
	            p.addFirst(lad.s);
	            backtrace(lad, ret, minLen-1, start, p);
	            p.removeFirst();
	        }
	    }
	}
}