package leetcode.longest.common.prefix;

public class Test
{
	private static void oneCase(String[] strs)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.longestCommonPrefix(strs));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new String[]
		{ "c", "a" });

		oneCase(new String[]
		{ "c" });

		oneCase(new String[]
		{ "a", "a", "b" });

	}
}
