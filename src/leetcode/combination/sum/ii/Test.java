package leetcode.combination.sum.ii;

public class Test
{
	private static void oneCase(int[] candidates, int target)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.combinationSum2(candidates, target));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 1 }, 1);

		oneCase(new int[]
		{ 2, 3, 6, 7 }, 7);

		oneCase(new int[]
		{ 10, 1, 2, 7, 6, 1, 5 }, 8);

	}
}
