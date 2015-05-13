package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a number M (N-digit integer) and K-swap operations(a swap operation can
 * swap 2 digits), devise an algorithm to get the maximum possible integer?
 * 
 * <pre>
 * Examples: 
 * M = 132 K = 1 output = 312 
 * M = 132 K = 2 output = 321 
 * M = 7899 k = 2 output = 9987 
 * M = 8799 and K = 2 output = 9987
 * </pre>
 * 
 */

public class SwapToMax
{
	private void getMax(List<Integer> input, int k, int[] maxNum, List<Integer> output)
	{
		if (k == 0)
		{
			int sum = 0;
			for (int v : input)
			{
				sum *= 10;
				sum += v;
			}// calculate the number after several swaps
			if (sum > maxNum[0])
			{
				maxNum[0] = sum;
				output.clear();
				output.addAll(input);
			}// update the results
			return;
		}

		for (int i = 0; i < input.size() - 1; i++)
		{
			for (int j = i + 1; j < input.size(); j++)
			{
				Collections.swap(input, i, j);// try to swap input[i] with
												// input[j]
				getMax(input, k - 1, maxNum, output);// takecare of the other k
														// - 1 swaps
				Collections.swap(input, i, j);// swap back
			}
		}
		return;
	}

	void swap2max(List<Integer> input, int k)
	{
		if (input.size() < 2)
		{
			System.out.println("invalid input");
		}

		List<Integer> maxVec = new ArrayList<Integer>();
		int[] maxNum = new int[1];
		maxNum[0] = Integer.MIN_VALUE;
		getMax(input, k, maxNum, maxVec);// DFS function to call

		// print out the results here
		System.out.print("{ ");
		for (int i = 0; i < maxVec.size(); i++)
		{
			System.out.print(maxVec.get(i) + " ");
		}
		System.out.println(" }");
		return;
	}

	public static void main(String[] args)
	{
		SwapToMax s = new SwapToMax();
		s.swap2max(Arrays.asList(1, 3, 2), 1);

		s.swap2max(Arrays.asList(1, 3, 2), 2);
		s.swap2max(Arrays.asList(7, 8, 9, 9), 2);

		s.swap2max(Arrays.asList(8, 7, 9, 9), 2);

		s.swap2max(Arrays.asList(8, 7, 6, 9, 5, 9), 3);
	}
}
