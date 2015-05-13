package leetcode.sqrt;

public class Test
{
	private static void oneCase(int x)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.sqrt(x));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(0);

		oneCase(1);
		oneCase(2);
		oneCase(3);
		oneCase(4);
		oneCase(5);

		oneCase(100);
		oneCase(1000);

		oneCase(2147395599);
		
		oneCase(2147483647);
	}
}
