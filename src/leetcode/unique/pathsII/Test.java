package leetcode.unique.pathsII;

public class Test
{

	private static void oneCase(int[][] obstacleGrid)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.uniquePathsWithObstacles(obstacleGrid));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[][]
		{
		{ 0, 0, 0 },
		{ 0, 1, 0 },
		{ 0, 0, 0 } });
	}
}
