package leetcode.reverse.words.string;

public class Test
{

	private static void oneCase(String s)
	{
		System.out.println("#####################");
		Solution1 sol = new Solution1();
		System.out.println("[" + sol.reverseWords(s) + "]");
		
		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		/**/
		oneCase("");
		oneCase("a");
		oneCase("           ");
		oneCase("    the       blue       ");
		oneCase("the sky is blue");
	}
}
