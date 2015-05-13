package leetcode.max.product.subarray;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * <pre>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * </pre>
 * 
 */

public class Solution
{
	public static int maxProduct(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;

		if (A.length == 1)
			return A[0];
		
		int max = A[0];		
		int pMax = 0; // positive maximum
		int nMin = 0; // negative minimum
		
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] < 0)
			{
				//swap pMax and nMin
				int tmp = pMax;
				pMax = nMin;
				nMin = tmp;
			}
			
			pMax = Math.max(pMax * A[i], A[i]);
			nMin = Math.min(nMin * A[i], A[i]);
			
			max = Math.max(pMax, max);
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(maxProduct(new int[]
		{ 2, 3, -2, 4 }));

		System.out.println(maxProduct(new int[]
		{ 0, 2 }));

		System.out.println(maxProduct(new int[]
		{ 3, -1, 4 }));

		System.out.println(maxProduct(new int[]
		{ -2, 3, -4 }));

		System.out.println(maxProduct(new int[]
		{ 2,-5,-2,-4,3 }));
	}
}
