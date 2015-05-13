package leetcode.container.with.most.water;

public class Test
{
	private static void oneCase(int[] A)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.maxArea(A));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 1 });

		oneCase(new int[]
		{ 1, 3 });

		oneCase(new int[]
		{ 1, 5, 1, 1, 1, 5 });

		oneCase(new int[]
		{ 1, 5, 1, 1, 3, 1 });

		oneCase(new int[]
		{ 4, 3, 2, 1 });
		oneCase(new int[]
		{ 1, 2, 3, 4 });
	}
}
