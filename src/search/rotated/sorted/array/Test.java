package search.rotated.sorted.array;

public class Test
{
	private static void oneCase(int[] values, int v)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.search(values, v));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/oneCase(null, 1);
		oneCase(new int[]
		{}, 1);

		oneCase(new int[]
		{ 3, 1 }, 1);

		oneCase(new int[]
		{ 4, 5, 6, 7, 0, 1, 2 }, 7);

		oneCase(new int[]
		{ 5, 6, 1, 2, 3, 4 }, 6);

		oneCase(new int[]
		{ 4, 5, 6, 7, 8, 1, 2, 3 }, 8);

		oneCase(new int[]
		{ 5, 1, 3 }, 3);

		oneCase(new int[]
		{ 3, 5, 1 }, 1);

		oneCase(new int[]
		{ 3, 5, 1 }, 3);

		oneCase(new int[]
		{ 5, 1, 2, 3, 4 }, 1);

	}
}
