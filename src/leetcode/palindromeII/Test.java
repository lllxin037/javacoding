package leetcode.palindromeII;


public class Test
{

	private static void oneCase(String s)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		System.out.println("min cut: " + sol.minCut(s));
		System.out.println("#####################\n\n");
		
	}

	public static void main(String[] args)
	{
		oneCase("a");
		oneCase("cdd");
		oneCase("aab");
		oneCase("ababbbabbababa");
		
	}
}
