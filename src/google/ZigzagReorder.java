package google;

import java.util.Arrays;

/**
 * Given an array of positive and negative numbers, arrange them in an alternate
 * fashion such that every positive number is followed by negative and
 * vice-versa maintaining the order of appearance. Number of positive and
 * negative numbers need not be equal. If there are more positive numbers they
 * appear at the end of the array. If there are more negative numbers, they too
 * appear in the end of the array.*
 * 
 * <pre>
 * Example:
 * 
 * 	   Input:  arr[] = {1, 2, 3, -4, -1, 4}
 *     Output: arr[] = {-4, 1, -1, 2, 3, 4}
 *     
 *     Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 *     output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 * Limitations: 
 * a) Use O(1) extra space 
 * b) Time Complexity should be O(N) 
 * c) Maintain the order of appearance of elements as in original array.
 * </pre>
 * 
 * 
 */
public class ZigzagReorder
{
	public static void reorder(int[] arr)
	{
		if (arr == null || arr.length == 0)
			return;

		// assume negative comes first.
		int n = 0;
		int p = 0;

		boolean findPositive = false;

		for (int i = 0; i < arr.length && n < arr.length && p < arr.length; i++)
		{
			if (findPositive)
			{
				while (p < arr.length && arr[p] <= 0)
					p++;
			}
			else
			{
				while (n < arr.length && arr[n] >= 0)
					n++;
			}

			if (n < arr.length && p < arr.length)
			{
				if (findPositive)
				{
					rightRotate(arr, i, p);
					p++;
				}
				else
				{
					rightRotate(arr, i, n);
					n++;
				}

				findPositive = !findPositive;
			}
		}
	}

	private static void rightRotate(int[] arr, int startIndex, int endIndex)
	{
		int tmp = arr[endIndex];
		for (int i = endIndex; i > startIndex; i--)
			arr[i] = arr[i - 1];

		arr[startIndex] = tmp;
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]
		{ 1, 2, 3, -4, -1, 4 };

		reorder(arr);
		System.out.println(Arrays.toString(arr));

		arr = new int[]
		{ -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };

		reorder(arr);
		System.out.println(Arrays.toString(arr));
	}
}
