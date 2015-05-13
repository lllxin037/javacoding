package leetcode.palindrome;

import java.util.ArrayList;

public class Test
{

	private static void oneCase(String s)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		ArrayList<ArrayList<String>> values = sol.partition(s);
		for (int i = 0; i < values.size(); i++)
		{
			System.out.println(values.get(i) );
		}

		System.out.println("#####################\n\n");
		
	}

	public static void main(String[] args)
	{
		oneCase("cdd");
		oneCase("aab");
		oneCase("ababbbabbababa");
		
	}
}
