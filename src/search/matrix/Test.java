package search.matrix;

public class Test
{

	private static void oneCase(int[][] matrix, int target)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.searchMatrix(matrix, target));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[][]
		{
		{} }, 3);

		oneCase(new int[][]
		{
		{ 1, 3, 5, 7 },
		{ 10, 11, 16, 20 },
		{ 23, 30, 34, 50 } }, 3);

		oneCase(new int[][]
		{
		{ 1, 3, 5, 7 },
		{ 10, 11, 16, 20 },
		{ 23, 30, 34, 50 } }, 2);
	}

}
