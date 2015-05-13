package epi.strings;

/**
 * Implement a function for reversing the words in a string s. Your function
 * should use O(1) space.
 * 
 */

public class ReverseWords
{
	public static String reverse(String s)
	{
		if (s == null || s.length() < 2)
			return s;

		char[] array = s.toCharArray();

		// reverse whole array.
		reverseArray(array, 0, array.length - 1);

		// reverse each word
		// reverse each word again.
		int cur = 0;
		int last = 0;

		// the string is in the format of "XXXX XXX XXX". If not, better do the
		// pre-handle for that.
		while (cur < array.length)
		{
			while (cur < array.length && array[cur] != ' ')
				cur++;

			if (cur - last > 0)
			{
				reverseArray(array, last, cur - 1);
				last = cur + 1;
				cur++;
			}
		}

		return new String(array);
	}

	private static void reverseArray(char[] array, int a, int b)
	{
		if (array == null || array.length < 2)
			return;

		while (a < b)
		{
			char c = array[a];
			array[a] = array[b];
			array[b] = c;
			a++;
			b--;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(reverse("ram is costly"));
	}
}
