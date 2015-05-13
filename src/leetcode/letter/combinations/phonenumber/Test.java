package leetcode.letter.combinations.phonenumber;

import java.util.List;

public class Test
{
	private static void oneCase(String digits)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<String> combinations = s1.letterCombinations(digits);
		for (int i = 0; i < combinations.size(); i++)
			System.out.println(combinations.get(i));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("");
		
		oneCase("2");

		oneCase("23");

		oneCase("234");
	}
}
