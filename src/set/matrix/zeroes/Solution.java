package set.matrix.zeroes;


/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place
 * 
 * Follow up:
 * 
 * <pre>
 * Did you use extra space? 
 * A straight forward solution using O(mn) space is
 * probably a bad idea. 
 * A simple improvement uses O(m + n) space, but still not
 * the best solution. 
 * Could you devise a constant space solution?
 * </pre>
 * 
 */

public class Solution
{
	public void setZeroes(int[][] matrix)
	{
		// set last 1 lines with all zeros?
		boolean lastToZeros = false;
		boolean currentToZeros = false;

		int size = matrix.length;
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (matrix[i][j] == 0)
				{
					currentToZeros = true;
					// set the 0 to columns
					for (int k = i - 1; k >= 0 ; k--)
						matrix[k][j] = 0;
				}
				else if (i > 0 && matrix[i-1][j] == 0)
				{
					matrix[i][j] = 0;
				}
			}

			// set j - 1 to all zeros
			if (lastToZeros)
			{
				for (int j = 0; j < matrix[0].length; j++)
					matrix[i - 1][j] = 0;
				
				lastToZeros = false;
			}

			if (currentToZeros)
			{
				lastToZeros = true;
				currentToZeros = false;
			}
		}
		
		if (lastToZeros)
		{
			for (int j = 0; j < matrix[0].length; j++)
				matrix[size - 1][j] = 0;			
		}
	}
}