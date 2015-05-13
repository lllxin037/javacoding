package leetcode.spiral.matrixII;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * <pre>
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * </pre>
 * 
 */

public class Solution
{
	public int[][] generateMatrix(int n)
	{
		int[][] spiral = new int[n][n];
		
		if (n <= 0)
			return spiral;

		int p = 0;

		for (int level = 0; n > level; ++level, --n)
		{
			int far = n - 1;

			// top row
			for (int i = level; i <= far; ++i)
				spiral[level][i] = ++p;

			if (far == level)
				return spiral;
			// right column (from second to end)
			for (int i = level + 1; i <= far; ++i)
				spiral[i][far] = ++p;

			if (far == level)
				return spiral;

			// bottom row
			for (int i = far - 1; i >= level; --i)
				spiral[far][i] = ++p;

			// left column
			for (int i = far - 1; i > level; --i)
				spiral[i][level] = ++p;
		}
		return spiral;
	}
}