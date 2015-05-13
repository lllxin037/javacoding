package leetcode.permutations;

import java.util.List;

public class Test
{
	private static void oneCase(int[] num)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<List<Integer>> ret = s1.permute(num);
		for (int i = 0; i < ret.size(); i++)
		{
			List<Integer> items = ret.get(i);
			for (int j = 0; j < items.size(); j++)
			{
				System.out.print(items.get(j) + "\t");
			}
			System.out.println();
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 1 });

		oneCase(new int[]
		{ 1, 2 });

		oneCase(new int[]
		{ 1, 2, 3 });

	}
}
