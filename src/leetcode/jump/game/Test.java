package leetcode.jump.game;

public class Test
{
	private static void oneCase(int[] A)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.canJump(A));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{

		oneCase(new int[]
		{ 0, 1 });

		oneCase(new int[]
		{ 2, 3, 1, 1, 4 });

		oneCase(new int[]
		{ 3, 2, 1, 0, 4 });

		oneCase(new int[]
		{ 0 });

		oneCase(new int[]
		{ 0, 2, 3 });
		
		oneCase(new int[]
		{ 2, 0, 3 });
	}
}
