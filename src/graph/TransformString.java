package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import epi.Pair;

public class TransformString
{
	// BFS to find the shortest sequence.

	public static int transformString(Set<String> D, String s, String t)
	{
		if (s.length() != t.length())
			return -1;

		Queue<Pair<String, Integer>> trans = new LinkedList<Pair<String, Integer>>();
		trans.offer(new Pair<String, Integer>(s, 0));

		Set<String> visited = new HashSet<String>();

		// change the character by each position, check whether meets t and in
		// Dictionary.

		int len = s.length();

		// s not need to be in the D.

		while (!trans.isEmpty())
		{
			Pair<String, Integer> p = trans.poll();
			if (p.first.equals(t))
				return p.second;

			visited.add(p.first);

			for (int i = 0; i < len; i++)
			{
				String prefix = (i == 0 ? "" : p.first.substring(0, i));
				String suffix = (i == len - 1 ? "" : p.first.substring(i + 1));
				char c = p.first.charAt(i);
				for (int j = 0; j < 26; j++)
				{
					if (j == c - 'a')
						continue;
					String news = prefix + (char) (j + 'a') + suffix;

					if (!visited.contains(news) && D.contains(news))
						trans.add(new Pair<String, Integer>(news, p.second + 1));
				}
			}
		}

		return -1;
	}

	private static Set<String> createDict(String[] words)
	{
		List<String> list = Arrays.asList(words);
		HashSet<String> dict = new HashSet<String>();
		dict.addAll(list);
		return dict;
	}

	public static void main(String[] args)
	{

		System.out.println(transformString(createDict(new String[]
		{ "hot", "dot", "dog", "lot", "log", "cog" }), "hit", "cog"));

		System.out.println(transformString(createDict(new String[]
		{ "a", "b", "c" }), "a", "c"));

		System.out.println(transformString(createDict(new String[]
		{ "peale", "wilts", "place", "fetch", "purer", "pooch", "peace",
				"poach", "berra", "teach", "rheum", "peach" }), "teach",
				"place"));

	}
}
