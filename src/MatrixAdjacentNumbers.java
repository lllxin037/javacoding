/**
 * Given a NxN matrix which contains all distinct 1 to n^2 numbers, write code
 * to print sequence of increasing adjacent sequential numbers.
 * 
 * <pre>
 * ex:
 * 1 5 9
 * 2 3 8
 * 4 6 7
 * 
 * should print
 * 6 7 8 9
 * 
 * </pre>
 */

public class MatrixAdjacentNumbers
{
	public static void main(String[] args)
	{
		solution1(new int[][]
		{
		{ 1, 5, 9 },
		{ 2, 3, 8 },
		{ 4, 6, 7 } });
	}

	public static void solution1(int[][] matrix)
	{
		int n = matrix.length;
		int size = n * n;

		// it means value in matrix is adjacent with value+ 1. For example, the
		// value is 1.
		// adjacent[0] means 1 & 2 are neighbors
		boolean[] adjacent = new boolean[size];

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int value = matrix[i][j];
				if (i - 1 >= 0)
				{
					if (value - matrix[i - 1][j] == 1)
						adjacent[matrix[i - 1][j] - 1] = true;
				}
				if (i + 1 < n)
				{
					if (value - matrix[i + 1][j] == 1)
						adjacent[matrix[i + 1][j] - 1] = true;
				}
				if (j - 1 >= 0)
				{
					if (value - matrix[i][j - 1] == 1)
						adjacent[matrix[i][j - 1] - 1] = true;
				}
				if (j + 1 < n)
				{
					if (value - matrix[i][j + 1] == 1)
						adjacent[matrix[i][j + 1] - 1] = true;
				}
			}
		}

		int len = 0, maxLen = 0;
		int begin = 0, maxBegin = 0;
		for (int i = 0; i < adjacent.length; i++)
		{
			if (adjacent[i])
			{
				if (begin == 0)
				{
					begin = i;
					len = 2;
				}
				else
					len++;
			}
			else
			{
				if (len > maxLen)
				{
					maxBegin = begin;
					maxLen = len;
				}
				begin = 0;
			}
		}

		for (int i = 1; i <= maxLen; i++)
		{
			System.out.print((i + maxBegin) + "   ");
		}
	}
}
