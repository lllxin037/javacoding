package leetcode.merge.sorted.array;

public class Test
{
	private static void oneCase(int A[], int m, int B[], int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		s1.merge(A, m, B, n);
		System.out.print("");
		for (int i = 0; i < m + n; i++)
		{
			System.out.print(A[i] + "    ");
		}

		System.out.print("\n");

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 0, 0 }, 0, new int[]
		{ 1 }, 1);

		oneCase(new int[]
		{ 2, 4, 0, 0 }, 2, new int[]
		{ 1, 3 }, 2);

		oneCase(new int[]
		{ 2, 4, 0, 0, 0 }, 2, new int[]
		{ 1, 3, 5 }, 3);

		oneCase(new int[]
		{ 1, 3, 5, 0, 0 }, 3, new int[]
		{ 2, 4 }, 2);
	}
}
