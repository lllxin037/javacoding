package leetcode.pow;

public class Test
{
	private static void oneCase(double x, int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.pow(x, n));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(0, 0);
		oneCase(2, 0);
		oneCase(2, 1);
		oneCase(2, 2);
		oneCase(2, 5);

		// Input: 34.00515, -3
		// Output: 1.00000
		// Expected: 0.00003
		oneCase(34.00515, -3);

	}
}
