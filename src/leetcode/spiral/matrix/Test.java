package leetcode.spiral.matrix;

import java.util.List;

public class Test
{
	private static void oneCase(int[][] matrix)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<Integer> ret = s1.spiralOrder(matrix);
		for (int i = 0; i < ret.size(); i++)
			System.out.print(ret.get(i) + " ");

		System.out.println();
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[][]
		{
		{ 1, 2, 3 } });

		oneCase(new int[][]
		{
		{ 1 },
		{ 4 },
		{ 7 } });

		oneCase(new int[][]
		{
		{ 1, 2, 3 },
		{ 4, 5, 6 },
		{ 7, 8, 9 } });

		oneCase(new int[][]
		{
		{ 1, 2, 3, 4 },
		{ 5, 6, 7, 8 },
		{ 9, 10, 11, 12 } });

		oneCase(new int[][]
		{
		{ 1, 2, 3 },
		{ 4, 5, 6 },
		{ 7, 8, 9 },
		{ 10, 11, 12 } });
	}
}
