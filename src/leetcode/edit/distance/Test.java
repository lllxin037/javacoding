package leetcode.edit.distance;


public class Test
{
	private static void oneCase(String word1, String word2)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();
		

		System.out.println( s1.minDistance(word1, word2) );

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/		
		oneCase("", "");
		
		oneCase("", "a"); 
		
		oneCase("a", "aa"); 
		
		oneCase("a", "a"); 
		
		oneCase("bba", "ab");

		oneCase("sea", "ate");
		

		oneCase("ADOBECODEBANC", "ABC");		
	}
}
