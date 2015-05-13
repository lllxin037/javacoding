package leetcode.add.binary;

public class Test
{

	private static void oneCase(String a, String b)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.addBinary(a, b));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("", "10");
		oneCase("11", "");
		oneCase("11", "1");

		oneCase("1011", "110");
	}
}
