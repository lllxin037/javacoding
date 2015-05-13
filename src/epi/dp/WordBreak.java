package epi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak
{
	public static List<String> wordBreaking(String s, Set<String> dict)
	{
		int n = s.length();
		int[] dp = new int[n];

		for (int i = 0; i < n; i++)
		{
			int end = i + 1;
			for (int j = 0; j <= i; j++)
			{
				String sub = s.substring(j, end);
				if (dict.contains(sub) && (j == 0 || dp[j - 1] != 0))
					dp[i] = i - j + 1;
			}
		}

		List<String> words = new ArrayList<String>();
		if (dp[n - 1] != 0)
		{
			int index = n - 1;
			while (index >= 0)
			{
				words.add(s.substring(index - dp[index] + 1, index + 1));
				index = index - dp[index];
			}
			Collections.reverse(words);
		}
		return words;
	}

	private static Set<String> getDict(String[] ss)
	{
		Set<String> ret = new HashSet<String>();
		ret.addAll(Arrays.<String> asList(ss));
		return ret;
	}

	public static void main(String[] args)
	{
		String[] s1 =
		{ "leet", "code" };
		System.out.println(wordBreaking("leetcode", getDict(s1)));

		String[] s2 =
		{ "car", "ca", "rs" };
		System.out.println(wordBreaking("cars", getDict(s2)));

		String[] s3 =
		{ "c", "rs", "ca" };
		System.out.println(wordBreaking("cars", getDict(s3)));

		String[] s4 =
		{ "c", "rs" };
		System.out.println(wordBreaking("cars", getDict(s4)));

	}
}
