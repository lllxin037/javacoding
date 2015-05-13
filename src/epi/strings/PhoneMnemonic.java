package epi.strings;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */

public class PhoneMnemonic
{
	private static final String[] MAPPING = new String[]
	{ "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	public static List<String> phoneMnemonic(String num)
	{
		if (num == null || num.length() == 0)
			return Collections.<String> emptyList();

		LinkedList<String> mnemonic = new LinkedList<String>();

		// special handling for 1st one.
		int digit = num.charAt(0) - '0';
		if (digit < 0 || digit > 9)
			throw new IllegalArgumentException();

		for (char c : MAPPING[digit].toCharArray())
			mnemonic.offer(String.valueOf(c));

		for (int i = 1; i < num.length(); i++)
		{
			digit = num.charAt(i) - '0';
			if (digit < 0 || digit > 9)
				throw new IllegalArgumentException();

			while (i + 1 > mnemonic.peek().length())
			{
				String s = mnemonic.poll();
				for (char c : MAPPING[digit].toCharArray())
					mnemonic.offer(s + c);
			}
		}

		return mnemonic;
	}

	public static void main(String[] args)
	{
		System.out.println(phoneMnemonic("89"));
		System.out.println(phoneMnemonic("223"));
	}
}
