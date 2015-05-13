package leetcode.roman.integer;

/**
 * /** Given a roman numeral, convert it to an integer.
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
 * 
 * 
 */

public class Solution2 {

	public int romanToInt(String s) {

		if (s == null || s.isEmpty())
			return 0;

		int val = 0;

		for (int i = 0; i < s.length(); i++) {

			int cur = trans(s.charAt(i));
			int last = (i == 0 ? 0 : trans(s.charAt(i - 1)));

			if (i > 0 && last < cur) {
				val += cur - (last << 1);
			}
			else
				val += cur;
		}

		return val;
	}

	private int trans(char c) {

		int val = 0;
		switch (c)
		{
		case 'I':
			val = 1;
			break;
		case 'V':
			val = 5;
			break;
		case 'X':
			val = 10;
			break;
		case 'L':
			val = 50;
			break;
		case 'C':
			val = 100;
			break;
		case 'D':
			val = 500;
			break;
		case 'M':
			val = 1000;
			break;
		}
		return val;
	}
}
