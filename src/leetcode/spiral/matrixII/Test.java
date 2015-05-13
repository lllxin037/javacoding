package leetcode.spiral.matrixII;

import java.util.List;

public class Test
{
	private static void oneCase(int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		int[][] ret = s1.generateMatrix(n);

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(ret[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(0);
		
		oneCase(1);

		oneCase(3);
		
		oneCase(2);
		oneCase(4);
	}
}
