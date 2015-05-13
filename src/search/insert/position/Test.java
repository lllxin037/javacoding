package search.insert.position;

public class Test
{
	private static void oneCase(int[] A, int target)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.searchInsert(A, target));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		// [1,3,5,6], 5 -> 2
		// [1,3,5,6], 2 -> 1
		// [1,3,5,6], 7 -> 4
		// [1,3,5,6], 0 -> 0

		oneCase(new int[]
		{ 1, 3, 5, 6 }, 5);
		oneCase(new int[]
		{ 1, 3, 5, 6 }, 2);
		oneCase(new int[]
		{ 1, 3, 5, 6 }, 7);
		oneCase(new int[]
		{ 1, 3, 5, 6 }, 0);

	}
}
