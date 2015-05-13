package leetcode.integer.roman;

public class Test
{
	private static void oneCase(int num)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.intToRoman(num));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(4);
		oneCase(6);

		oneCase(243); // "CCXLIII"
		oneCase(1510); // "MDX"

		oneCase(140); // "CXL"
		oneCase(1976); // "MCMLXXVI"
	}
}
