package leetcode.length.last.word;

public class Test
{
	private static void oneCase(String s)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.lengthOfLastWord(s));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("Hello world");

		oneCase("a ");
		
		oneCase(" a");
		oneCase("b    a     ");
	}
}
