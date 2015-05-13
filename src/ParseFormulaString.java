import java.util.Stack;

/**
 * Parse a formula string (only contains "+-()", no "*"/).
 * 
 * <pre>
 * For example,
 * 5 + 2x - ( 3y + 2x - ( 7 - 2x) - 9 ) = 3 + 4y
 * Parse this string, with a given float of 'x' value, output a float for 'y' value.
 * 
 </pre>
 */

public class ParseFormulaString
{
	public double evaluate(String f, double x_val)
	{
		int sum_x_left = 0, sum_y_left = 0, sum_left = 0;
		int sum_x_right = 0, sum_y_right = 0, sum_right = 0;
		int cur_sum_x = 0, cur_sum_y = 0, cur_sum = 0;

		// 1 means add, -1 means minus.
		int lastOp = 1, bracketOp = 1;
		Stack<Integer> stack = new Stack<Integer>();

		int len = f.length();
		int cur = 0;
		while (cur <= len)
		{
			if (cur == len)
			{
				sum_x_right = cur_sum_x;
				sum_y_right = cur_sum_y;
				sum_right = cur_sum;
				break;
			}

			char c = f.charAt(cur);
			if (c >= '0' && c <= '9')
			{
				int next = cur + 1;
				while (next < len && f.charAt(next) >= '0'
						&& f.charAt(next) <= '9')
					next++;

				int val = Integer.valueOf(f.substring(cur, next))
						* getCurrentOp(stack, lastOp, bracketOp);

				cur = next;
				if (next < len)
				{
					switch (f.charAt(next))
					{
					case 'x':
						// calculate cur_sum_x
						cur_sum_x += val;
						cur++;
						break;
					case 'y':
						// calculate cur_sum_y
						cur_sum_y += val;
						cur++;
						break;
					default:
						cur_sum += val;
						break;
					}
				}
				else
				{
					cur_sum += val;
				}
			}
			else if (c == ' ')
			{
				cur++;
				continue;
			}
			else if (c == '=')
			{
				sum_x_left = cur_sum_x;
				sum_y_left = cur_sum_y;
				sum_left = cur_sum;

				cur_sum_x = 0;
				cur_sum_y = 0;
				cur_sum = 0;

				stack.clear();
				lastOp = 1;

				cur++;
			}
			else if (c == '+' || c == '-')
			{
				lastOp = (c == '+' ? 1 : -1);
				cur++;
			}
			else if (c == '(')
			{
				stack.push(lastOp);
				bracketOp *= lastOp;
				lastOp = 1;

				cur++;
			}
			else if (c == ')')
			{
				bracketOp *= stack.pop();
				cur++;
			}
			else if (c == 'x')
			{
				cur_sum_x += getCurrentOp(stack, lastOp, bracketOp);
				cur++;
			}
			else if (c == 'y')
			{
				cur_sum_y += getCurrentOp(stack, lastOp, bracketOp);
				cur++;
			}
		}

		return (-(sum_left - sum_right) - (sum_x_left - sum_x_right) * x_val)
				/ (sum_y_left - sum_y_right);
	}

	private int getCurrentOp(Stack<Integer> bracketOps, int lastOp,
			int bracketOp)
	{
		if (bracketOps.isEmpty())
			return lastOp;

		return bracketOp * lastOp;
	}

	public static void main(String[] args)
	{
		ParseFormulaString solution = new ParseFormulaString();

		// 4
		// 2
		// -5.5
		// 30
		// 23

		System.out.println(solution.evaluate(
				"x - (y - (5 + 3y)) = 3y + 2x - 1", 2));
		System.out.println(solution.evaluate(
				"5 + 2x - ( 3y + 2x - ( 7 - 2x) - 9 ) = 3 + 4y", 2));		
		System.out.println(solution.evaluate("2y-(y+5)=3y+6", 2));
		System.out.println(solution.evaluate("10x + y = 2y - 10", 2));
		System.out.println(solution.evaluate("x + 5 + y = 2y - 3x - 10", 2));
	}
}
