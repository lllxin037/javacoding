package epi.greedy.invariants;

import java.util.Stack;

/**
 * Let A be an array of n numbers encoding the heights of adjacent buildings of
 * unit width. Design an algorithm to compute the area of the largest rectangle
 * contained in this skyline.
 * 
 */

public class LargestRectangle
{
	/**
	 * http://www.cnblogs.com/lichen782/p/
	 * leetcode_Largest_Rectangle_in_Histogram.html
	 * 
	 * @param A
	 * @return
	 */

	public static int calculate(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;

		int maxRect = 0;

		// save the indices.
		Stack<Integer> indices = new Stack<Integer>();
		for (int i = 0; i <= A.length; i++)
		{
			while (!indices.isEmpty()
					&& (i == A.length || A[i] < A[indices.peek()]))
			{
				int lastIndex = indices.pop();
				int height = A[lastIndex];
				maxRect = Math.max(maxRect, height
						* (indices.isEmpty() ? i : (i - indices.peek() - 1)));
			}

			indices.add(i);
		}
		return maxRect;
	}

	public static void main(String[] args)
	{
		System.out.println(calculate(new int[]
		{ 2, 1, 5, 6, 2, 3 }));

		System.out.println(calculate(new int[]
		{ 1, 3, 1, 1 }));
	}
}
