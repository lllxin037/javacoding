package epi.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Write a function that takes as input a set of words and prints groups of
 * anagrams for those words.
 * 
 */

public class Anagrams
{
	public static List<List<String>> findAnagrams(List<String> dictionary)
	{
		if (dictionary == null || dictionary.isEmpty())
			return new ArrayList<List<String>>();

		Map<String, List<String>> table = new HashMap<String, List<String>>(
				dictionary.size() >> 2);

		for (String word : dictionary)
		{
			char[] arr = word.toCharArray();
			Arrays.sort(arr);
			String sorted = new String(arr);

			List<String> anagrams = table.get(sorted);
			if (anagrams == null)
			{
				anagrams = new ArrayList<String>();
				table.put(sorted, anagrams);
			}

			anagrams.add(word);
		}

		List<List<String>> ret = new ArrayList<List<String>>();
		for (String sorted : table.keySet())
			ret.add(table.get(sorted));

		return ret;
	}

	private static String randString(int len)
	{
		StringBuilder ret = new StringBuilder();
		Random rnd = new Random();

		while (len-- > 0)
		{
			ret.append((char) (rnd.nextInt(26) + 97));
		}
		return ret.toString();
	}

	public static void main(String[] args)
	{
		Random rnd = new Random();
		List<String> dictionary = new ArrayList<String>();
		int n = rnd.nextInt(50000);
		Set<String> table = new HashSet<String>();
		for (int i = 0; i < n; ++i)
		{
			table.add(randString(3));
		}
		for (String s : table)
		{
			dictionary.add(s);
		}
		List<List<String>> anagrams = findAnagrams(dictionary);
		for (List<String> one : anagrams)
			System.out.println(one);

	}
}
