package leetcode.search.range;

public class Test
{
	private static void oneCase(int[] A, int target)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		int[] range = s1.searchRange(A, target);
		System.out.println("[" + range[0] + ", " + range[1] + "]");

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 5, 7, 7, 8, 8, 10 }, 8);

		oneCase(new int[]
		{ 1 }, 1);

		oneCase(new int[]
		{ 2, 2 }, 2);
	}
}
