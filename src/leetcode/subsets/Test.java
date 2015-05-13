package leetcode.subsets;

import java.util.ArrayList;

public class Test
{
	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ArrayList<ArrayList<Integer>> ret = s1.subsets(values);
		for (int i = 0; i < ret.size(); i++)
		{
			System.out.println(ret.get(i));
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(null);
		oneCase(new int[]{});
		
		oneCase(new int[]{1});
		oneCase(new int[]{1,3});
		
		oneCase(new int[]{1,2,3});
	}
}
