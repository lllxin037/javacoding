package leetcode.maximal.rectangle;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 */
public class Solution
{
	public int maximalRectangle(char[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
			return 0;

		int[] oneRow = new int[matrix[0].length];

		int maxValue = 0;

		for (int i = 0; i < matrix.length; i++)
		{
			maxValue = Math.max(maxValue, maxRect(matrix[i], oneRow));
		}

		return maxValue;
	}

	private int maxRect(char[] matrixRow, int[] oneRow)
	{
		for (int i = 0; i < oneRow.length; i++)
		{
			if (matrixRow[i] == '1')
				oneRow[i]++;
			else
				oneRow[i] = 0;
		}

		int max = 0;

		Stack<Integer> tmp = new Stack<Integer>();
		tmp.push(0);

		int cur = 1;
		while (cur <= oneRow.length)
		{
			if (tmp.isEmpty()
					|| (cur < oneRow.length && oneRow[cur] >= oneRow[tmp.peek()]))
			{
				tmp.push(cur++);
			}
			else
			{
				int tmpValue = tmp.pop();
				max = Math.max(max, oneRow[tmpValue]
						* ((tmp.isEmpty() ? cur : (cur - tmp.peek() - 1))));
			}
		}

		return max;
	}

}