package leetcode.longest.palindromic.substring;

public class Test
{

	private static void oneCase(String s)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		System.out.println(sol.longestPalindrome(s));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		/**/
		oneCase("");
		oneCase("A");
		oneCase("bb");		
		oneCase("AAAAAAAAAAAAAAAA"); 
		
		oneCase("abaa");
		oneCase("abba");
		oneCase("cxaabba");
	}
}
