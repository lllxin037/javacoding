package leetcode.fraction.recurring.decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
	public String fractionToDecimal(int numerator, int denominator)
	{

		// the key is the reminder, the value is the begin index in previous
		// result
		Map<Long, Integer> reminder = new HashMap<Long, Integer>();

		long n = numerator;
		long d = denominator;

		boolean positive = true;
		if (String.valueOf(n).charAt(0) == '-')
			positive = !positive;
		if (String.valueOf(d).charAt(0) == '-')
			positive = !positive;

		StringBuilder sb = new StringBuilder();
		if (!positive)
			sb.append("-");
		
		n = Math.abs(n);
		d = Math.abs(d);
		long quotient = n / d;		
		sb.append(quotient);

		long r = n % d;
		if (r != 0)
			sb.append(".");

		while (r != 0)
		{
			// stops since repeats.
			if (reminder.containsKey(r))
			{
				int index = reminder.get(r);
				sb.insert(index, "(");
				sb.append(")");
				break;
			}

			reminder.put(r, sb.length());

			quotient = r * 10 / d;
			sb.append(quotient);
			r = r * 10 % d;
		}

		return sb.toString();
	}
}
