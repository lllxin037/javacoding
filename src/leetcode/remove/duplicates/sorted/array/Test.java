package leetcode.remove.duplicates.sorted.array;

public class Test
{
	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		int len = s1.removeDuplicates(values);
		System.out.println("len   " + len);

		for (int i = 0; values != null && i < len; i++)
		{
			System.out.print(values[i] + "\t");
		}
		System.out.println();
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(null);
		oneCase(new int[]
		{});

		oneCase(new int[]
		{ 1 });

		oneCase(new int[]
		{ 1, 1, 2 });

		oneCase(new int[]
		{ 1, 2, 2 });

		oneCase(new int[]
		{ 1, 1, 2, 3, 3 });

		oneCase(new int[]
		{ 1, 1, 2, 3, 3, 4, 4, 4, 5, 6 });

	}
}
