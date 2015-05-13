package leetcode.valid.number;

public class Test
{
	private static void oneCase(String s)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.isNumber(s));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		System.out.println("############valid#############\n\n");
		
		/**/
		oneCase("0");
		oneCase(" 0");
		oneCase("2e10");		
		oneCase(".413");
		oneCase("143.");
		oneCase("89e9");
		oneCase("1.23e4");
		oneCase("+23e-3");
		oneCase(" 0.1 ");
		
		System.out.println("############invalid#############\n\n");
		
		// invalid
		oneCase("92e1740e91");		
		oneCase(".-4");
		oneCase("0e");
		oneCase("abc");
		oneCase("1 a");		
		oneCase("52e4.2");
		oneCase("-788f");
		oneCase("0xFF");
		oneCase("1e1.1");
		oneCase("1e+1.1");
		oneCase(".");	
		oneCase(".e10");
	}
}
