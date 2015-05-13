package leetcode.largest.rectangle.histogram;

public class Test
{
	private static void oneCase(int[] height)
	{
		System.out.println("#########################");
		Solution1 s1 = new Solution1();

		System.out.println(s1.largestRectangleArea(height));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/*oneCase(new int[]
		{});

		oneCase(new int[]
		{ 2 });

		oneCase(new int[]
		{ 0, 9 });*/

		oneCase(new int[]
		{ 2, 1, 2 });

		oneCase(new int[]
		{ 2, 1, 5, 6, 2, 3 });

		oneCase(new int[]
		{ 1, 3, 1, 1 });
	}
}
