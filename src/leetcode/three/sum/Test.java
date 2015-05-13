package leetcode.three.sum;

import java.util.List;

public class Test
{
	private static void oneCase(int[] num)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<List<Integer>> sum = s1.threeSum(num);
		for (int i = 0; i < sum.size(); i++)
		{
			System.out.println(sum.get(i));
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/*
		 * oneCase(new int[] { -1, 0, 1 });
		 * 
		 * oneCase(new int[] { -1, -1, 2 });
		 * 
		 * oneCase(new int[] { -1, 0, 1, 2, -1, -4 });
		 */
		oneCase(new int[]
		{ 0, 0, 0, 0 });

		oneCase(new int[]
		{ -2, 0, 1, 1, 2 });

	}
}
