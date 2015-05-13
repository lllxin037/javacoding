package leetcode.regular.expression.matching;

public class Test
{
	private static void oneCase(String s, String p)
	{
		System.out.println("#########################");
		Solution1 s1 = new Solution1();

		System.out.println(s1.isMatch(s, p));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		// isMatch("aa","a") -> false
		// isMatch("aa","aa") -> true
		// isMatch("aaa","aa") -> false
		// isMatch("aa", "a*") -> true
		// isMatch("aa", ".*") -> true
		// isMatch("ab", ".*") -> true
		// isMatch("aab", "c*a*b") -> true

		System.out.println("***************TRUE***************");
		/**/
		oneCase("aa", "aa");
		oneCase("c", ".*");
		oneCase("", ".*");
		oneCase("", "a*");
		oneCase("aa", ".*");
		oneCase("aa", "a*");
		oneCase("ab", ".*");
		oneCase("abb", "ab*");
		oneCase("aba", ".*a.*");
		oneCase("aaa", "a*a");
		
		oneCase("aab", "c*a*b");
		oneCase("aaa", "ab*a*c*a");		
		
		System.out.println("***************FALSE***************");
		oneCase("aa", "a");
		oneCase("", ".");
		oneCase("aaa", "aa");

		oneCase("abb", "a*b");
		oneCase("aaba", "ab*a*c*a");
		
		oneCase("ab", ".*c");
		

	}

}
