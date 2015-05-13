package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function which, given two integers (a numerator and a denominator),
 * prints the decimal representation of the rational number
 * "numerator/denominator". Since all rational numbers end with a repeating
 * section, print the repeating section of digits inside parentheses; the
 * decimal printout will be/must be
 * 
 * <pre>
 * Example: 
 * 1 , 3 = 0.(3) 
 * 2 , 4 = 0.5(0) 
 * 22, 7 = 3.(142857)
 * </pre>
 * 
 * etc..
 * 
 */

public class Divide
{
	public static String calculate(int numerator, int denominator)
	{

		int quotient = numerator / denominator;
		int remain = numerator % denominator;

		String prefix = quotient + ".";

		Map<Integer, Integer> visitedRemains = new HashMap<Integer, Integer>();
		int index = 0;

		StringBuilder str = new StringBuilder();
		while (remain != 0)
		{
			if (visitedRemains.containsKey(remain))
				break;

			visitedRemains.put(remain, index);

			quotient = (remain * 10) / denominator;
			remain = (remain * 10) % denominator;

			str.append(quotient);
			index++;
		}

		if (remain != 0)
		{
			index = visitedRemains.get(remain);
			str.insert(index, "(");
			str.append(")");
		}
		else
			str.append("(0)");

		return prefix + str.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(calculate(1, 3));
		System.out.println(calculate(2, 4));
		System.out.println(calculate(22, 7));

		System.out.println(calculate(58, 2828));

		System.out.println(calculate(1, 29));
	}
}
