package roman.integer;


public class Test
{
	private static void oneCase(String s)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println( s1.romanToInt(s) );
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("IV");
		oneCase("VI");
		
		oneCase("CCXLIII"); //243
		oneCase("MDX"); // 1510
		
		oneCase("CXL"); //140
		oneCase("MCMLXXVI"); //1976
	}
}
