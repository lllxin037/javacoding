package leetcode.palindrome.number;

public class Test
{

	private static void oneCase(int x)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		System.out.println(sol.isPalindrome(x));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		oneCase(1);
		oneCase(5445);
		oneCase(2147447412);
		oneCase(1000000001);

		oneCase(13100);
		oneCase(10000021);
		oneCase(120030221);
		oneCase(-1);
		oneCase(-2147447412);
	}
}
