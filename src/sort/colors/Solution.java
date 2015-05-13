package sort.colors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 */
public class Solution
{
	public void sortColors(int[] A)
	{
		if (A == null || A.length == 0)
			return;

		int red = -1, white = -1, blue = -1;

		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == 0)
			{
				A[++blue] = 2;
				A[++white] = 1;
				A[++red] = 0;
			}
			else if (A[i] == 1)
			{
				A[++blue] = 2;
				A[++white] = 1;
			}
			else if (A[i] == 2)
			{
				A[++blue] = 2;
			}
		}
	}
}
