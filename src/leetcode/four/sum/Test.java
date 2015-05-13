package leetcode.four.sum;

import java.util.List;

public class Test
{
	private static void oneCase(int[] num, int target)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<List<Integer>> sum = s1.fourSum(num, target);
		for (int i = 0; i < sum.size(); i++)
		{
			System.out.println(sum.get(i));
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 1, 0, -1, 0, -2, 2 }, 0);
	}
}
