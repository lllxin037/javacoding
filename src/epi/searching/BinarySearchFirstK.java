package epi.searching;

import java.util.Arrays;
import java.util.List;

public class BinarySearchFirstK
{
	public static int searchFirst(List<Integer> A, int k)
	{
		if (A == null || A.isEmpty())
			return -1;

		int low = 0;
		int high = A.size() - 1;

		int res = -1;
		while (low <= high)
		{
			int mid = low + ((high - low) >> 1);
			if (A.get(mid) == k)
			{
				res = mid;
				high = mid - 1;
			}
			else if (A.get(mid) < k)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return res;
	}

	public static void main(String[] args)
	{
		List<Integer> A = Arrays.asList(new Integer[]
		{ -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 });

		System.out.println(searchFirst(A, 108));
		System.out.println(searchFirst(A, 285));

		System.out.println(searchFirst(A, 1));
	}
}
