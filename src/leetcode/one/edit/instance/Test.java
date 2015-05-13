package leetcode.one.edit.instance;

public class Test
{
	private static void oneCase(String s, String t)
	{
		Solution sol = new Solution();
		System.out.println(sol.isOneEditDistance(s, t));
	}

	public static void main(String[] args)
	{
		oneCase("ab", "ac");		
		oneCase("ab", "acb");
		oneCase("ab", "cab");
		
		oneCase("ab", "ca");
		oneCase("ab", "cc");
		oneCase("ab", "ab");
	}
}
