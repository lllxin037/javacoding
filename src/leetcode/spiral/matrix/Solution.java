package leetcode.spiral.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * <pre>
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * </pre>
 * 
 */

public class Solution
{
	public List<Integer> spiralOrder(int[][] matrix)
	{
		int m = matrix.length;
		List<Integer> ret = new ArrayList<Integer>();
		if (matrix == null || m == 0)
			return ret;
		int n = matrix[0].length;

		int total = m * n;

		int left = 0, right = n - 1;
		int top = 0, bottom = m - 1;

		while (left <= right || top <= bottom)
		{
			for (int i = left; i <= right; i++)
				ret.add(matrix[top][i]);

			top++;

			if (ret.size() == total)
				break;

			for (int i = top; i <= bottom; i++)
				ret.add(matrix[i][right]);

			right--;

			if (ret.size() == total)
				break;

			for (int i = right; i >= left; i--)
				ret.add(matrix[bottom][i]);

			bottom--;

			if (ret.size() == total)
				break;

			for (int i = bottom; i >= top; i--)
				ret.add(matrix[i][left]);

			left++;

			if (ret.size() == total)
				break;
		}
		return ret;
	}
}