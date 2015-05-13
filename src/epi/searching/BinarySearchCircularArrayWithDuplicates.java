package epi.searching;

import java.util.Arrays;
import java.util.List;

/**

 * 
 */

public class BinarySearchCircularArrayWithDuplicates
{
	public static int searchSmallest(List<Integer> A, int low, int high)
	{
		if (low == high)
			return low;

		int mid = low + ((high - low) >> 1);

		if (A.get(mid) > A.get(high))
			return searchSmallest(A, mid + 1, high);
		else if (A.get(mid) < A.get(high))
			return searchSmallest(A, low, mid);

		// smallest element could be in either left or right side.
		int lowRes = searchSmallest(A, low, mid);
		int highRes = searchSmallest(A, mid + 1, high);
		return (A.get(highRes) < A.get(lowRes) ? highRes : lowRes);

	}

	public static void main(String[] args)
	{
		List<Integer> A = null;

		A = Arrays.asList(new Integer[]
		{ 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 });
		System.out.println("min value index: "
				+ searchSmallest(A, 0, A.size() - 1));

		A = Arrays.asList(new Integer[]
		{ 0, 0, 0, 0, 1, 0, 0, 0 });
		System.out.println("min value index: "
				+ searchSmallest(A, 0, A.size() - 1));

		A = Arrays.asList(new Integer[]
		{ 0, 0, 1, 0, 0, 0, 0, 0 });
		System.out.println("min value index: "
				+ searchSmallest(A, 0, A.size() - 1));
		
	}
}
