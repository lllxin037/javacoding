package leetcode.nqueens;

import java.util.List;

public class Test
{
	private static void oneCase(int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<String[]> l = s1.solveNQueens(n);
		for (int i = 0; i < l.size(); i++)
		{
			String[] arr = l.get(i);
			for (int j = 0; j < arr.length; j++)
				System.out.println(arr[j]);
			System.out.println();
		}
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(1);
		oneCase(2);
		oneCase(3);

		oneCase(4);
		oneCase(5);
	}
}
