package leetcode.climbing.stairs;

public class Test
{
	private static void oneCase(int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.climbStairs(n));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(1);

		oneCase(2);

		oneCase(3);

		oneCase(4);

		oneCase(5);

		oneCase(10);
	}
}
