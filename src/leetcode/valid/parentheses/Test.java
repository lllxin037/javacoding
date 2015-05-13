package leetcode.valid.parentheses;

public class Test
{
	private static void oneCase(String s)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.isValid(s));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("[");
		oneCase("([])");
	}
}
