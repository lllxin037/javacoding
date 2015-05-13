package leetcode.anagrams;

public class Test
{
	private static void oneCase(String[] strs)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.anagrams(strs));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(new String[]
		{ "cat", "rye" });

		// Output: ["cat","cat","dog","god"]
		oneCase(new String[]
		{ "cat", "rye", "aye", "dog", "god", "cud", "cat", "old", "fop", "bra" });

	}
}
