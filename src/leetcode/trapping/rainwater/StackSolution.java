package leetcode.trapping.rainwater;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 */

public class StackSolution
{
	public int trap(int[] A)
	{
		if (A == null || A.length == 0)
			return 0;

		int value = 0;
		int i = 0;

		while (i < A.length && A[i] == 0)
			i++;

		Stack<Integer> index = new Stack<Integer>();

		while (i < A.length)
		{
			while (!index.isEmpty() && A[i] >= A[index.peek()])
			{
				int last = index.pop();
				if (index.isEmpty())
					break;

				value += (i - index.peek() - 1)
						* (Math.min(A[i], A[index.peek()]) - A[last]);
			}

			index.push(i++);
		}

		return value;
	}
}