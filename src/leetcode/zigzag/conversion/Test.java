package leetcode.zigzag.conversion;

public class Test
{

	private static void oneCase(String s, int nRows)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		System.out.println(sol.convert(s, nRows));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		/**/
		oneCase("PAYPALISHIRING", 1);
		oneCase("PAYPALISHIRING", 2);
		oneCase("PAYPALISHIRING", 3);
		oneCase("PAYPALISHIRING", 4);
		oneCase("PAYPALISHIRING", 5);
	}
}
