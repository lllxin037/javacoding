package set.matrix.zeroes;

public class Test
{
	private static void oneCase(int[][] matrix)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();
		s1.setZeroes(matrix);

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}

			System.out.println();
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{

		oneCase(new int[][]
		{
		{} });

		oneCase(new int[][]
		{
		{ 1, 2, 0 } });

		oneCase(new int[][]
		{
		{ 1, 2, 1 } });

		oneCase(new int[][]
		{
		{ 1, 3, 5, 7 },
		{ 10, 0, 16, 20 },
		{ 23, 30, 34, 50 } });

		oneCase(new int[][]
		{
		{ 1, 3, 0, 7 },
		{ 10, 11, 16, 20 },
		{ 23, 30, 34, 50 } });

		oneCase(new int[][]
		{
		{ 0, 0, 0, 5 },
		{ 4, 3, 1, 4 },
		{ 0, 1, 1, 4 },
		{ 1, 2, 1, 3 },
		{ 0, 0, 1, 1 } });
	}
}
