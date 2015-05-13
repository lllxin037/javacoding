package leetcode.maximum.gap;

public class Test
{
	private static void oneCase(int[] A)
	{
		System.out.println("#########################");
		BucketSolution s1 = new BucketSolution();

		System.out.println(s1.maximumGap(A));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{

		oneCase(new int[]
		{ 100, 3, 2, 1 });
		
		oneCase(new int[]
		{ 1, 10000000 });

		oneCase(new int[]
		{ 1, 7, 3, 3 });

		oneCase(new int[]
		{ 3, 6, 9, 1 });

	}
}
