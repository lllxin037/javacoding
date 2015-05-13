package leetcode.compare.version.numbers;

public class Test
{
	private static void oneCase(String v1, String v2)
	{
		System.out.println("#########################");
		SplitSolution s1 = new SplitSolution();

		System.out.println(s1.compareVersion(v1, v2));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("1", "0");
		oneCase("1.0", "1");

		oneCase("01", "1");

		oneCase("1.0", "1.1");

	}
}
