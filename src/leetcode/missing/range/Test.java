package leetcode.missing.range;

public class Test
{
	private static void oneCase(int[] vals, int start, int end)
	{
		Solution sol = new Solution();
		System.out.println(sol.findMissingRanges(vals, start, end));
	}

	public static void main(String[] args)
	{

		oneCase(new int[]
		{ 0, 1, 3, 50, 75 }, 0, 99);
	}
}
