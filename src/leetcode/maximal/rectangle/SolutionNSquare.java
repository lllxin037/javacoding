package leetcode.maximal.rectangle;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 */
public class SolutionNSquare
{
	public int maximalRectangle(char[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
			return 0;

		int width = matrix.length;
		int height = matrix[0].length;

		int maxValue = 0;

		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				char c = matrix[i][j];
				if (c == '0')
					continue;

				maxValue = Math.max(maxRect(matrix, i, j), maxValue);
			}
		}

		return maxValue;
	}

	private int maxRect(char[][] matrix, int row, int col)
	{
		int max = 0;
		int minWidth = Integer.MAX_VALUE;
		for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++)
		{
			int j = 0;
			while (col + j < matrix[i].length && matrix[i][col + j] == '1')
				j++;

			minWidth = Math.min(minWidth, j);

			max = Math.max((i - row + 1) * minWidth, max);
		}

		return max;
	}

}