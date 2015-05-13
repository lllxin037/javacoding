package leetcode.implement.strStr;

public class Test
{
	private static void oneCase(String haystack, String needle)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.strStr(haystack, needle));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase("OURSTRONGXSEARCH", "SEARCH");

		oneCase("aaaabbbababb", "baa");

		oneCase("aaa", "aaa");

		oneCase("LESSONS TEARNED IN SOFTWARE TE", "SOFTWARE");
		
		oneCase("", "");
	}
}
