package leetcode.scramble.string;


public class Test
{
	private static void oneCase(String s1, String s2)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		System.out.println(s.isScramble(s1, s2));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("ab", "ba");		
		oneCase("abc", "bca");		
		oneCase("abcd", "bdca"); 
		oneCase("abcd", "badc");
		
		oneCase("rgtae", "great");
		oneCase("abbbcbaaccacaacc","acaaaccabcabcbcb");
	}
}
