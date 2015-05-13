package leetcode.rotate.image;

public class Test
{
	private static void oneCase(int[][] matrix)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		s1.rotate(matrix);
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + "\t");

			System.out.println();
		}
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[][]
		{
		{ 1, 2 },
		{ 3, 4 } });

		/**/
		oneCase(new int[][]
		{
		{ 1, 2, 3 },
		{ 4, 5, 6 },
		{ 7, 8, 9 } });

		oneCase(new int[][]
		{
		{ 1, 2, 3, 4 },
		{ 5, 6, 7, 8 },
		{ 9, 10, 11, 12 },
		{ 13, 14, 15, 16 }, });

		oneCase(new int[][]
		{
		{ 1, 2, 3, 4, 5 },
		{ 6, 7, 8, 9, 10 },
		{ 11, 12, 13, 14, 15 },
		{ 16, 17, 18, 19, 20 },
		{ 21, 22, 23, 24, 25 } });
	}
}