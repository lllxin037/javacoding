package leetcode.maximum.subarray;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * <pre>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * </pre>
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 */

public class Solution
{
	public int maxSubArray(int[] A)
	{
        if (A == null || A.length == 0)
            return 0;

        int max =  A[0];
        int currentMax = max;
        
        for (int i = 1; i < A.length; i++ )
        {
            currentMax = Math.max(A[i], currentMax + A[i]);
            max = Math.max(currentMax, max);
        }
        
        return max;
	}
}