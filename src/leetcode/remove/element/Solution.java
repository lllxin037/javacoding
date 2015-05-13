package leetcode.remove.element;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 */

public class Solution
{
	public int removeElement(int[] A, int elem)
	{
		if (A == null || A.length == 0)
			return 0;

		int count = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == elem)
			{
				count++;
			}
			else if (count > 0) // copy over non-duplicates
			{
				A[i - count] = A[i];
			}
		}

		return A.length - count;
	}
}