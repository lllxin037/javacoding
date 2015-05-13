package leetcode.maximum.subarray;

public class Test
{
	private static void oneCase(int[] A)
	{
		System.out.println("#########################");
		DCSolution s1 = new DCSolution();

		System.out.println(s1.maxSubArray(A));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ -2, 1, -3, 4, -1, 2, 1, -5, 4 });

		oneCase(new int[]
		{ -2, 3, -2, 4 });

		oneCase(new int[]
		{ -2, -1 });
	}
}
