/**
 * Write a function that performs base conversion. Specifically, the input is an
 * integer base b1, a string s, representing an integer x in base b1, and
 * another integer base b2; the output is the string representing the integer x
 * in base b2.
 * 
 * Assume 2 ¡Ü b1, b2 ¡Ü 16. Use ¡°A¡± to represent 10, ¡°B¡± for 11, . . . , and ¡°F¡±
 * for 15.
 * 
 */

public class ConvertBase
{
	public static String compute(int b1, String s, int b2)
	{
		if (s == null || s.length() == 0)
			return s;

		boolean negative = false;
		if (s.charAt(0) == '-')
			negative = true;

		// assume positive
		int value = 0;
		for (int i = (negative ? 1 : 0); i < s.length(); i++)
		{
			value = value * b1;
			int one = s.charAt(i);
			if (one >= 'A' && one <= 'F')
				one = one - 'A' + 10;
			else
				one = one - '0';
			value = value + one;
		}

		StringBuilder sb = new StringBuilder();
		while (value > 0)
		{
			int one = value % b2;
			if (one >= 10)
				one = one - 10 + 'A';
			else
				one = one + '0';
			sb.append((char) one);

			value = value / b2;
		}

		return (negative ? '-' : "") + sb.reverse().toString();
	}

	public static void main(String[] args)
	{
		System.out.println(compute(10, "100", 16));
		System.out.println(compute(10, "100", 2));
	}
}
