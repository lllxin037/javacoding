package leetcode.excel.sheet.column;

public class Test
{

	private static void oneCase(int n)
	{
		Solution s = new Solution();
		System.out.println(s.convertToTitle(n));
	}

	public static void main(String[] args)
	{
		oneCase(1);
		oneCase(26);
		oneCase(28);
		oneCase(56);
		oneCase(52);
	}
}
