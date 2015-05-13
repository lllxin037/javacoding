package leetcode.minimum.path.sum;


public class Test
{

	private static void oneCase(int[][] grid)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.minPathSum(grid));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[][]{{1, 1, 1}, {3, 2, 2},{1, 5, 1}});
	}
}
