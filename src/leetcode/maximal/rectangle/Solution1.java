package leetcode.maximal.rectangle;

import java.util.Stack;

public class Solution1
{
	public int maximalRectangle(char[][] matrix)
	{
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[] onerow = new int[matrix[0].length];
		int max = 0;

		for (int i = 0; i < matrix.length; i++)
			max = Math.max(max, calculateRectangle(matrix[i], onerow));

		return max;
	}

	private int calculateRectangle(char[] matrix, int[] onerow)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			if (matrix[i] == '0')
				onerow[i] = 0;
			else
				onerow[i]++;
		}

		int max = onerow[0];

		Stack<Integer> indices = new Stack<Integer>();
		indices.push(0);

		int cur = 1;
		while (cur <= onerow.length)
		{
			if (indices.isEmpty()
					|| (cur < onerow.length && onerow[cur] >= onerow[indices.peek()]))
				indices.push(cur++);
			else
			{
				int last = indices.pop();
				max = Math.max(max, onerow[last]
						* (indices.isEmpty() ? cur : (cur - indices.peek() - 1)));
			}
		}

		return max;
	}

}
