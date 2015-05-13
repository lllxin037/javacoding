import java.util.Arrays;

/**
 * Write a function that takes an array A of length n and an index i into A, and
 * rearranges the elements such that all elements less than A[i] appear first,
 * followed by elements equal to A[i], followed by elements greater than A[i].
 * Your algorithm should have O(1) space complexity and O(n) time complexity.
 * 
 */

public class DutchNationalFlagProblem
{
	public static void sort(int[] A, int i)
	{
		if (A == null || A.length <= 1)
			return;
		if (i < 0 || i >= A.length)
			return;

		// find the number of values larger than A[i], less than A[i] and equal
		// to A[i]
		int largerNo = 0;
		int lessNo = 0;
		int equalsNo = 0;

		int pivot = A[i];
		for (int one : A)
		{
			if (one > pivot)
				largerNo++;
			else if (one < pivot)
				lessNo++;
			else
				equalsNo++;
		}

		// less numbers between 0 and lessNo - 1
		// pivot should be in lessNo to lessNo + equalsNo - 1
		// larger numbers in lessNo + equalsNo to A.length - 1

		int index = lessNo;
		for (int j = 0; j < A.length; j++)
		{
			int one = A[j];
			if (one == pivot)
				swap(A, index++, j);
		}

		largerNo = lessNo + equalsNo;
		for (int j = 0; j < lessNo; j++)
		{
			int one = A[j];
			if (one > pivot)
			{
				while (A[largerNo] > pivot)
					largerNo++;
				swap(A, largerNo++, j);
			}
		}
	}

	private static void swap(int[] A, int i, int j)
	{
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void sortBest(int[] A, int i)
	{
		if (A == null || A.length <= 1)
			return;
		if (i < 0 || i >= A.length)
			return;

		int less = 0, equals = 0, larger = A.length - 1;
		int pivot = A[i];

		while (equals < larger)
		{
			if (A[equals] < pivot)
				swap(A, less++, equals++);
			else if (A[equals] == pivot)
				equals++;
			else
				swap(A, equals, larger--);
		}
	}

	public static void main(String[] args)
	{
		int[] A = null;

		A = new int[]
		{ 7, 10, 8, 9, 4, 3, 1, 12 };
		sortBest(A, 4);
		System.out.println(Arrays.toString(A));

		A = new int[]
		{ 7, 10, 8, 9, 4, 3, 1, 2 };
		sortBest(A, 4);
		System.out.println(Arrays.toString(A));

		A = new int[]
		{ 1, 10, 8, 9, 4, 3, 4, 2 };
		sortBest(A, 4);
		System.out.println(Arrays.toString(A));
	}
}
