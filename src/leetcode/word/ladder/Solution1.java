package leetcode.word.ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1
{
	public int ladderLength(String start, String end, Set<String> dict)
	{
		if (start.length() == 0 && end.length() == 0)
			return 0;

		Queue<Ladder> words = new LinkedList<Ladder>();
		Set<String> visited = new HashSet<String>();
		visited.add(start);
		words.offer(new Ladder(start, 1));

		int n = start.length();
		while (!words.isEmpty())
		{

			Ladder one = words.poll();

			for (int i = 0; i < n; i++)
			{

				char[] arr = one.word.toCharArray();

				for (int j = 'a'; j < 'z'; j++)
				{
					if (j == arr[i])
						continue;

					arr[i] = (char) j;
					String newOne = new String(arr);

					if (newOne.equals(end))
						return one.depth + 1;

					if (!visited.contains(newOne) && dict.contains(newOne))
					{
						words.offer(new Ladder(newOne, one.depth + 1));
						visited.add(newOne);
					}
				}
			}
		}

		return 0;
	}

	static class Ladder
	{
		String word;
		int depth;

		Ladder(String word, int depth)
		{
			this.word = word;
			this.depth = depth;
		}
	}
}
