package leetcode.dungeon.game;

public class Test
{
	private static void oneCase(int[][] dungeon)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.calculateMinimumHP(dungeon));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(new int[][]
		{
		{ -2, -3, 3 },
		{ -5, -10, 1 },
		{ 10, 30, -5 } });

		/**/
		oneCase(new int[][]
		{
		{ -2, -3, 3 },
		{ -2, -10, 1 },
		{ 10, 30, -5 } });
		
	}
}
