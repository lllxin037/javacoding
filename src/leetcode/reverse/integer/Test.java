package leetcode.reverse.integer;

public class Test
{

	private static void oneCase(int x)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		System.out.println(sol.reverse(x));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		oneCase(123);
		oneCase(321);
		oneCase(-123);
		oneCase(-321);
		
		oneCase(1000000);
		oneCase(2147483647);
		oneCase(-2147483648);		
	}
}
