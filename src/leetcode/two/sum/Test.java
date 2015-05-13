package leetcode.two.sum;

public class Test
{
	private static void oneCase(int[] numbers, int target)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		int[] sum = s1.twoSum(numbers, target);
		System.out.println(sum[0] + "\t" + sum[1]);

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 2, 7, 11, 15 }, 9);

		oneCase(new int[]
		{ 5, 75, 25 }, 100);
	}
}
