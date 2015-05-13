package roman.integer;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * <pre>
 * Symbol	Value
 * 	I		1
 * 	V		5
 * 	X		10
 * 	L		50
 * 	C		100
 * 	D		500
 * 	M		1,000
 * </pre>
 */

public class Solution1
{
	public int romanToInt(String s)
	{
		if (s == null || s.length() == 0)
			return 0;

		int value = 0;
		int last = 0;

		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			int tmp = trans(c);

			if (last != 0)
			{
				if (tmp > last)
					tmp = tmp - last;
				else if (last != 0)
					value += last;
			}

			last = tmp;
			if (i == s.length() - 1)
				value += last;
		}

		return value;
	}

	private int trans(char c)
	{
		switch (c)
		{
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}

		return 0;
	}
}