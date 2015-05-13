package leetcode.minimum.window.substring;


public class Test
{
	private static void oneCase(String S, String T)
	{
		System.out.println("#########################");
		Solution1 s1 = new Solution1();

		System.out.println( s1.minWindow(S, T) );

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase("a", "aa"); 
		
		oneCase("a", "a"); 
		
		oneCase("bba", "ab");

	
		oneCase("ADOBECODEBANC", "ABC");
	}
}
