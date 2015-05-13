package leetcode.zigzag.conversion;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * </pre>
 * 
 */
public class Solution
{
	public String convert(String s, int nRows)
	{
		if (s == null || s.length() == 0)
			return s;

		if (s.length() <= nRows || nRows == 1)
			return s;

		int len = s.length();

		StringBuilder sb = new StringBuilder();
		int b = (nRows << 1) - 2;
		
		for (int row = 0; row < nRows; row++)
		{
			int index = row;
			int a = (nRows - 1 - row) << 1;


			while (index < len)
			{
				sb.append(s.charAt(index));

				// add the one between two columns
				if (row != 0 && row != nRows - 1)
				{
					int tmpIndex = index + a;
					if (tmpIndex < len)
						sb.append(s.charAt(tmpIndex));
				}

				// next possible character, not between two columns
				index = index + b;
			}

		}

		return sb.toString();
	}
}