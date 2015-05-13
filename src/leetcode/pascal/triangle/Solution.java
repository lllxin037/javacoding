package leetcode.pascal.triangle;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * <pre>
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * </pre>
 * 
 */

public class Solution
{
	public ArrayList<ArrayList<Integer>> generate(int numRows)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>( );
		if (numRows == 0)
			return ret;
		
		for (int i = 0; i < numRows; i++)
		{			
			ArrayList<Integer> oneRow = new ArrayList<Integer>();
			ret.add(oneRow);

			ArrayList<Integer> preRow = null;
			if (i > 0)
				preRow = ret.get(i - 1);
			for (int j = 0; j < i + 1; j++)
			{
				if (j == 0 || j == i)
				{
					oneRow.add(Integer.valueOf(1));
					continue;
				}
				
				if ( j < (i/2 + 1) )
					oneRow.add(preRow.get(j-1) + preRow.get(j));
				else 
					oneRow.add(oneRow.get(i - j));
				
			}
		}
		
		return ret;
		
	}
}