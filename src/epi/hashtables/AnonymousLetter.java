package epi.hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * You are required to write a method which takes an anonymous letter L and text
 * from a magazine M. Your method is to return true if and only if L can be
 * written using M, i.e., if a letter appears k times in L, it must appear at
 * least k times in M.
 * 
 */

public class AnonymousLetter
{
	/**
	 * Only consider letters in upper (65 - 90 ) or lower case (97-122 ).
	 * 
	 * @param L
	 * @param M
	 * @return
	 */

	public static boolean testAnonymousLetter(String L, String M)
	{
		// first lower, then upper
		int[] counter = new int[52];
		for (char c : L.toCharArray())
		{
			int offset = c - 'A';
			if (c > 90)
				offset = c - 'a' + 26;

			counter[offset]++;
		}

		for (char c : M.toCharArray())
		{
			int offset = c - 'A';
			if (c > 90)
				offset = c - 'a' + 26;

			counter[offset]--;
		}

		for (int i = 0; i < counter.length; i++)
		{
			if (counter[i] > 0)
				return false;
		}

		return true;
	}

	public static boolean testAnonymousLetterMap(String L, String M)
	{
		Map<Character, Integer> counter = new HashMap<Character, Integer>();

		for (char c : L.toCharArray())
		{
			if (counter.containsKey(c))
				counter.put(c, counter.get(c) + 1);
			else
				counter.put(c, 1);
		}

		for (char c : M.toCharArray())
		{
			Integer v = counter.get(c);
			if (v == null)
				continue;

			if (v == 1)
				counter.remove(c);
			else
				counter.put(c, v - 1);

			if (counter.isEmpty())
				return true;
		}

		return counter.isEmpty();
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
		String L = null;
		String M = null;

		Random rnd = new Random();
		L = randString(rnd.nextInt(10) + 1);
		M = randString(rnd.nextInt(100) + 1);

		System.out.println(L);
		System.out.println(M);

		System.out.println(testAnonymousLetterMap(L, M));
	}
}
