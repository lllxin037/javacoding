package leetcode.rotate.image;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * <pre>
 * Follow up:
 * Could you do this in-place?
 * </pre>
 * 
 */

public class Solution
{
	public void rotate(int[][] matrix)
	{
		if (matrix == null || matrix.length <= 1)
			return;

		int n = matrix.length;
		for (int level = 0, len = n - 1; level < len; level++, len--)
		{
			for (int i = level; i < len; i++)
			{
				int tail = n - i - 1;

				int tmp = matrix[level][i];

				// left to top
				matrix[level][i] = matrix[tail][level];
				// bottom to left
				matrix[tail][level] = matrix[len][tail];
				// right to bottom
				matrix[len][tail] = matrix[i][len];
				// top to right
				matrix[i][len] = tmp;
			}
		}
	}
}
