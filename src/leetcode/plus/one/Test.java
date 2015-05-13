package leetcode.plus.one;


public class Test
{
	private static void oneCase(int[] digits)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		int[] ret = s1.plusOne(digits);
		for (int i = 0; i < ret.length; i++)
		{
			System.out.print("[");
			System.out.print(ret[i]);
			System.out.print("]");
		}
		System.out.println();
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(new int[]
		{ 0 });

		oneCase(new int[]
		{ 9 });
		
		oneCase(new int[]
				{ 8 });

	}
}
