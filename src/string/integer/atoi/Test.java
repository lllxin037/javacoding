package string.integer.atoi;

public class Test
{

	private static void oneCase(String s)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		System.out.println(sol.atoi(s));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		oneCase(" -0012a42");
		oneCase("2147483648");
		oneCase("-2147483648");
		oneCase("-2147483649");
	}
}
