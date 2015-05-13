package leetcode.first.missing.positive;

public class Test
{
	private static void oneCase(int[] A)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.firstMissingPositive(A));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 2 });

		oneCase(new int[]
		{ 1, 2, 0 });

		/*	*/
		oneCase(new int[]
		{ 3, 4, -1, 1 });

		oneCase(new int[]
		{ 1, 1 });

	}
}
