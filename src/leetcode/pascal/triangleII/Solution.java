package leetcode.pascal.triangleII;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * <pre>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * </pre>
 * 
 */

public class Solution
{
	public ArrayList<Integer> getRow(int rowIndex)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();		
		int[] array = new int[ rowIndex + 1];
		
		ret.add(Integer.valueOf(1));
		if (rowIndex == 0)
		{
			return ret;
		}
		
		for (int i = 1; i < rowIndex + 1; i++)
		{
			for (int j = 0; j < i + 1; j++)
			{
				if (j == 0 || j == i)
				{
					array[j] = 1;
					continue;
				}
				
				if (j < (rowIndex/2 + 1))
					array[j] = ret.get(j-1) + ret.get(j);
				else
					array[j] = array[rowIndex - j];
			}
			
			ret.clear();
			for (int j = 0; j < rowIndex + 1; j++)
			{
				ret.add(Integer.valueOf(array[j]));				
			}
		}
		
		return ret;
	}
}