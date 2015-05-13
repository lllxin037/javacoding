package reversepolishnotation;

import java.util.Stack;

/**
 * valid operators: +, -, *, /
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 */

public class Solution
{
	public int evalRPN(String[] tokens)
	{
		Stack<Integer> operands = new Stack<Integer>();

		int i = 0;
		while (i < tokens.length)
		{
			String one = tokens[i];
			if (isOperator(one))
			{
				// popup two values and calculate;
				int right = operands.pop().intValue();
				int left = operands.pop().intValue();

				int result = calculate(left, right, one.charAt(0));
				operands.push(Integer.valueOf(result));
			}
			else
			{
				// parse to integer.
				int operand = Integer.parseInt(one);
				operands.push(Integer.valueOf(operand));
			}

			i++;
		}
		
		return operands.pop().intValue();
	}

	private static boolean isOperator(String input)
	{
		return ("+".equals(input) || "-".equals(input) || "*".equals(input) || "/"
				.equals(input));
	}

	private static int calculate(int left, int right, char operator)
	{
		switch (operator)
		{
		case '+':
			return left + right;
		case '-':
			return left - right;
		case '*':
			return left * right;
		case '/':
			return left / right;
		default:
			assert false;
		}

		return Integer.MAX_VALUE;
	}
}