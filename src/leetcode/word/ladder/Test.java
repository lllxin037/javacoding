package leetcode.word.ladder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test
{
	private static void oneCase(String start, String end, String[] words)
	{
		System.out.println("#########################");
		Solution s = new Solution();
		System.out.println(s.ladderLength(start, end, createDict(words)));
		System.out.println("#########################\n\n");
	}

	private static HashSet<String> createDict(String[] words)
	{
		List<String> list = Arrays.asList(words);
		HashSet<String> dict = new HashSet<String>();
		dict.addAll(list);
		return dict;
	}

	public static void main(String[] args)
	{
		oneCase("a", "c", new String[]
				{ "a", "b", "c"});
		
		oneCase("hit", "cog", new String[]
		{ "hot", "dot", "dog", "lot", "log" });
		oneCase("teach", "place", new String[]
		{ "peale", "wilts", "place", "fetch", "purer", "pooch", "peace",
				"poach", "berra", "teach", "rheum", "peach" });

	}
}
