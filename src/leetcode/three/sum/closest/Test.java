package leetcode.three.sum.closest;

public class Test
{
	private static void oneCase(int[] num, int target)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.threeSumClosest(num, target));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{

		oneCase(new int[]
		{ -1, 2, 1, -4 }, 1);

		oneCase(new int[]
		{ 0, 1, 2 }, 0);

		oneCase(new int[]
		{ -3, -2, -5, 3, -4 }, -1);
	}
}
