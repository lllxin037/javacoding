package wildcard.matching;

public class Test
{
	private static void oneCase(String s, String p)
	{
		System.out.println("#########################");
		GreedySolution s1 = new GreedySolution();

		System.out.println(s1.isMatch(s, p));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		// isMatch("aa","a") ¡ú false
		// isMatch("aa","aa") ¡ú true
		// isMatch("aaa","aa") ¡ú false
		// isMatch("aa", "*") ¡ú true
		// isMatch("aa", "a*") ¡ú true
		// isMatch("ab", "?*") ¡ú true
		// isMatch("aab", "c*a*b") ¡ú false


	
		System.out.println("***************TRUE***************");
		/*	

		oneCase("aa","aa");		
		oneCase("abb", "a*b");
		oneCase("c", "*?*");
		oneCase("","*");
		oneCase("aa","*");
		oneCase("aa","a*");
		oneCase("ab","?*");*/
		oneCase("aba","*a*");

		System.out.println("***************FALSE***************");
		oneCase("ab","*a");
		oneCase("","?");
		oneCase("","*?");
		oneCase("aa","a");
		oneCase("aaa","aa");
		oneCase("aab","c*a*b");
	}

}
