package search.matrix;

/**
 * Write an efficient algorithm that searches for a value in an m * n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * <pre>
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * </pre>
 * 
 * Given target = 3, return true.
 * 
 */

public class Solution
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		int lo = 0;
		int hi = matrix.length - 1;

		int width = matrix[0].length;
		if (width == 0)
			return false;

		while (lo <= hi)
		{
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (target < matrix[mid][0])
				hi = mid - 1;
			else if (target > matrix[mid][width - 1])
				lo = mid + 1;
			else
			{
				int i = mid;
				// another binary search in the matrix[mid]
				lo = 0;
				hi = width - 1;

				while (lo <= hi)
				{
					mid = lo + (hi - lo) / 2;

					if (target < matrix[i][mid])
						hi = mid - 1;
					else if (target > matrix[i][mid])
						lo = mid + 1;
					else
						return true;
				}
				break;
			}
		}
		return false;
	}
}