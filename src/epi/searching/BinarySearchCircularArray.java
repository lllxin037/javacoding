package epi.searching;

import java.util.Arrays;
import java.util.List;

/**
 * Design an O(log n) algorithm for finding the position of the smallest element
 * in a cyclically sorted array. Assume all elements are distinct. For example,
 * for the array in Figure 12.2 on the next page, your algorithm should return
 * 4.
 * 
 */

public class BinarySearchCircularArray
{
	public static int searchSmallest(List<Integer> A)
	{
		if (A == null || A.isEmpty())
			return -1;

		int low = 0, high = A.size() - 1;

		while (low < high)
		{
			int mid = low + ((high - low) >> 1);

			// if A.mid > A.high, lowest value in the mid.. high
			if (A.get(mid) > A.get(high))
				low = mid + 1;
			else
				high = mid;
		}

		return low;
	}

	public static void main(String[] args)
	{
		List<Integer> A = Arrays.asList(new Integer[]
		{ 103, 203, 220, 234, 279, 368, 378, 478, 550, 631 });

		System.out.println("min value index: " + searchSmallest(A));

		A = Arrays.asList(new Integer[]
		{ 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 });
		System.out.println("min value index: " + searchSmallest(A));

		A = Arrays.asList(new Integer[]
		{ 220, 234, 279, 368, 378, 478, 550, 631, 103, 203 });
		System.out.println("min value index: " + searchSmallest(A));

		A = Arrays.asList(new Integer[]
		{ 550, 631, 103, 203, 220, 234, 279, 368, 378, 478 });
		System.out.println("min value index: " + searchSmallest(A));

		A = Arrays.asList(new Integer[]
		{ 203, 220, 234, 279, 368, 378, 478, 550, 631, 103 });
		System.out.println("min value index: " + searchSmallest(A));
	}
}
