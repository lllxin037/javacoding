package leetcode.next.permutation;

public class Test
{
	private static void oneCase(int[] num)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		s1.nextPermutation(num);
		if (num != null)
		{
			for (int i = 0; i < num.length; i++)
			{
				System.out.print(num[i] + "  ");
			}
		}
		System.out.println();

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(new int[]
		{ 1, 2 });
		oneCase(new int[]
		{ 2, 1 });

		oneCase(new int[]
		{ 1, 2, 3 });
		oneCase(new int[]
		{ 1, 3, 2 });
		oneCase(new int[]
		{ 2, 1, 3 });
		oneCase(new int[]
		{ 2, 3, 1 });
		oneCase(new int[]
		{ 3, 1, 2 });
		oneCase(new int[]
		{ 3, 2, 1 });

		oneCase(new int[]
		{ 1, 1, 5 });

		oneCase(new int[]
		{ 1, 4, 3, 2 });
		oneCase(new int[]
		{ 2, 4, 3, 1 });
		oneCase(new int[]
		{ 1, 2, 4, 3 });

	}
}
