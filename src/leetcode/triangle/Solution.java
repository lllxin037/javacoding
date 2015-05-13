package leetcode.triangle;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * <pre>
 * For example, given the following triangle
 * 
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * </pre>
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 */

public class Solution
{
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle)
	{
		int rows = triangle.size();
		if (rows == 0)
			return 0;

		int cols = triangle.get(rows - 1).size();
		int[] minTotal = new int[cols];

		ArrayList<Integer> row = triangle.get(rows - 1);
		for (int i = 0; i < minTotal.length; i++)
		{
			minTotal[i] = row.get(i);
		}

		for (int i = rows - 2; i >= 0; i--)
		{
			// current row
			row = triangle.get(i);

			for (int j = 0; j < row.size(); j++)
			{
				minTotal[j] = Math.min(row.get(j) + minTotal[j], row.get(j)
						+ minTotal[j + 1]);
			}

		}

		return minTotal[0];
	}
}