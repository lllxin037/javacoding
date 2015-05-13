package leetcode.generate.parentheses;

import java.util.List;

public class Test
{

	private static void oneCase(int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<String> combinations = s1.generateParenthesis(n);
		for (int i = 0; i < combinations.size(); i++)
			System.out.println(combinations.get(i));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(0);
		
		oneCase(1);
		oneCase(2);
		oneCase(3);
		oneCase(4);
		oneCase(5);
	}
}
