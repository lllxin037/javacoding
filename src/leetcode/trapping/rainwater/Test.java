package leetcode.trapping.rainwater;

public class Test
{
	private static void oneCase(int[] A)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.trap(A));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 3, 0, 1 });

		/*	*/
		oneCase(new int[]
		{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });

	}
}
